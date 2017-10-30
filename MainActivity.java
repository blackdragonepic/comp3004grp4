package com.example.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureToSinglePlayerButton();
        configureDeckTrackerButton();
    }
    private void configureToSinglePlayerButton() {
        Button nextButton = (Button) findViewById(R.id.b1tosingleplayer);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, gametracker.class));
            }
        });
    }
    private void configureDeckTrackerButton() {
        Button toDecks = (Button) findViewById(R.id.b2todecktracker);
        toDecks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Decks.class));
            }
        });
    }
}
