package com.example.tatum_ogata.twentyfour;

import android.graphics.Color;
import android.media.Image;
import android.widget.Button;

public class LillyPad {
    Button button;
    Image image;
    Color color;
    int value;
    boolean active;

    public LillyPad(Button button, int value){//}, Image image){
        this.button = button;
        this.value = value;
        this.setValue(value);
        //this.image = image;
        active = true;
        this.setActive(active);

    }

    public void reset(int value){
        this.value = value;
        this.setValue(value);
        active = true;
        this.setActive(active);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        button.setText(value+"");
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        button.setClickable(active);
    }

    public int newTotal(int total, String operation){

        this.setActive(false);

        if (total == 0){
            return this.value;
        }

        switch (operation){
            case "+": return total + this.value;
            case "-": return total - this.value;
            case "*": return total * this.value;
            case "/": return total / this.value;
        }

        return 0;


    }
}
