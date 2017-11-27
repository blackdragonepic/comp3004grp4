package com.bsdomain.mtgapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

/**
 * Created by srk_n on 2017-11-26.
 */

public class Probability extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probability);

        configureBackButton();
        configureCalcButton();

    }

    public void configureBackButton(){
        Button nextButton = (Button) findViewById(R.id.backBTN);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Probability.this, gametracker.class));
            }
        });
    }

    public void configureCalcButton(){
        Button nextButton = (Button) findViewById(R.id.probBTN);
        final EditText occurences = (EditText) findViewById(R.id.numberInput);
        final EditText deckSize = (EditText) findViewById(R.id.sizeInput);
        final TextView prob = (TextView) findViewById(R.id.probability);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float probUsed = (Float.parseFloat(occurences.getText().toString()) / Float.parseFloat(deckSize.getText().toString())) * 100;
                String strUsed = "" + probUsed + "%";

                prob.setText(strUsed);
            }
        });
    }
}
