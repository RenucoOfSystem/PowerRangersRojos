package com.nicolegongora.progra3_proyecto.repository.local;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nicolegongora.progra3_proyecto.model.MainMenuTask;
import com.nicolegongora.progra3_proyecto.repository.local.db.MenuDb;

import java.util.List;

public class MenuRepositoryEmployee {
    private MenuDb db;

    public MenuRepositoryEmployee(Application application){
        db = MenuDb.getDataBase(application);
    }
        public void insert(final MainMenuTask task){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    db.menuEmployeeDao().insert(task);
                }
            });
            thread.start(); 
        }

        public void deleteAll(){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    db.menuEmployeeDao().deleteAll();
                }
            });
            thread.start();         }

        public LiveData<List<MainMenuTask>> getAll(){
            return db.menuEmployeeDao().getAll();
        }
        public LiveData<MainMenuTask> getById(long id){
        return db.menuEmployeeDao().getById(id);
        }

    public void updateEntry(final MainMenuTask taskselected) {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                db.menuEmployeeDao().updateFavorite(taskselected);
            }
        });
        thread.start();
    }
    public LiveData<List<MainMenuTask>> getFavo(){
        return db.menuEmployeeDao().getFav(true);
    }


}

