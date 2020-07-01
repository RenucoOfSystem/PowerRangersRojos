package com.nicolegongora.progra3_proyecto.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nicolegongora.progra3_proyecto.model.MainMenuTask;

import java.util.List;

@Dao
public interface MenuEmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(MainMenuTask menuEmployee);

    @Query("DELETE FROM menu_employee")
    void deleteAll();

    @Query("SELECT * FROM menu_employee ORDER BY id ASC")
    LiveData<List<MainMenuTask>> getAll();
}
