package com.tecnologiasintech.geebsoftapp.MaestroPerfil.Fragments;

import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tecnologiasintech.geebsoftapp.MaestroPerfil.Recycler.DataModel.maestroComentarios;

import java.util.ArrayList;

/**
 * Created by Sergio on 1/18/2017.
 */

public class FirebaseComentarioHelper {


    private static final String TAG = "Comentario Fragment";
    DatabaseReference comentarioRef;

    ArrayList<maestroComentarios> maestroComentarioses = new ArrayList<>();

    public FirebaseComentarioHelper(DatabaseReference comentarioRef){
        this.comentarioRef = comentarioRef;
    }

    public ArrayList<maestroComentarios> retrieve(){
        comentarioRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return maestroComentarioses;
    }


    private void fetchData(DataSnapshot dataSnapshot){

        maestroComentarioses.clear();

        for(DataSnapshot comentarioRef : dataSnapshot.getChildren()){
            maestroComentarios maestroComentario = comentarioRef.getValue(maestroComentarios.class);

            Log.v(TAG,maestroComentario.getUsuarioComentario());

            maestroComentarioses.add(maestroComentario);
        }
    }
}
