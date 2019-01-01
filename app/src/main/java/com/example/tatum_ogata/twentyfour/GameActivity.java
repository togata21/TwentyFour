package com.example.tatum_ogata.twentyfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    //xml widgets
    Button lillyPad1;
    Button lillyPad2;
    Button lillyPad3;
    Button lillyPad4;
    TextView totalText;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    TextView winText;
    Button reset;

    LillyPad pad1;
    LillyPad pad2;
    LillyPad pad3;
    LillyPad pad4;

    int total;
    String preOperation;
    int numClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        preOperation = "";
        total = 0;
        numClicked = 0;

        totalText = findViewById(R.id.equationText);
        totalText.setText(total+"");
        winText = findViewById(R.id.youWinText);
        winText.setText("");

        lillyPad1 = findViewById(R.id.lilly_pad_1);
        pad1 = new LillyPad(lillyPad1, (int)(Math.random()*8)+1);
        lillyPad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = pad1.newTotal(total, preOperation);
                totalText.setText(total+"");
                numClicked += 1;
                if (numClicked == 4){
                    if (total == 24)
                        winText.setText("You Win");
                    else
                        winText.setText("You Lose");
                }
            }
        });

        lillyPad2 = findViewById(R.id.lilly_pad_2);
        pad2 = new LillyPad(lillyPad2, (int)(Math.random()*8)+1);
        lillyPad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = pad2.newTotal(total, preOperation);
                totalText.setText(total+"");
                numClicked += 1;
                if (numClicked == 4){
                    if (total == 24)
                        winText.setText("You Win");
                    else
                        winText.setText("You Lose");
                }
            }
        });

        lillyPad3 = findViewById(R.id.lilly_pad_3);
        pad3 = new LillyPad(lillyPad3, (int)(Math.random()*8)+1);
        lillyPad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = pad3.newTotal(total, preOperation);
                totalText.setText(total+"");
                numClicked += 1;
                if (numClicked == 4){
                    if (total == 24)
                        winText.setText("You Win");
                    else
                        winText.setText("You Lose");
                }
            }
        });

        lillyPad4 = findViewById(R.id.lilly_pad_4);
        pad4 = new LillyPad(lillyPad4, (int)(Math.random()*8)+1);
        lillyPad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = pad4.newTotal(total, preOperation);
                totalText.setText(total+"");
                numClicked += 1;
                if (numClicked == 4){
                    if (total == 24)
                        winText.setText("You Win");
                    else
                        winText.setText("You Lose");
                }
            }
        });


        plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preOperation = "+";
            }
        });

        minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preOperation = "-";
            }
        });

        multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preOperation = "*";
            }
        });

        divide = findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preOperation = "/";
            }
        });


        reset = findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = 0;
                preOperation = "";
                numClicked = 0;
                totalText.setText(total+"");
                winText.setText("");
                resetLillyPads((int)(Math.random()*8)+1, (int)(Math.random()*8)+1, (int)(Math.random()*8)+1, (int)(Math.random()*8)+1);
            }
        });
    }


    public void resetLillyPads(int num1, int num2, int num3, int num4){
        pad1.reset(num1);
        pad2.reset(num2);
        pad3.reset(num3);
        pad4.reset(num4);
    }
}
