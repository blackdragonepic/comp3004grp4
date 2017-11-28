package com.bsdomain.mtgapp;

/**
 * Created by srk_n on 2017-11-26.
 */

public class Player {
    Player(){
        life = 20;
        poison = 0;
        spells = 0;

        rMana = 0;
        buMana = 0;
        baMana = 0;
        wMana = 0;
        gMana = 0;

        rUsed = 0;
        buUsed = 0;
        baUsed = 0;
        wUsed = 0;
        gUsed = 0;

        name="";
    }

    Player (String name) {
        life = 20;
        poison = 0;
        spells = 0;

        rMana = 0;
        buMana = 0;
        baMana = 0;
        wMana = 0;
        gMana = 0;

        rUsed = 0;
        buUsed = 0;
        baUsed = 0;
        wUsed = 0;
        gUsed = 0;

        this.name=name;
    }

    private int life, poison, spells;
    private int rMana, buMana, baMana, wMana, gMana;
    private int rUsed, buUsed, baUsed, wUsed, gUsed;
    private String name;

    public int getLife() {
        return life;
    }

    public int getPoison() {
        return poison;
    }

    public int getSpells() {
        return spells;
    }

    public int getrMana() {
        return rMana;
    }

    public int getbuMana() {
        return buMana;
    }

    public int getbaMana() {
        return baMana;
    }

    public int getgMana() {
        return gMana;
    }

    public int getwMana() {
        return wMana;
    }

    public int getrUsed() {
        return rUsed;
    }

    public int getbuUsed() {
        return buUsed;
    }

    public int getbaUsed() {
        return baUsed;
    }

    public int getgUsed() {
        return gUsed;
    }

    public int getwUsed() {
        return wUsed;
    }


    public String getName() {
        return name;
    }

    public void setLife(int l) {
        life = l;
    }

    public void setPoison(int p) {
        poison = p;
    }

    public void setSpells(int s) {
        spells = s;
    }

    public void setrMana(int m) {
        rMana = m;
    }

    public void setbuMana(int m) {
        buMana = m;
    }

    public void setbaMana(int m) {
        baMana = m;
    }

    public void setgMana(int m) {
        gMana = m;
    }

    public void setwMana(int m) {
        wMana = m;
    }

    public void setrUsed(int m) {
        rUsed = m;
    }

    public void setbuUsed(int m) {
        buUsed = m;
    }

    public void setbaUsed(int m) {
        baUsed = m;
    }

    public void setgUsed(int m) {
        gUsed = m;
    }

    public void setwUsed(int m) {
        wUsed = m;
    }

    public void setName(String name) {
        this.name = name;
    }
}
