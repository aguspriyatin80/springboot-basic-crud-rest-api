package com.springbootdarinol.springbootdarinol.model;


public class Hero {

    private int id;

    private String name;
    private int damage;

    private Boolean isMarriage;

    public Boolean getMarriage() {
        return isMarriage;
    }

    public void setMarriage(Boolean marriage) {
        isMarriage = marriage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Hero(int id, String name, int damage, Boolean isMarriage) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.isMarriage = isMarriage;
    }

    public Hero() {
    }
}

