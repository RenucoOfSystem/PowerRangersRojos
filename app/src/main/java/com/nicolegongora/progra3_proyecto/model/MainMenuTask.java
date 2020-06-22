package com.nicolegongora.progra3_proyecto.model;

public class MainMenuTask {

    private long id;
    private String mainMenuUserName_id;
    private String mainMenuDescription_id;
    private int mainMenuImage_id;
    private int mainMenuTy_id;
    private int mainMenuBookmark_id;
    private int mainMenuShare_id;

    public MainMenuTask(long id, String mainMenuUserName_id,  int mainMenuImage_id,
                        String mainMenuDescription_id,int mainMenuTy_id,
                        int mainMenuBookmark_id,int mainMenuShare_id) {
        this.id = id;
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


