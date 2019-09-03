
package com.dao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.dao.database.AppDatabase;
import com.dao.database.barang.Barang;

public class Main_Activity extends AppCompatActivity implements
        View.OnClickListener {

    private AppDatabase appDB;
    private Barang barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tambah Barang
        appDB = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "barangdb"
        ).build();

        barang = new Barang();
        barang.setNamaBarang("Mizon Rasa Leci");
        barang.setHargaBarang("6,500");

        new AsyncTask<Void, Void, Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long insertBarangStatus = appDB.barang_dao().insertBarang(barang);
                return insertBarangStatus;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(
                        getApplicationContext(),
                        "Status Insert Baris Ke-"+status, Toast.LENGTH_LONG
                ).show();
            }
        }.execute();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tv_view_barang :
                startActivity(new Intent(getApplicationContext(), Barang_Activity.class));
                break;
        }
    }
}
