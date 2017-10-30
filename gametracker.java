package com.example.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gametracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametracker);

        configureBackButton();
        configureLifeTotalAddition();
        configureLifeTotalSubtraction();
        configurePoisonAddition();
        configurePoisonSubtraction();
    }
    public void configureBackButton(){
        Button nextButton = (Button) findViewById(R.id.backbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gametracker.this, MainActivity.class));
            }
        });
    }

    public void configureLifeTotalAddition(){
        Button addition = (Button) findViewById(R.id.lifetotalincrease);
        final TextView lifeCountTotal = (TextView) findViewById(R.id.lifetotalnumber);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lifeValue = lifeCountTotal.getText().toString();
                int intLifeValue = Integer.parseInt(lifeValue);
                intLifeValue++;
                lifeCountTotal.setText(String.valueOf(intLifeValue));
            }
        });
    }

    public void configureLifeTotalSubtraction(){
        Button subtraction = (Button) findViewById(R.id.lifetotaldecrease);
        final TextView lifeCountTotal = (TextView) findViewById(R.id.lifetotalnumber);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lifeValue = lifeCountTotal.getText().toString();
                int intLifeValue = Integer.parseInt(lifeValue);
                intLifeValue--;
                lifeCountTotal.setText(String.valueOf(intLifeValue));
            }
        });
    }

    public void configurePoisonAddition(){
        Button poisonaddition = (Button) findViewById(R.id.poisonincrease);
        final TextView poisonTotal = (TextView) findViewById(R.id.poisonnum);
        poisonaddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poisonValue = poisonTotal.getText().toString();
                int intPoisonValue = Integer.parseInt(poisonValue);
                intPoisonValue++;
                poisonTotal.setText(String.valueOf(intPoisonValue));
            }
        });
    }
    public void configurePoisonSubtraction(){
        Button poisonsubtraction = (Button) findViewById(R.id.poisondecrease);
        final TextView poisonTotal = (TextView) findViewById(R.id.poisonnum);
        poisonsubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poisonValue = poisonTotal.getText().toString();
                int intPoisonValue = Integer.parseInt(poisonValue);
                intPoisonValue--;
                poisonTotal.setText(String.valueOf(intPoisonValue));
            }
        });
    }




}
