package com.nicolegongora.progra3_proyecto.model;

public class RegisButton {
    private long id;
    private String name;
    private int image;

    public RegisButton(long id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
