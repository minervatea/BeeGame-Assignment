package com.example.comp2100_appproject;

import java.util.ArrayList;
import java.util.Random;

// it contains some enemy generation during the game, it manages the location of the enemy
// every time the onDraw called.

public class Enemy {
    static int speedbylevel =1;
    static int speed =15;
    int h = GameView.Height;
    int w = GameView.Width;

    int x=-w;
    int y=-h;
    int index;
    int[] functions = new int[5];
    Boolean[] booleans = new Boolean[5];
    Random random = new Random();
    public static boolean isOff =false;
    int[] directions = {0,1,2,3,4,5};
    boolean complex = false;
    int i=0;
    int complexY=-h;
    int complexX=-w;
    int[] com = new int[5];

    public Enemy(){
        for(int i=0; i<booleans.length;i++)
            booleans[i]=false;
        randomPick();
        shuffle();
    }
    public Enemy(int t){

    }

    public void randomPick(){       // To choose the way where enemy is going
        Bee.toBeRemoved=3;
        isOff=false;
        y=0;
        index = directions[i];
        System.out.println("index: "+index);
        int p = random.nextInt(2);
        complex = p==0;
        if(index == 0 || index == 4){
            this.x = -20;
            this.complexX=w+20;
        }
        else if(index==1 || index==3) {
            this.x = w + 20;
            this.complexX =-20;
        }
        else if(index==5) {
            this.x=-20;
            this.y = random.nextInt((int) (h * 9 / 10)) + h / 10;
            this.complexY = random.nextInt((int) (h * 9 / 10)) + h / 10;
            this.complexX=w+20;
        }

        else{
            this.x=random.nextInt(w-50)+50;
            this.complexX=random.nextInt(w-50)+50;
            this.complexY=h+20;
        }
        setup();
        if(index<5) y = functions[index];
        i++;
        if(i==functions.length){
            i=0;
            shuffle();
        }

    }
    public void setup(){
        functions[0]=(h/w)*x;
        functions[1]=(-h/w)*x+h;
        functions[2]=y;
        functions[3]= (int) (((-7*h)/(10*w))*x+0.9*h);
        functions[4]=(int) ((h/(2*w))*x+0.4*h);


        com[0]=(h/w)*complexX;
        com[1]=(-h/w)*complexX+h;
        com[2]=y;
        com[3]= (int) (((-7*h)/(10*w))*complexX+0.9*h);
        com[4]=(int) ((h/(2*w))*complexX+0.4*h);

    }
    public void update(){
        offScreen();
        if(!isOff){
            int speed = this.speed;
            if(GameView.level==2){
                speed =this.speed*2;
            }

            if(index==2) {
                y+=speed;
                complexY-=speed;
            }
            else if(index ==0 || index ==4) {
                x += speed;
                complexX-=speed;
                setup();
                y = functions[index];
                complexY=com[index];
            }
            else if(index==5){
                x+=speed;
                complexX-=speed;
            }
            else{
                x-=speed;
                complexX+=speed;
                setup();
                y=functions[index];
                complexY=com[index];

            }
        }
        else
            randomPick();
    }

    public void offScreen(){
        if(x>w+GameView.sizeX||x < -GameView.sizeX ||y<-GameView.sizeY ||y>h+GameView.sizeY){
            isOff=true;
        }
        else
            isOff=false;
    }
    public void shuffle(){
        int[] result = new int[5];
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i=0; i< result.length;i++){
            int num = random.nextInt(directions.length);
            if(!integers.contains(num)) {
                result[i] = directions[num];
                integers.add(num);
            }else{
                i--;
            }
        }
        directions=result;
    }

}
