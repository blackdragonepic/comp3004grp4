package com.bsdomain.mtgapp;

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

public class gametracker extends AppCompatActivity {
    public static ArrayList<Player> playerList=new ArrayList<Player>();
    public static Player playerUsed;
    public static int playerPos;

    //String[] temp = {"Player 1", "Player 2", "Player 3", "Player 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametracker);
        String[] displayer;
        if (playerList.size()==0)
        {
            displayer = new String[1];
            displayer[0] = "No Players In Game Yet";
        }
        else
        {
            displayer = toStringArray(playerList);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, displayer);
        //ArrayAdapter<Arr>
        final ListView listView = (ListView) findViewById(R.id.PlayerList);
        listView.setAdapter(adapter);

        final Button AddPlayerBtn=(Button)(findViewById(R.id.AddPlayer));
             AddPlayerBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String strUsed = "Player " + Integer.toString(MainActivity.players);
                    gametracker.playerList.add(new Player(strUsed));
                    MainActivity.players++;

                    //adapter.add(strUsed);
                    //listView.setAdapter(adapter);
                    String[] newDisplayer;
                    newDisplayer = toStringArray(playerList);
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(gametracker.this,
                            android.R.layout.simple_list_item_1, newDisplayer);
                    listView.setAdapter(adapter);
                }
            }
        );




        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                if (playerList.size() != 0)
                {
                    playerUsed = playerList.get(position);
                    playerPos = position;
                    startActivity(new Intent(getApplicationContext(), Player_tracker.class));
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
                startActivity(new Intent(gametracker.this, MainActivity.class));
            }
        });
    }


    String[] toStringArray(ArrayList<Player> var)
    {
        String[] output = new String[var.size()];

        for (int i =0;i<var.size();i++)
        {
            output[i]=(var.get(i)).getName();
        }
        return output;
    }
}