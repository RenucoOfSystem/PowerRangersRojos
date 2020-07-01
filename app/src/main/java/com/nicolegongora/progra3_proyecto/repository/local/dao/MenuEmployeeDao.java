package com.nicolegongora.progra3_proyecto.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nicolegongora.progra3_proyecto.model.MainMenuTask;

import java.util.List;

@Dao
public interface MenuEmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(MainMenuTask menuEmployee);

    @Query("DELETE FROM menu_employee")
    void deleteAll();

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateFavorite(MainMenuTask task);

    @Query("UPDATE menu_employee SET favorite=favorite WHERE id=:id")
    void  updateFavoriteEntry(long id, boolean favorite);

    @Query("SELECT * FROM menu_employee WHERE favorite=:")
    LiveData<MainMenuTask> getId(long id);

    @Query("SELECT * FROM menu_employee ORDER BY id ASC")
    LiveData<List<MainMenuTask>> getAll();
}
