package com.example.ccmsreportes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ccmsreportes.model.Reportes;

@Database(entities = {Reportes.class},
    version = 1,
    exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase INSTANCE;
    public abstract ReportesDao reportesDao();

    public static AppDatabase getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"baseDeDatos.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
