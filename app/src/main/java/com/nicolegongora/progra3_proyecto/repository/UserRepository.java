package com.nicolegongora.progra3_proyecto.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private SharedPreferences preferences;
    private List<User> users = new ArrayList<>();

    public User login(String username, String password){
        for (User user: users){
            if (user.getUsername().equals(username)&& user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public UserRepository(Context context){
        preferences= PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void register(User user){
        users.add(user);
    }

    public void setUserLogged(User userLogged){
        String userLoggedString= new Gson().toJson(userLogged);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",userLoggedString);
        editor.apply();
    }

    public User getUserLogged(){
        if (preferences.contains("user")){
            String userLoggedString= preferences.getString("user",null);
            if (userLoggedString!=null){
                User userLogged= new Gson().fromJson(userLoggedString,User.class);
                return userLogged;
            }
        }
        return null;
    }

    public void deleteUserLogged(){
        SharedPreferences.Editor editor= preferences.edit();
        editor.remove("user");
        editor.apply();
    }

}
