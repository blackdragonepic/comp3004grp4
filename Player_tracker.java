package com.example.thomas.mtgtrackingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by srk_n on 2017-11-26.
 */

public class Player_tracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_tracker);

        final TextView lifeVar=(TextView)(findViewById(R.id.lifetotalnumber));
        final TextView poisonVar=(TextView)(findViewById(R.id.poisonnum));
        final TextView spellsVar=(TextView)(findViewById(R.id.spellsnumber));
        final TextView redVar=(TextView)(findViewById(R.id.RedNum));
        final TextView blueVar=(TextView)(findViewById(R.id.BlueNum));
        final TextView blackVar=(TextView)(findViewById(R.id.BlackNum));
        final TextView whiteVar=(TextView)(findViewById(R.id.WhiteNum));
        final TextView greenVar=(TextView)(findViewById(R.id.GreenNum));

        //nameInputVar.setText("hahah");
        lifeVar.setText(""+gametracker.playerUsed.getLife());
        poisonVar.setText(""+gametracker.playerUsed.getPoison());
        spellsVar.setText(""+gametracker.playerUsed.getSpells());
        redVar.setText(""+(gametracker.playerUsed.getrMana() - gametracker.playerUsed.getrUsed()));
        blueVar.setText(""+(gametracker.playerUsed.getbuMana() - gametracker.playerUsed.getbuUsed()));
        blackVar.setText(""+(gametracker.playerUsed.getbaMana() - gametracker.playerUsed.getbaUsed()));
        whiteVar.setText(""+(gametracker.playerUsed.getwMana() - gametracker.playerUsed.getwUsed()));
        greenVar.setText(""+(gametracker.playerUsed.getgMana() - gametracker.playerUsed.getgUsed()));

        configureBackButton();
        configureLifeTotalAddition();
        configureLifeTotalSubtraction();
        configurePoisonAddition();
        configurePoisonSubtraction();
        SpellSubtraction();
        SpellAddition();
        RollDie();

        whiteClick();
        blackClick();
        blueClick();
        redClick();
        greenClick();

        whiteUse();
        blackUse();
        blueUse();
        redUse();
        greenUse();
        newTurn();
    }
    public void configureBackButton(){
        Button nextButton = (Button) findViewById(R.id.backbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Player_tracker.this, gametracker.class));
            }
        });
    }

    public void configureLifeTotalAddition(){
        Button addition = (Button) findViewById(R.id.lifetotalincrease);
        final TextView lifeCountTotal = (TextView) findViewById(R.id.lifetotalnumber);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lifeValue = lifeCountTotal.getText().toString();
                int intLifeValue = Integer.parseInt(lifeValue);
                intLifeValue++;
                gametracker.playerUsed.setLife(intLifeValue);
                lifeCountTotal.setText(String.valueOf(intLifeValue));
            }
        });
    }

    public void configureLifeTotalSubtraction(){
        Button subtraction = (Button) findViewById(R.id.lifetotaldecrease);
        final TextView lifeCountTotal = (TextView) findViewById(R.id.lifetotalnumber);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lifeValue = lifeCountTotal.getText().toString();
                int intLifeValue = Integer.parseInt(lifeValue);
                intLifeValue--;
                gametracker.playerUsed.setLife(intLifeValue);
                lifeCountTotal.setText(String.valueOf(intLifeValue));
            }
        });
    }

    public void configurePoisonAddition(){
        Button poisonaddition = (Button) findViewById(R.id.poisonincrease);
        final TextView poisonTotal = (TextView) findViewById(R.id.poisonnum);
        poisonaddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poisonValue = poisonTotal.getText().toString();
                int intPoisonValue = Integer.parseInt(poisonValue);
                intPoisonValue++;
                gametracker.playerUsed.setPoison(intPoisonValue);
                poisonTotal.setText(String.valueOf(intPoisonValue));
            }
        });
    }
    public void configurePoisonSubtraction(){
        Button poisonsubtraction = (Button) findViewById(R.id.poisondecrease);
        final TextView poisonTotal = (TextView) findViewById(R.id.poisonnum);
        poisonsubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poisonValue = poisonTotal.getText().toString();
                int intPoisonValue = Integer.parseInt(poisonValue);
                intPoisonValue--;
                gametracker.playerUsed.setPoison(intPoisonValue);
                poisonTotal.setText(String.valueOf(intPoisonValue));
            }
        });
    }

    public void SpellAddition(){
        Button spellAdd = (Button) findViewById(R.id.spellsincrease);
        final TextView spellTotal = (TextView) findViewById(R.id.spellsnumber);
        spellAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spellValue = spellTotal.getText().toString();
                int intSpellValue = Integer.parseInt(spellValue);
                intSpellValue++;
                gametracker.playerUsed.setSpells(intSpellValue);
                spellTotal.setText(String.valueOf(intSpellValue));
            }
        });
    }

    public void SpellSubtraction(){
        Button spellSub = (Button) findViewById(R.id.spellsdecrease);
        final TextView spellTotal = (TextView) findViewById(R.id.spellsnumber);
        spellSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spellValue = spellTotal.getText().toString();
                int intSpellValue = Integer.parseInt(spellValue);
                intSpellValue--;
                gametracker.playerUsed.setSpells(intSpellValue);
                spellTotal.setText(String.valueOf(intSpellValue));
            }
        });
    }

    public void RollDie(){
        Button roll = (Button) findViewById(R.id.DieRoll);
        final TextView dieNum = (TextView) findViewById(R.id.DieTxt);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int dieRoll = rand.nextInt(6) + 1;

                dieNum.setText(String.valueOf(dieRoll));
            }
        });
    }

    public void whiteClick(){
        Button button = (Button) findViewById(R.id.WhiteButton);
        final TextView whiteTotal = (TextView) findViewById(R.id.WhiteNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whiteValue = whiteTotal.getText().toString();
                int intWhiteValue= Integer.parseInt(whiteValue);
                intWhiteValue++;
                gametracker.playerUsed.setwMana(gametracker.playerUsed.getwMana() + 1);
                whiteTotal.setText(String.valueOf(intWhiteValue));
            }
        });
    }

    public void blackClick(){
        Button button = (Button) findViewById(R.id.BlackButton);
        final TextView blackTotal = (TextView) findViewById(R.id.BlackNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blackValue = blackTotal.getText().toString();
                int intBlackValue= Integer.parseInt(blackValue);
                intBlackValue++;
                gametracker.playerUsed.setbaMana(gametracker.playerUsed.getbaMana() + 1);
                blackTotal.setText(String.valueOf(intBlackValue));
            }
        });
    }

    public void blueClick(){
        Button button = (Button) findViewById(R.id.BlueButton);
        final TextView blueTotal = (TextView) findViewById(R.id.BlueNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blueValue = blueTotal.getText().toString();
                int intBlueValue= Integer.parseInt(blueValue);
                intBlueValue++;
                gametracker.playerUsed.setbuMana(gametracker.playerUsed.getbuMana() + 1);
                blueTotal.setText(String.valueOf(intBlueValue));
            }
        });
    }

    public void redClick(){
        Button button = (Button) findViewById(R.id.RedButton);
        final TextView redTotal = (TextView) findViewById(R.id.RedNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String redValue = redTotal.getText().toString();
                int intRedValue= Integer.parseInt(redValue);
                intRedValue++;
                gametracker.playerUsed.setrMana(gametracker.playerUsed.getrMana() + 1);
                redTotal.setText(String.valueOf(intRedValue));
            }
        });
    }

    public void greenClick(){
        Button button = (Button) findViewById(R.id.GreenButton);
        final TextView greenTotal = (TextView) findViewById(R.id.GreenNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greenValue = greenTotal.getText().toString();
                int intGreenValue= Integer.parseInt(greenValue);
                intGreenValue++;
                gametracker.playerUsed.setgMana(gametracker.playerUsed.getgMana() + 1);
                greenTotal.setText(String.valueOf(intGreenValue));
            }
        });
    }


    public void whiteUse(){
        Button button = (Button) findViewById(R.id.WhiteUse);
        final TextView whiteTotal = (TextView) findViewById(R.id.WhiteNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whiteValue = whiteTotal.getText().toString();
                int intWhiteValue= Integer.parseInt(whiteValue);
                intWhiteValue--;
                gametracker.playerUsed.setwUsed(gametracker.playerUsed.getwUsed() + 1);
                whiteTotal.setText(String.valueOf(intWhiteValue));
            }
        });
    }

    public void blackUse(){
        Button button = (Button) findViewById(R.id.BlackUse);
        final TextView blackTotal = (TextView) findViewById(R.id.BlackNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blackValue = blackTotal.getText().toString();
                int intBlackValue= Integer.parseInt(blackValue);
                intBlackValue--;
                gametracker.playerUsed.setbaUsed(gametracker.playerUsed.getbaUsed() + 1);
                blackTotal.setText(String.valueOf(intBlackValue));
            }
        });
    }

    public void blueUse(){
        Button button = (Button) findViewById(R.id.BlueUse);
        final TextView blueTotal = (TextView) findViewById(R.id.BlueNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blueValue = blueTotal.getText().toString();
                int intBlueValue= Integer.parseInt(blueValue);
                intBlueValue--;
                gametracker.playerUsed.setbuUsed(gametracker.playerUsed.getbuUsed() + 1);
                blueTotal.setText(String.valueOf(intBlueValue));
            }
        });
    }

    public void redUse(){
        Button button = (Button) findViewById(R.id.RedUse);
        final TextView redTotal = (TextView) findViewById(R.id.RedNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String redValue = redTotal.getText().toString();
                int intRedValue= Integer.parseInt(redValue);
                intRedValue--;
                gametracker.playerUsed.setrUsed(gametracker.playerUsed.getrUsed() + 1);
                redTotal.setText(String.valueOf(intRedValue));
            }
        });
    }

    public void greenUse(){
        Button button = (Button) findViewById(R.id.GreenUse);
        final TextView greenTotal = (TextView) findViewById(R.id.GreenNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greenValue = greenTotal.getText().toString();
                int intGreenValue= Integer.parseInt(greenValue);
                intGreenValue--;
                gametracker.playerUsed.setgUsed(gametracker.playerUsed.getgUsed() + 1);
                greenTotal.setText(String.valueOf(intGreenValue));
            }
        });
    }

    public void newTurn(){
        Button button = (Button) findViewById(R.id.NewTurn);
        final TextView greenTotal = (TextView) findViewById(R.id.GreenNum);
        final TextView blueTotal = (TextView) findViewById(R.id.BlueNum);
        final TextView redTotal = (TextView) findViewById(R.id.RedNum);
        final TextView blackTotal = (TextView) findViewById(R.id.BlackNum);
        final TextView whiteTotal = (TextView) findViewById(R.id.WhiteNum);
        final TextView spellsTotal = (TextView) findViewById(R.id.spellsnumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenTotal.setText(""+gametracker.playerUsed.getgMana());
                blueTotal.setText(""+gametracker.playerUsed.getbuMana());
                redTotal.setText(""+gametracker.playerUsed.getrMana());
                blackTotal.setText(""+gametracker.playerUsed.getbaMana());
                whiteTotal.setText(""+gametracker.playerUsed.getwMana());
                spellsTotal.setText(String.valueOf(0));

                gametracker.playerUsed.setgUsed(0);
                gametracker.playerUsed.setrUsed(0);
                gametracker.playerUsed.setbuUsed(0);
                gametracker.playerUsed.setbaUsed(0);
                gametracker.playerUsed.setwUsed(0);
                gametracker.playerUsed.setSpells(0);
            }
        });
    }

}
