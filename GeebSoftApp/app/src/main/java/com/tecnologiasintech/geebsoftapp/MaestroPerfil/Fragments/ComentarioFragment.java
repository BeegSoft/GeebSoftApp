package com.tecnologiasintech.geebsoftapp.MaestroPerfil.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnologiasintech.geebsoftapp.MaestroPerfil.Recycler.RecyclerAdapterComentario;
import com.tecnologiasintech.geebsoftapp.R;

/**
 * Created by Sergio on 1/17/2017.
 */

public class ComentarioFragment extends Fragment {
    private RecyclerAdapterComentario mAdapter;

    public ComentarioFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comentarios, container, false);


        // Inflate the layout for this fragment
        //Capture the recyclerView

        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.recyclerView_Comentarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        //Create the Adapter
        mAdapter = new RecyclerAdapterComentario(this.getContext(),recyclerView);

        //Binding
        recyclerView.setAdapter(mAdapter);

        return view;

    }
}
