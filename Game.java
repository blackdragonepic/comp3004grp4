package com.example.thomas.mtgtrackingapp;

/**
 * Created by Thomas on 28/10/2017.
 */

public class Game {
    private String desc;
    private String name;
    //wins should be either a 1 for win or a 0 for loss
    private int win;
    private String goodCards;
    private String badCards;

    Game()
    {
        name="";
        desc="";
        win=1;
        goodCards="";
        badCards="";
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setGoodCards(String goodCards) {
        this.goodCards = goodCards;
    }

    public void setBadCards(String badCards) {
        this.badCards = badCards;
    }

    public String getDesc() {
        return desc;
    }

    public int getWin() {
        return win;
    }

    public String getGoodCards() {
        return goodCards;
    }

    public String getBadCards() {
        return badCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
