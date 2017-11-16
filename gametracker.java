package com.example.group4.myapplication;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import java.util.Random;

public class gametracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametracker);

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
                startActivity(new Intent(gametracker.this, MainActivity.class));
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
                greenTotal.setText(String.valueOf(0));
                blueTotal.setText(String.valueOf(0));
                redTotal.setText(String.valueOf(0));
                blackTotal.setText(String.valueOf(0));
                whiteTotal.setText(String.valueOf(0));
                spellsTotal.setText(String.valueOf(0));
            }
        });
    }
}