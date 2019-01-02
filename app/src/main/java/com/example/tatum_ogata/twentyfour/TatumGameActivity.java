package com.example.tatum_ogata.twentyfour;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TatumGameActivity extends AppCompatActivity {

    //xml widgets
    RelativeLayout relativeLayout;
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
    ImageView frog;
    AnimationDrawable jumpingFrog;

    LillyPad pad1;
    LillyPad pad2;
    LillyPad pad3;
    LillyPad pad4;

    int total;
    String preOperation;
    int numClicked;
    float originalFrogX;
    float originalFrogY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tatum_game);

        preOperation = "";
        total = 0;
        numClicked = 0;

        relativeLayout = findViewById(R.id.gameRelativeLayout);

        frog = findViewById(R.id.frog);
        jumpingFrog = (AnimationDrawable)  frog.getDrawable();
        originalFrogX = frog.getX();
        originalFrogY = frog.getY();

        totalText = findViewById(R.id.equationText);
        totalText.setText(total+"");
        winText = findViewById(R.id.youWinText);
        winText.setText("");

        lillyPad1 = findViewById(R.id.lilly_pad_1);
        pad1 = new LillyPad(lillyPad1, (int)(Math.random()*8)+1);
        lillyPad1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                //Animation rotateAnimation = Aima
                jumpingFrog.stop();
                jumpingFrog.start();
                final float startX = frog.getX();
                final float startY = frog.getY();
                TranslateAnimation translateAnimation = new TranslateAnimation(0, lillyPad1.getPivotX()-(frog.getWidth()/4)-startX, 0, lillyPad1.getPivotY()-(frog.getHeight()/8)-startY);
                translateAnimation.setDuration(900);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                translateAnimation.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //frog.setX(lillyPad1.getPivotX()-(frog.getWidth()/4));
                        //frog.setY(lillyPad1.getPivotY()-(frog.getHeight()/8));

                        //frog.setX(lillyPad1.getPivotX());
                        //frog.setY(lillyPad1.getPivotY());

                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(frog.getWidth(), frog.getHeight());

                        params.leftMargin = (int)lillyPad1.getPivotX();
                        params.topMargin = (int)lillyPad1.getPivotY();

                        //RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(frog.getWidth(), frog.getHeight());

                        //RelativeLayout.LayoutParams lillyParams = (RelativeLayout.LayoutParams) lillyPad1.getLayoutParams();
                        //params.setMargins(lillyParams.leftMargin, lillyParams.topMargin, lillyParams.rightMargin, lillyParams.bottomMargin);
                        frog.setLayoutParams(params);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}

                });
                frog.startAnimation(translateAnimation);
                frog.setZ(100);



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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                jumpingFrog.stop();
                jumpingFrog.start();
                float startX = frog.getX();
                float startY = frog.getY();
                TranslateAnimation translateAnimation = new TranslateAnimation(0, startX-lillyPad2.getPivotX(), 0, lillyPad2.getPivotY()-startY);
                translateAnimation.setDuration(900);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                frog.startAnimation(translateAnimation);
                frog.setZ(100);

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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                jumpingFrog.stop();
                jumpingFrog.start();
                float startX = frog.getX();
                float startY = frog.getY();
                TranslateAnimation translateAnimation = new TranslateAnimation(0, startX-lillyPad3.getPivotX(), 0, startY-lillyPad3.getPivotY());
                translateAnimation.setDuration(900);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                frog.startAnimation(translateAnimation);
                frog.setZ(100);

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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                jumpingFrog.stop();
                jumpingFrog.start();
                float startX = frog.getX();
                float startY = frog.getY();
                TranslateAnimation translateAnimation = new TranslateAnimation(0, lillyPad4.getPivotX()-startX, 0, startY-lillyPad4.getPivotY());
                translateAnimation.setDuration(900);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                frog.startAnimation(translateAnimation);
                frog.setZ(100);

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
                frog.setX(originalFrogX);
                frog.setY(originalFrogY);
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
