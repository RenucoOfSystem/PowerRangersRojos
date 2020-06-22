package com.nicolegongora.progra3_proyecto.model;

public class User {

    private String name;
    private String username;
    private transient String password;
    private String email;
    private String type;
    private String corporate;
    private String country;
    private int phone;
    private int age;
    private String ability;



    public User(String name, String username, String password, String email, String country, int phone, int age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
        this.phone = phone;
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public int getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCorporate() {
        return corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate=corporate;
    }

    public void setAbility(String ability) {
        this.ability=ability;
    }

    public String getAbility() {
        return ability;
    }



}
