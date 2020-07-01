package com.nicolegongora.progra3_proyecto.repository.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nicolegongora.progra3_proyecto.model.MainMenuTask;
import com.nicolegongora.progra3_proyecto.repository.local.dao.MenuEmployeeDao;


//ota clase +
@Database(entities = {MainMenuTask.class}, version = 4)
public abstract class MenuDb extends RoomDatabase {
    public abstract MenuEmployeeDao menuEmployeeDao();

    private static volatile MenuDb INSTANCE;

    static public MenuDb getDataBase(final Context context){
        if (INSTANCE == null){
            synchronized (MenuDb.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MenuDb.class, "menu_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
