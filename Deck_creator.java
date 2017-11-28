package com.example.thomas.mtgtrackingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Deck_creator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_creator);


        final Button saveDeckBTNvar=(Button)(findViewById(R.id.saveDeckBTN));
        saveDeckBTNvar.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v){
                                            final TextView nameInputVar=(TextView)(findViewById(R.id.nameInput));
                                            final TextView winsInputVar=(TextView)(findViewById(R.id.winsInput));
                                            final TextView losesInputVar=(TextView)(findViewById(R.id.losesInput));
                                            Decks.deckList.add(new Deck(
                                                    nameInputVar.getText().toString()
                                                    ,Integer.parseInt(winsInputVar.getText().toString())
                                                    ,Integer.parseInt(losesInputVar.getText().toString())));
                                            startActivity(new Intent(getApplicationContext(),Decks.class));
                                        }
                                    }
        );

        final Button cancelBTNvar=(Button)(findViewById(R.id.cancelBTN));
        cancelBTNvar.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v){
                                            startActivity(new Intent(getApplicationContext(),Decks.class));
                                        }
                                    }
        );

    }
}
