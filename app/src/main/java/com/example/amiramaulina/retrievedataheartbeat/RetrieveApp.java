package com.example.amiramaulina.retrievedataheartbeat;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RetrieveApp extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_app);


        DatabaseReference userdatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        DatabaseReference ref = userdatabase.child(user.getUid()).child("hrstate");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Integer hrValue = dataSnapshot.getValue(Integer.class);
                String hrState = dataSnapshot.getValue(String.class);
                String fallState = dataSnapshot.getValue(String.class);
                //TimeStamp hiji deui

                Log.i("user age mainactivity", "user age " + hrState);
                Log.i("user age mainactivity","user age" +hrValue);
                Log.i("user age mainactivity", "user age " + fallState);

                //tampilin ke Layarr tolong astrid

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
