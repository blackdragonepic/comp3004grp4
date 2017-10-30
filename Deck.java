package com.example.group4.myapplication;

import java.util.ArrayList;

/**
 * Created by Thomas on 28/10/2017.
 */

public class Deck {
    Deck()
    {
        wins=0;
        loses=0;
        name="";
        games=new ArrayList<Game>();
    }
    Deck (String name)
    {
        this.name=name;
        wins=0;
        loses=0;
        games=new ArrayList<Game>();
    }
    Deck (String name, int wins, int loses)
    {
        this.name=name;
        this.wins=wins;
        this.loses=loses;
        games=new ArrayList<Game>();
    }
    private int wins, loses;
    private String name;
    public ArrayList<Game> games;

    public void losesInc()
    {
        loses++;
    }
    public void losesDec()
    {
        loses--;
    }
    public void winsInc()
    {
        wins++;
    }
    public void winsDec()
    {
        wins--;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Game> getGames() {
        return games;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setName(String name) {
        this.name = name;
    }
}
