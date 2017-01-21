package com.tecnologiasintech.geebsoftapp;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Sergio on 1/18/2017.
 */

public class FirebaseHelper {

    private  static final String TAG = FirebaseHelper.class.getSimpleName();
    DatabaseReference db;


    ArrayList<Maestros> maestroses=new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        maestroses.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {

            Maestros maestro=ds.getValue(Maestros.class);
            //Log.v(TAG,"Hello Snapshot" +  maestro.getMaestroNombre());
            //Log.v("Total",""+contador +" datasnapshot "+ dataSnapshot.child("Maestros").getRef()+" getRef:"+ ds.getRef());



            maestroses.add(maestro);
        }



    }

    //READ THEN RETURN ARRAYLIST
    public ArrayList<Maestros> retrieve() {

        Log.v("Listener","retrieve");

        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
                Log.v("Listener","childadded");
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
                Log.v("Listener","childadded");
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
        return maestroses;
    }

}
