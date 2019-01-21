package com.example.demo.model;

public class UserKey {
    private Integer id;

    private String name;

    private String email;

    public Integer getId() {
        return 
                this.id = id ;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}