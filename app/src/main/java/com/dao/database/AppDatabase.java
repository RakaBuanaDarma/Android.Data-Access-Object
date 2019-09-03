package com.dao.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dao.database.barang.Barang;
import com.dao.database.barang.Barang_DAO;


@Database(entities = {Barang.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract Barang_DAO barang_dao();
}
