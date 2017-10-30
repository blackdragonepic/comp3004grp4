package com.example.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Game_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);


        final TextView nameInputVar=(TextView)(findViewById(R.id.editText2));
        final TextView descInputVar=(TextView)(findViewById(R.id.editText4));
        final TextView goodCardsInputVar=(TextView)(findViewById(R.id.editText6));
        final TextView badCardsInputVar=(TextView)(findViewById(R.id.editText7));
        final CheckBox check = (CheckBox) (findViewById(R.id.checkBox));
        if (Deck_viewer.GameVewierHolder.getWin()==1)
        {
            check.setChecked(true);
        }
        else
        {
            check.setChecked(false);
        }

        nameInputVar.setText(Deck_viewer.GameVewierHolder.getName());
        descInputVar.setText(Deck_viewer.GameVewierHolder.getDesc());
        goodCardsInputVar.setText(Deck_viewer.GameVewierHolder.getGoodCards());
        badCardsInputVar.setText(Deck_viewer.GameVewierHolder.getBadCards());


        final Button BTND2=(Button)(findViewById(R.id.button3));
        BTND2.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v){
                                         Deck_viewer.GameVewierHolder.setName(nameInputVar.getText().toString());
                                         Deck_viewer.GameVewierHolder.setDesc(descInputVar.getText().toString());
                                         Deck_viewer.GameVewierHolder.setGoodCards(goodCardsInputVar.getText().toString());
                                         Deck_viewer.GameVewierHolder.setBadCards(badCardsInputVar.getText().toString());
                                         startActivity(new Intent(getApplicationContext(),Deck_viewer.class));

                                         if (check.isChecked())
                                         {
                                             Deck_viewer.GameVewierHolder.setWin(1);
                                             Decks.DeckViewerHolder.winsInc();
                                         }
                                         else
                                         {
                                             Deck_viewer.GameVewierHolder.setWin(0);
                                             Decks.DeckViewerHolder.losesInc();
                                         }
                                     }
                                 }
        );

        final Button BTND=(Button)(findViewById(R.id.button4));
        BTND.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        Decks.DeckViewerHolder.getGames().remove(Deck_viewer.GamePosition);
                                        startActivity(new Intent(getApplicationContext(),Deck_viewer.class));
                                    }
                                }
        );

    }
}
