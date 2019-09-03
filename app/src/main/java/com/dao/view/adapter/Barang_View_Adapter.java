package com.dao.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dao.R;
import com.dao.database.barang.Barang;

import java.util.ArrayList;

public class Barang_View_Adapter extends RecyclerView.Adapter<Barang_View_Adapter.ViewHolder> {

    private ArrayList<Barang> barang;

    public Barang_View_Adapter(ArrayList<Barang> barang) {
        this.barang = barang;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nama_barang;
        TextView tv_harga_barang;
        TextView tv_id_barang;

        public ViewHolder(View view) {

            super(view);
            this.tv_nama_barang     = (TextView) view.findViewById(R.id.tv_nama_barang);
            this.tv_harga_barang    = (TextView) view.findViewById(R.id.tv_harga_barang);
            this.tv_id_barang    = (TextView) view.findViewById(R.id.tv_id_barang);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_barang, parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id_barang.setText(barang.get(position).getBarangId()+"");
        holder.tv_nama_barang.setText(barang.get(position).getNamaBarang()+"");
        holder.tv_harga_barang.setText(barang.get(position).getHargaBarang()+"");
    }

    @Override
    public int getItemCount() {
        return barang.size();
    }
}
