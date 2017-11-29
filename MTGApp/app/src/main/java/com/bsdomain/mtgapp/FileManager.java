package com.bsdomain.mtgapp;

import android.content.Context;
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

/**
 * Created by Thomas on 15/11/2017.
 */

public class FileManager {
    public String[] toStringArray(ArrayList<Deck> var)
    {
        String[] output = new String[var.size()];

        for (int i =0;i<var.size();i++)
        {
            output[i]=(var.get(i)).getName();
        }
        return output;
    }

    public boolean saveDecks(Context context)
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
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            //FileOutputStream foz=
            fos.write(string.getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            return false;
        }


        return true;
    }

    public boolean readDecks(Context context)
    {
        String FILENAME = "decks_file";
        String input;
        byte[] b=new byte[5000];
        int size=-1;
        try {
            FileInputStream fos = context.openFileInput(FILENAME);


            //fos.write(string.getBytes());
            size=fos.read(b);
            fos.close();
            if (size!=-1) {
                input = new String(b);
                input=input.substring(0,size);
                Decks.deckList.clear();
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
                    Decks.deckList.add(new Deck(name,Integer.parseInt(wins),Integer.parseInt(loses),readGame(games)));

                }
            }

        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private ArrayList<Game> readGame(String str)
    {
        ArrayList<Game> output=new ArrayList<Game>(5);
        try {
            if (str.length()==0)
            {return output;}
            String[] gamelist = str.split(" ! ");

            for (int i = 0; i < gamelist.length; i++) {
                gamelist[i] = gamelist[i].replaceAll("!!", "!");
                String[] holder = gamelist[i].split(" ; ");

                String name = holder[0];
                String desc = holder[1];
                String good = holder[2];
                String bad = holder[3];
                String wins = holder[4];
                name = name.replaceAll(";;", ";");
                desc = desc.replaceAll(";;", ";");
                good = good.replaceAll(";;", ";");
                bad = bad.replaceAll(";;", ";");
                output.add(new Game(name, desc, good, bad, wins));
            }
        }
        catch (Exception e)
        {

        }
        return output;
    }
    public String toStringDecksOutput()
    {
        String output="";
        if (Decks.deckList.size()>0)
        {
            Deck temp = Decks.deckList.get(0);
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

        for (int i=1;i<Decks.deckList.size();i++) {
            output+=" : ";
            String temp2;
            Deck temp = Decks.deckList.get(i);
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

    public String toStringGames(ArrayList<Game> games)
    {
        String output="";
        String holder="";
        for (int i=0;i<games.size();i++)
        {
            Game temp=games.get(i);
            String name =temp.getName();
            String bad=temp.getBadCards();
            String good=temp.getGoodCards();
            String desc = temp.getDesc();
            String result=temp.getWin()+"";
            holder=name.replaceAll(";",";;")
                    +" ; "+desc.replaceAll(";",";;")
                    +" ; "+good.replaceAll(";",";;")
                    +" ; "+bad.replaceAll(";",";;")
                    +" ; "+result;
            holder=holder.replaceAll("!","!!");

            output+=holder+" ! ";
            ;
        }
        if (output.length()>0)
        {
            output=output.substring(0,output.length()-3);
        }
        return output;
    }
}