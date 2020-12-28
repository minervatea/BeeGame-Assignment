package com.example.comp2100_appproject;

import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


//this activity is called when the user dies (out of hp)
public class GameOver extends AppCompatActivity {
    public static Display display;
    TextView textView;
    static String user_name;
    static String user_password;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        GameView.hasGameOver=true;
        display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        GameView.Width = metrics.widthPixels;
        GameView.Height = metrics.heightPixels;


        textView = (TextView) findViewById(R.id.tvPersonalBest);
        String score = GameView.score+"";
        textView.setText(score);
        Store.gameActivityContext  = this;
        if(GameView.score>=GameView.highscore)
            GameView.highscore=GameView.score;

        MainActivity.background.start();




    }
    public void exit(View view){
        System.exit(0);
    }

    public void restart(View view){
        GameView gameView = new GameView(this);
        GameView.level=1;
        GameView.counting=0;
        GameView.count=0;
        Enemy.speed=15;
        setContentView(gameView);
    }
}
