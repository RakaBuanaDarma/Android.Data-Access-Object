package com.dao.database.barang;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "barang")
public class Barang implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int barangId;

    @ColumnInfo(name = "nama_barang")
    public String namaBarang;

    @ColumnInfo(name = "harga_barang")
    public String hargaBarang;

    public int getBarangId() {
        return barangId;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setBarangId(int barangId) {
        this.barangId = barangId;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
