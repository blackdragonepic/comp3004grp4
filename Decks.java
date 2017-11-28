package com.example.thomas.mtgtrackingapp;

import android.content.Context;
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        //readDecks();
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

        final Button deckBTNback=(Button)(findViewById(R.id.button6));
        deckBTNback.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v){
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
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


    }
    @Override
    protected void onStop() {
        super.onStop();

        //saveDecks();
        FileManager filemanager=new FileManager();
        filemanager.saveDecks(getApplicationContext());
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

    boolean saveDecks()
    {
        String FILENAME = "decks_file";
        String string = "";
        string = toStringDecksOutput();
        /*
        try {
            string = toStringDecksOutput();
        }
        catch (Exception e)
        {
            return false;
        }*/
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            return false;
        }


        return true;
    }

    boolean readDecks()
    {
        String FILENAME = "decks_file";
        String input;
        byte[] b=new byte[5000];
        int size=-1;
        try {
            FileInputStream fos = openFileInput(FILENAME);
            //fos.write(string.getBytes());
            size=fos.read(b);
            fos.close();
            if (size!=-1) {
                input = new String(b);
                deckList.clear();
                String[] temp = input.split(" : ");
                for (int i = 0; i < temp.length; i++) {
                    temp[i]=temp[i].replaceAll("::",":");
                    String[] gameholder=temp[i].split(" / ");
                    String name="";
                    if (gameholder.length>=1) {
                         name = gameholder[0];
                    }
                    String wins="0";
                    if (gameholder.length>=2)
                    {
                    wins=gameholder[1];
                    }
                    String loses="0";
                    if (gameholder.length>=3) {
                        loses = gameholder[2];
                    }
                    String games="";
                    if (gameholder.length>=4) {
                        games = gameholder[3];
                    }
                    deckList.add(new Deck(name,Integer.parseInt(wins),Integer.parseInt(loses),readGame(games)));

                }
            }

        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    ArrayList<Game> readGame(String str)
    {
        ArrayList<Game> output=new ArrayList<Game>(5);

        String[] gamelist=str.split(" ; ");
        for (int i=0;i<gamelist.length-3;i+=4)
        {
            String name=gamelist[i];
            String desc=gamelist[i+1];
            String good=gamelist[i+2];
            String bad=gamelist[i+3];
            name=name.replaceAll(";;",";");
            desc=desc.replaceAll(";;",";");
            good=good.replaceAll(";;",";");
            bad=bad.replaceAll(";;",";");
            output.add(new Game(name,desc,good,bad));
        }

        return output;
    }
    String toStringDecksOutput()
    {
        String output="";
        if (deckList.size()>0)
        {
            Deck temp = deckList.get(0);
            String name = temp.getName();
            String wins = temp.getWins() + "";
            String loses = temp.getLoses() + "";
            String games=toStringGames(temp.getGames());
            output += name.replaceAll("/","//")
                    +" / "+wins.replaceAll("/","//")
                    +" / "+loses.replaceAll("/","//")
                    +" / "+games.replaceAll("/","//");
            output=output.replaceAll(" : ","::");

        }

        for (int i=1;i<deckList.size();i++) {
            output+=" : ";
            String temp2;
            Deck temp = deckList.get(i);
            String name = temp.getName();
            String wins = temp.getWins() + "";
            String loses = temp.getLoses() + "";
            String games=toStringGames(temp.getGames());
            temp2 = name.replaceAll("/","//")
                    +" / "+wins.replaceAll("/","//")
                    +" / "+loses.replaceAll("/","//")
                    +" / "+games.replaceAll("/","//");
            output+=temp2.replaceAll(" : ","::");

        }

        return output;
    }

    String toStringGames(ArrayList<Game> games)
    {
        String output="";
        for (int i=0;i<games.size();i++)
        {
            Game temp=games.get(i);
            String name =temp.getName();
            String bad=temp.getBadCards();
            String good=temp.getGoodCards();
            String desc = temp.getDesc();

            output+=" ; "+name.replaceAll(";",";;")
                    +" ; "+desc.replaceAll(";",";;")
                    +" ; "+good.replaceAll(";",";;")
                    +" ; "+bad.replaceAll(";",";;");
            ;
        }
        return "";
    }
}
