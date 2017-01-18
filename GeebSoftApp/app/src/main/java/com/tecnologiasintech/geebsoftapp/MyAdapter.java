package com.tecnologiasintech.geebsoftapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnologiasintech.geebsoftapp.MaestroPerfil.MaestroPerfilActivity;

import java.util.ArrayList;

/**
 * Created by Sergio on 1/18/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    Context c;
    ArrayList<Maestros> maestroses;
    private static final String TAG =  MyAdapter.class.getSimpleName();

    public MyAdapter(Context c, ArrayList<Maestros> maestroses){
        this.c=c;
        this.maestroses=maestroses;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.view_maestro,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Maestros m = maestroses.get(position);

        holder.nameTxt.setText(m.getMaestroNombre());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                //Open Perfil del Maestro
                Log.v(TAG, m.getMaestroNombre());


                Intent intent;
                intent = new Intent(c, MaestroPerfilActivity.class);
                intent.putExtra("Maestro_Nombre",m.getMaestroNombre());

                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return maestroses.size();
    }
}
