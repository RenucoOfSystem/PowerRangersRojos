package com.nicolegongora.progra3_proyecto.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "menu_employee")
public class MainMenuTask {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "image")
    private int image;
    @ColumnInfo(name = "telephone")
    private int telephone;
    @ColumnInfo(name = "map")
    private String map;
    @ColumnInfo(name = "corporate")
    private String corporate;
    @ColumnInfo(name = "favorite")
    private boolean favorite;

    public MainMenuTask(String title, String name, int image,
                        String description, int telephone,
                        String map, String corporate) {
        this.title =title;
        this.name = name;
        this.description = description;
        this.image = image;
        this.telephone = telephone;
        this.map = map;
        this.corporate = corporate;
        this.favorite=false;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getMainMenuTitle_id() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getMap() {
        return map;
    }

    public String getCorporate() {
        return corporate;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}


