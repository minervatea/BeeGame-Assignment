package com.example.appproject;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class AppConstants {

    static BitmapBank bitmapBank;
    static GameEngine gameEngine;
    static int SCREEN_HEIGHT,SCREEN_WIDTH;
    static int enemy_velocity;
    static int distanceBetweenEnemy;
    static int numberOfEnemies;

    public static void initialization(Context context){
        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        setGameConstants();
        gameEngine = new GameEngine();
    }


    public static void setGameConstants(){
        AppConstants.enemy_velocity = 3;
        AppConstants.numberOfEnemies = 10;
        AppConstants.distanceBetweenEnemy = AppConstants.SCREEN_WIDTH * 3/4;
    }

    public static BitmapBank getBitmapBank(){ return bitmapBank;}

    public static GameEngine getGameEngine(){ return gameEngine;}

    private static void setScreenSize(Context context){
        WindowManager window_manager =(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = window_manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }


}
