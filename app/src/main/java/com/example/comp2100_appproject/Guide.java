package com.example.comp2100_appproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


// this activity is called when the user hits the help button.
public class Guide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        Store.guideActivityContext = this;

        MainActivity.background.start();

    }

    public void back(View view){
        GameView gameView = new GameView(this);
        setContentView(gameView);

    }
}
