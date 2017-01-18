package com.tecnologiasintech.geebsoftapp;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tecnologiasintech.geebsoftapp.LoginSystem.LoginActivity;
import com.tecnologiasintech.geebsoftapp.MaestroPerfil.MaestroPerfilActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnViews = (Button) findViewById(R.id.btnSwipeViews);
        btnViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MaestroPerfilActivity.class));
            }
        });

//        TextView mUserInformation = (TextView) findViewById(R.id.txtViewUserName);
//        mUserInformation.setText(user.getDisplayName());
//
//        Button mSignOutButton=(Button) findViewById(R.id.sign_out_button);
//
//        mSignOutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.v(TAG,"Sign Out Button Clicked");
//                signOut();
//            }
//        });


    }
    private void signOut(){

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this,LoginActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflates the searchBar
        getMenuInflater().inflate(R.menu.menu_items,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);


        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Perform final Search
                Log.v(TAG,"Query text Sumbmit");

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Text has Changed, apply filtering?
                Log.v(TAG,"OnQueryTextChange: "+ newText);


//                newText = newText.toLowerCase();
//                ArrayList<Maestro> newList = new ArrayList<>();
//
//
//                for (Maestro maestro : recyclerAdapterTeachers.filterMaestros){
//
//                    //Log.v(TAG,"Profesor: "+ maestro.getMaestro_Nombre());
//
//                    String name = maestro.getMaestro_Nombre().toLowerCase();
//                    if(name.contains(newText)){
//
//                        newList.add(maestro);
//                        Log.v(TAG, "Maestro: "+maestro.getMaestro_Nombre());
//                    }
//                }
//
//                mAdapter.setFilter(newList);



                return false;
            }
        });

        return true;
    }
}
