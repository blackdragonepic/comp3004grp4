package com.example.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class Decks extends AppCompatActivity {
    public static ArrayList<Deck> deckList=new ArrayList<Deck>();
    public static Deck DeckViewerHolder;
    public static int deckPosition;
    String[] temp = {"Deck1", "deck2","Deck3","Deck4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks);
        String[] displayer;
        if (deckList.size()==0)
        {
            displayer=new String[1];
            displayer[0]="No decks";
        }
        else
        {
            displayer =toStringArray(deckList);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, displayer);
        //ArrayAdapter<Arr>
        final ListView listView = (ListView) findViewById(R.id.Decklist);
        listView.setAdapter(adapter);

        final Button deckBTNv=(Button)(findViewById(R.id.deckBTN));
        deckBTNv.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v){
                                            startActivity(new Intent(getApplicationContext(),Deck_creator.class));
                                        }
                                    }

        );




        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                if (deckList.size()!=0)
                {
                    DeckViewerHolder=deckList.get(position);
                    deckPosition=position;
                    startActivity(new Intent(getApplicationContext(),Deck_viewer.class));
                }
            }
        };
        listView.setOnItemClickListener(mMessageClickedHandler);
        configureBackButton();
    }
    public void configureBackButton(){
        Button nextButton = (Button) findViewById(R.id.backtomenu);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Decks.this, MainActivity.class));
            }
        });
    }


    String[] toStringArray(ArrayList<Deck> var)
    {
        String[] output = new String[var.size()];

        for (int i =0;i<var.size();i++)
        {
            output[i]=(var.get(i)).getName();
        }
        return output;
    }
    @Override
    protected void onStop() {
        super.onStop();
        FileManager filemanager=new FileManager();
        filemanager.saveDecks(getApplicationContext());

    }
}
