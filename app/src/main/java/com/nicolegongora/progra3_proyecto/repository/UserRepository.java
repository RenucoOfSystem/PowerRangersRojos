package com.nicolegongora.progra3_proyecto.repository;

import com.nicolegongora.progra3_proyecto.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    private List<User> users = new ArrayList<>();

    public static UserRepository getInstance(){
        if (instance==null){
            instance= new UserRepository();
        }
        return instance;
    }

   public User login(String username, String password){
        for (User user: users){
            if (user.getName().equals(username)&& user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
   }

   private UserRepository(){

   }

   public void register(User user){
        users.add(user);
   }

}
