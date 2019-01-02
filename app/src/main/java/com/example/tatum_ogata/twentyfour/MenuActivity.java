package com.example.tatum_ogata.twentyfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Button playButton;
    Button dadButton;
    Button tatumButton;
    TextView nameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        playButton = findViewById(R.id.playB);
        nameTextView = findViewById(R.id.nameTV);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), GameActivity.class);
                //select numbers for lilly pads
                startActivity(i);
            }
        });

        dadButton = findViewById(R.id.dadButton);
        dadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DadGameActivity.class);
                //select numbers for lilly pads
                startActivity(i);
            }
        });

        tatumButton = findViewById(R.id.tatumButton);
        tatumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), TatumGameActivity.class);
                //select numbers for lilly pads
                startActivity(i);
            }
        });

    }


}
