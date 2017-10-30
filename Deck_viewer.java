package com.example.thomas.mtgtrackingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Deck_viewer extends AppCompatActivity {
    public static Game GameVewierHolder;
    public static int GamePosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_viewer);

        final TextView nameInputVar=(TextView)(findViewById(R.id.editText));
        final TextView winsInputVar=(TextView)(findViewById(R.id.editText3));
        final TextView losesInputVar=(TextView)(findViewById(R.id.editText5));

        //nameInputVar.setText("hahah");
        nameInputVar.setText(Decks.DeckViewerHolder.getName());
        winsInputVar.setText(""+Decks.DeckViewerHolder.getWins());
        losesInputVar.setText(""+Decks.DeckViewerHolder.getLoses());

        final ArrayList<Game> currentGames=Decks.DeckViewerHolder.getGames();


        String[] displayer;
        if (currentGames.size()==0)
        {
            displayer=new String[1];
            displayer[0]="No games";
        }
        else
        {
            displayer =toStringArray(currentGames);
        }

        final Button BTND=(Button)(findViewById(R.id.button2));
        BTND.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        Decks.deckList.remove(Decks.deckPosition);
                                        startActivity(new Intent(getApplicationContext(),Decks.class));
                                    }
                                }
        );
        final Button BTND2=(Button)(findViewById(R.id.button));
        BTND2.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        currentGames.add(new Game());

                                        GamePosition=currentGames.size()-1;
                                        GameVewierHolder=currentGames.get(GamePosition);
                                        startActivity(new Intent(getApplicationContext(),Game_view.class));
                                    }
                                }
        );

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, displayer);
        //ArrayAdapter<Arr>
        final ListView listView = (ListView) findViewById(R.id.gameList);
        listView.setAdapter(adapter);

        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                if (currentGames.size()==0)
                {
                    currentGames.add(new Game());
                    GameVewierHolder=currentGames.get(0);
                }
                else
                {
                    GameVewierHolder=currentGames.get(position);
                }

                Decks.DeckViewerHolder.setName(nameInputVar.getText().toString());
                Decks.DeckViewerHolder.setWins(Integer.parseInt(winsInputVar.getText().toString()));
                Decks.DeckViewerHolder.setLoses(Integer.parseInt(losesInputVar.getText().toString()));
                startActivity(new Intent(getApplicationContext(),Game_view.class));
            }
        };
        listView.setOnItemClickListener(mMessageClickedHandler);
    }


    String[] toStringArray(ArrayList<Game> temp)
    {
        String[] output= new String[temp.size()];
        for (int i=0;i<temp.size();i++)
        {
            output[i]=temp.get(i).getName();
        }
        return output;
    }

}
