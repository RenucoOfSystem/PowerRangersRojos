package com.nicolegongora.progra3_proyecto.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "menu_employer")
public class MainMenuEmployer {
    //Se incrementara solo?? preguntar
    //@PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "name")
    private String mainMenuUserName_id;
    @ColumnInfo(name = "descrptiom")
    private String mainMenuDescription_id;
    @ColumnInfo(name = "image")
    private int mainMenuImage_id;
    @ColumnInfo(name = "edit")
    private int mainMenuEdit_id;

    public MainMenuEmployer(long id, String mainMenuUserName_id,  int mainMenuImage_id,
                        String mainMenuDescription_id,int mainMenuEdit_id) {
        this.id = id;
        this.mainMenuUserName_id = mainMenuUserName_id;
        this.mainMenuDescription_id = mainMenuDescription_id;
        this.mainMenuImage_id = mainMenuImage_id;
        this.mainMenuEdit_id = mainMenuEdit_id;

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMainMenuUserName_id() {
        return mainMenuUserName_id;
    }

    public void setMainMenuUserName_id(String mainMenuUserName_id) {
        this.mainMenuUserName_id = mainMenuUserName_id;
    }

    public String getMainMenuDescription_id() {
        return mainMenuDescription_id;
    }

    public void setMainMenuDescription_id(String mainMenuDescription_id) {
        this.mainMenuDescription_id = mainMenuDescription_id;
    }

    public int getMainMenuImage_id() {
        return mainMenuImage_id;
    }

    public void setMainMenuImage_id(int mainMenuImage_id) {
        this.mainMenuImage_id = mainMenuImage_id;
    }

    public void setMainMenuEdit_id(int mainMenuEdit_id) {
        this.mainMenuEdit_id = mainMenuEdit_id;
    }

    public int getMainMenuEdit_id() {
        return mainMenuEdit_id;
    }
}
