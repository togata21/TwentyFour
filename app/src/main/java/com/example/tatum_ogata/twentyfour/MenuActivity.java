package com.example.tatum_ogata.twentyfour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Button playButton;
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
    }


}
