package com.example.monadarticle.authentication;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;

public class BasicAccessControl implements AccessControl{

    @Override
    public boolean signIn(String username, String password){
        if (username ==  null || username.isEmpty()) {
            return false;
        }

        if (!username.equals(password)) {
            return false;
        }

        CurrentUser.set(username);
        return true;
    }

    @Override
    public boolean isUserSignedIn() { return !CurrentUser.get().isEmpty(); }

    @Override
    public boolean isUserInRole(String role) {
        // Only the admin user can be in the admin role
        if ("admin".equals(role)) {
            return getPrincipalName().equals("admin");
        }
        // accept all users which are in non-admin role
        return true;
    }

    @Override
    public String getPrincipalName() { return CurrentUser.get(); }

    @Override
    public void signOut() {
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().navigate("");
    }
}
