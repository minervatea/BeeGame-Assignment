package com.example.comp2100_appproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class StartGame extends Activity {
    // this class is called for the gameView to start running.

    GameView gameView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        Store.gameActivityContext = this;

        setContentView(gameView);

    }
}
