package com.tecnologiasintech.geebsoftapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mUserInformation = (TextView) findViewById(R.id.txtViewUserName);
        mUserInformation.setText(user.getDisplayName());

        Button mSignOutButton=(Button) findViewById(R.id.sign_out_button);

        mSignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG,"Sign Out Button Clicked");
                signOut();
            }
        });


    }
    private void signOut(){

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this,LoginActivity.class));

    }
}
