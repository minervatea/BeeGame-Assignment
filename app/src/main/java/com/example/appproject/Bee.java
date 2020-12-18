package com.example.appproject;

public class Bee {


    private int beeX, beeY;

    public Bee(){
        beeX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getBeeWidth()/2;
        beeY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getBeeHeight()/2;
    }


    public void setX(int beeX) {this.beeX = beeX;}

    public void setY(int beeY) {this.beeY = beeY;}

    public int getX() {return beeX;}

    public int getY() {return beeY;}

}
