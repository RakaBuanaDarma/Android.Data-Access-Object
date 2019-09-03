package com.dao;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.dao.database.AppDatabase;
import com.dao.database.barang.Barang;
import com.dao.view.adapter.Barang_View_Adapter;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Barang_Activity extends AppCompatActivity {

    private AppDatabase appDB;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Barang> barang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_barang);

        appDB = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "barangdb").allowMainThreadQueries().build();;

        recyclerView    = (RecyclerView) findViewById(R.id.rv_view_barang);
        layoutManager   = new LinearLayoutManager(this);
        barang          = new ArrayList<>();
        initData();

        recyclerView.setLayoutManager(layoutManager);
        adapter = new Barang_View_Adapter(barang);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        barang.addAll(Arrays.asList(appDB.barang_dao().fetchAllBarang()));
    }
}
