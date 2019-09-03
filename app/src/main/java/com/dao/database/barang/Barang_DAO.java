package com.dao.database.barang;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface Barang_DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertBarang(Barang barang);

    @Update
    int updateBarang(Barang barang);

    @Delete
    int deleteBarang(Barang barang);

    @Query("SELECT * FROM barang")
    Barang[] fetchAllBarang();

    @Query("SELECT * FROM barang WHERE barangId =:id LIMIT 1")
    Barang fetchBarang(int id);
}
