package com.example.monadarticle.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "generic_sys_user_id")
    private GenericSysUser genericSysUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    private String title;

    private String description;

    private Date datetime;

    public Article() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime){
        this.datetime = datetime;
    }

    public GenericSysUser getGenericSysUser() {
        return genericSysUser;
    }

    public void setGenericSysUser(GenericSysUser genericSysUser) {
        this.genericSysUser = genericSysUser;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }
}
