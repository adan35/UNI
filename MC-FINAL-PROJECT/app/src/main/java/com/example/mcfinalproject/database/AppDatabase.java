package com.example.mcfinalproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ammar.assignments.database.modelclass.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
