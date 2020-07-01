package com.nicolegongora.progra3_proyecto.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "menu_employee")
public class MainMenuTask {

    //Se incrementara solo?? preguntar
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "name")
    private String mainMenuUserName_id;
    @ColumnInfo(name = "description")
    private String mainMenuDescription_id;
    @ColumnInfo(name = "image")
    private int mainMenuImage_id;
    @ColumnInfo(name = "ty")
    private int mainMenuTy_id;
    @ColumnInfo(name = "bookmark")
    private int mainMenuBookmark_id;
    @ColumnInfo(name = "share")
    private int mainMenuShare_id;
    @ColumnInfo(name = "favorite")
    private boolean favorite;

    public MainMenuTask( String mainMenuUserName_id,  int mainMenuImage_id,
                        String mainMenuDescription_id,int mainMenuTy_id,
                        int mainMenuBookmark_id,int mainMenuShare_id) {
        this.mainMenuUserName_id = mainMenuUserName_id;
        this.mainMenuDescription_id = mainMenuDescription_id;
        this.mainMenuImage_id = mainMenuImage_id;
        this.mainMenuTy_id = mainMenuTy_id;
        this.mainMenuBookmark_id = mainMenuBookmark_id;
        this.mainMenuShare_id = mainMenuShare_id;
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
    public int getMainMenuTy_id() {
        return mainMenuTy_id;
    }

    public void setMainMenuTy_id(int mainMenuTy_id) {
        this.mainMenuTy_id = mainMenuTy_id;
    }
    public int getMainMenuBookmark_id() {
        return mainMenuBookmark_id;
    }

    public void setMainMenuBookmark_id(int mainMenuBookmark_id) {
        this.mainMenuBookmark_id = mainMenuBookmark_id;
    }
    public int getMainMenuShare_id() {
        return mainMenuShare_id;
    }

    public void setMainMenuShare_id(int mainMenuShare_id) {
        this.mainMenuShare_id = mainMenuShare_id;
    }
}


