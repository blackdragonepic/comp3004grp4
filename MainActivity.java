package com.example.thomas.mtgtrackingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    static String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button BTND=(Button)(findViewById(R.id.RandomButton));
        BTND.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        Log.i(TAG,"We clicked it");
                                        BTND.setText("Going to the library");
                                    }
                                }
        );

        final Button LibBTN=(Button)(findViewById(R.id.LibraryBTN));
        LibBTN.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        startActivity(new Intent(getApplicationContext(),Decks.class));
                                    }
                                }
        );

    }
}
