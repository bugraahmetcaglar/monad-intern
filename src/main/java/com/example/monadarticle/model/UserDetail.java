package com.example.monadarticle.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "generic_sys_user_id")
    private GenericSysUser genericSysUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="user_detail_id")
    private List<Article> articles;

    private String name;

    private String surname;

    public UserDetail() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GenericSysUser getGenericSysUser() {
        return genericSysUser;
    }

    public void setGenericSysUser(GenericSysUser genericSysUser) {
        this.genericSysUser = genericSysUser;
    }

    public List<Article> getUserArticles() {
        return articles;
    }

    public void setUserArticle(List<Article> article) {
        this.articles = article;
    }

}
