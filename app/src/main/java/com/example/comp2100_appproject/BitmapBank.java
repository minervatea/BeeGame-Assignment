package com.example.comp2100_appproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    // Some bitmaps that need to be updated in order for itself to look like it's moving.
    int sizeX = GameView.sizeX;
    int sizeY = GameView.sizeY;

    public static Bitmap[] bat;
    public static Bitmap[] boss;

    public BitmapBank(Resources res){

        bat = new Bitmap[8];
        bat[0] = BitmapFactory.decodeResource(res,R.drawable.batfly0);
        bat[1] = BitmapFactory.decodeResource(res,R.drawable.batfly1);
        bat[2] = BitmapFactory.decodeResource(res,R.drawable.batfly2);
        bat[3] = BitmapFactory.decodeResource(res,R.drawable.batfly3);
        bat[4] = BitmapFactory.decodeResource(res,R.drawable.batfly4);
        bat[5] = BitmapFactory.decodeResource(res,R.drawable.batfly5);
        bat[6] = BitmapFactory.decodeResource(res,R.drawable.batfly6);
        bat[7] = BitmapFactory.decodeResource(res,R.drawable.batfly7);

        boss = new Bitmap[8];
        boss[0] = BitmapFactory.decodeResource(res,R.drawable.batfly0);
        boss[1] = BitmapFactory.decodeResource(res,R.drawable.batfly1);
        boss[2] = BitmapFactory.decodeResource(res,R.drawable.batfly2);
        boss[3] = BitmapFactory.decodeResource(res,R.drawable.batfly3);
        boss[4] = BitmapFactory.decodeResource(res,R.drawable.batfly4);
        boss[5] = BitmapFactory.decodeResource(res,R.drawable.batfly5);
        boss[6] = BitmapFactory.decodeResource(res,R.drawable.batfly6);
        boss[7] = BitmapFactory.decodeResource(res,R.drawable.batfly7);



        for(int i = 0; i < 8 ; i++){
            bat[i] = Bitmap.createScaledBitmap(bat[i], sizeX, sizeY, true);
        }
        for(int i = 0; i < 8 ; i++){
            boss[i] = Bitmap.createScaledBitmap(boss[i], sizeX*6, sizeY*6, true);
        }
    }



    public Bitmap getBat(int frame) { return bat[frame];}
    public Bitmap getBoss(int frame) { return boss[frame];}

}
