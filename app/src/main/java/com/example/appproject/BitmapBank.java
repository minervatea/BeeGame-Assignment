package com.example.appproject;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import android.graphics.Bitmap;


public class BitmapBank {

    Bitmap bee;
    Bitmap background;
    Bitmap enemy;

    public BitmapBank(Resources res){
        background = BitmapFactory.decodeResource(res, R.drawable.playbackground);
        background = scaleImage(background);
        bee = BitmapFactory.decodeResource(res, R.drawable.bee);
        enemy = BitmapFactory.decodeResource(res,R.drawable.enemy);
    }



    public Bitmap getBackGround (){ return background;}

    public int getBackGroundWidth (){return background.getWidth();}

    public int getBackgroundHeight (){return background.getHeight();}

    public Bitmap getBee () {return bee;}

    public int getBeeWidth(){return bee.getWidth();}

    public int getBeeHeight(){return bee.getHeight();}

    public Bitmap getEnemy (){return enemy;}

    public int getEnemyWidth (){return enemy.getWidth();}

    public int getEnemyHeight (){return enemy.getHeight();}

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackGroundWidth() / getBackgroundHeight();

        int scaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return bitmap.createScaledBitmap(bitmap, scaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
