package com.example.comp2100_appproject;

// some hit events when the bee hits some enemy or gets items.
import static com.example.comp2100_appproject.GameView.Height;
import static com.example.comp2100_appproject.GameView.Width;
import static com.example.comp2100_appproject.GameView.enemyxs;
import static com.example.comp2100_appproject.GameView.enemyys;
import static com.example.comp2100_appproject.GameView.isShieldUsed;
import static com.example.comp2100_appproject.GameView.itemX;
import static com.example.comp2100_appproject.GameView.itemY;
import static com.example.comp2100_appproject.GameView.level;
import static com.example.comp2100_appproject.GameView.sizeX;
import static com.example.comp2100_appproject.GameView.sizeY;
import static com.example.comp2100_appproject.GameView.ufoX;
import static com.example.comp2100_appproject.GameView.ufoys;

public class Bee {
    private int x,y;
    public static int toBeRemoved=3;


    public Bee(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Bee(){}
    public int getSizeX(int width){ return width/5; }
    public int getSizeY(int height){ return height/8; }



    public boolean isHit(){ // whether the bee has hit the enmemy
        int sizeX = getSizeX(Width);
        int sizeY = getSizeY(Height);
        for(int i=0; i<enemyxs.length;i++){

            if(this.x>=enemyxs[i]-sizeX/2 &&this.x<=enemyxs[i]+sizeX/2&& this.y>=enemyys[i]-sizeY/2 && this.y<=enemyys[i]+sizeY/2){

                if(isShieldUsed){
                    toBeRemoved=i;
                }else if(toBeRemoved!=3){
                    if(toBeRemoved==i) return false;
                }

                return true;
            }
        }

        return false;
    }
    public boolean isHitByUfo(){    // whether the bee has hit the ufo
        int sizeX = Width/5;
        int sizeY = Height/8;
        for(int i=0; i<level;i++){

            if(this.x>=ufoX-sizeX/2 &&this.x<=ufoX+sizeX/2&& this.y>=ufoys[i]-sizeY/2 && this.y<=ufoys[i]+sizeY/2){
                return true;
            }
        }

        return false;
    }

    public boolean isHitByBoss(){   // whether the bee has hit the boss
        int sizeX = Width/5;
        int sizeY = Height/8;
        for(int i=0; i<enemyxs.length;i++){
            if(this.x>=-Width/15-sizeX/2 &&this.x<=sizeX*6+Width/15+sizeX/2&& this.y>=-Height/10-sizeY/2 && this.y<=Height/10+sizeY*5/2){

                if(isShieldUsed){
                   return false;
                }

                return true;
            }
        }

        return false;
    }


    public boolean gotShield(){     // check if the bee has a shield

        if(this.x>=itemX-sizeX && this.x<=itemX+sizeX && this.y>=itemY-sizeY && this.y<=itemY+sizeY) {
            //GameView.soundeffect.stop();
            GameView.soundeffect.start();
            return true;
        }

        return false;
    }

}
