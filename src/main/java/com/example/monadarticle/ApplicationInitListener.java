package com.example.monadarticle;

import com.example.monadarticle.authentication.AccessControl;
import com.example.monadarticle.authentication.AccessControlFactory;
import com.example.monadarticle.views.auth.LoginLayout;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;


public class ApplicationInitListener implements VaadinServiceInitListener {
    @Override
    public void serviceInit(ServiceInitEvent initEvent){
        final AccessControl accessControl = AccessControlFactory.getInstance().createAccessControl();

        initEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(beforeEnterEvent -> {
                if (!accessControl.isUserSignedIn() && !LoginLayout.class.equals((
                        beforeEnterEvent.getNavigationTarget()
                        )))
                    beforeEnterEvent.rerouteTo(LoginLayout.class);
            });
        });
    }
}
