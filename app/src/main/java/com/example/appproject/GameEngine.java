package com.example.appproject;

import android.graphics.Canvas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Bee bee;
    static int gameState;
    ArrayList<Enemy> enemies;
    Random random;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        bee = new Bee();
        // 0 = not started
        // 1 = playing
        // 2 = gameOver
        gameState = 0;
    }


    public void updateAdnDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setY(backgroundImage.getY() - backgroundImage.getVelocity());
        if (backgroundImage.getY() < -AppConstants.getBitmapBank().getBackgroundHeight()) {
            backgroundImage.setY(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackGround(), backgroundImage.getX(),backgroundImage.getY(), null);
        if(backgroundImage.getY() < -(AppConstants.getBitmapBank().getBackgroundHeight() - AppConstants.SCREEN_HEIGHT)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackGround(), backgroundImage.getX(),backgroundImage.getY() + AppConstants.getBitmapBank().getBackgroundHeight() , null);
        }
    }

    public void updateAndDrawBee(Canvas canvas) {

        canvas.drawBitmap(AppConstants.getBitmapBank().getBee(), bee.getX(), bee.getY(), null);

    }


}
