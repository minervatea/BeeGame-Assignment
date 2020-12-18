package com.example.appproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class GameActivity extends Activity {
    GameView gameView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
    }
}

/*
    When we override a method, we have the option of completely replacing the method in our class,
        or of extending the existing parent class' method. By calling  super.onCreate(savedInstanceState);,
        you tell the Dalvik VM to run your code in addition to the existing code in the onCreate() of the parent class.
        If you leave out this line, then only your code is run. The existing code is ignored completely.*/
