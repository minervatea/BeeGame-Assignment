package com.example.comp2100_appproject;

// This is the main game class when start to play games.


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.example.comp2100_appproject.MainActivity.display;


public class GameView extends View {
    int beeX=300, beeY=Height-200;
    int timer=0;
    Bitmap bee;
    Bitmap enemy;
    Bitmap hps;
    Bitmap bg;
    Bitmap shield;
    Bitmap inv;
    ArrayList<Integer> hpxs = new ArrayList<>();
    Bitmap[] items = new Bitmap[2];
    Bitmap gold[];
    Bitmap glare;
    int hpy ;
    static int highscore=0;
    BackgroundImage backgroundImage;
    public static int testx=50; /// just for the test for the location of x and y for images.
    public static int testy=50;
    public static int score=0;
    public static int Width=0,Height=0;
    public static int sizeX=0,sizeY=0;
    public static int numberOfEnemy =5;
    public static  int[] ys = new int[numberOfEnemy];
    public static int[] xs = new int[numberOfEnemy];
    int heartCount=0;
    int heartCountMax = 7;
    public static int itemX=0;
    public static int itemY=0;
    final int UPDATE_MILLIS = 30;
    Handler handler;
    Runnable runnable;
    Random random = new Random();
    Bitmap ufoenemy;
    int hp=3;
    public static int level = 1;
    int gap;
    boolean invincible = false;
    static boolean isShieldUsed = false;
    boolean isShieldAppeared=true; // it needs to be changed to be false and the value must be adjusted depending on condition using random value.
    static int counting=0;
    boolean creatingItem=false;
    static int itemIndex=0;
    static int count=0;
    BitmapBank hearttest;
    BitmapBank battest;
    int batCount = 0;
    int batCountMax = 7;
    static Enemy enemyClass;
    public static int[] enemyxs = new int[2];
    public static int[] enemyys = new int[2];
    Bitmap playbutton;
    Bitmap helpbutton;
    Bitmap quitbutton;
    Bitmap playbuttonH;
    Bitmap helpbuttonH;
    Bitmap quitbuttonH;
    Bitmap boss;
    int bossSizeX;
    int bossSizeY;
    boolean dead=false;
    boolean play_button_clicked = false;
    boolean help_button_clicked = false;
    boolean quit_button_clicked = false;
    int gameState =0;
    Bitmap sunflower;
    int time=0;
    int bossCount =0;
    BitmapBank drawingBoss;
    boolean bossAppeared=false;
    boolean bosscomingText=false;
    Bitmap title;
    Bitmap warning;
    public static boolean hasGameOver= false;
    boolean ufoCreated = false;
    int levelTwoCount=0;
    public static int numberOfUfo=2;
    public static int ufoX=0;
    public static int[] ufoys;
    public static boolean gotHpitem=false;
    int state =0;
    static MediaPlayer soundeffect;



    public GameView(Context context) {

        super(context);

        // Basic init process before the onDraw method begins.
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        score=0;
        soundeffect = MediaPlayer.create(context,R.raw.soundeffect);
        ufoys = new int[numberOfUfo];
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        if(hasGameOver){
            GameOver.display.getMetrics(metrics);
            width = metrics.widthPixels;
            height = metrics.heightPixels;
        }
        Width = width;
        Height = height;
        sizeX = Width/5;
        sizeY = Height/8;
        hpy= 0;
        battest = new BitmapBank(context.getResources());
        drawingBoss = new BitmapBank(context.getResources());
        hearttest = new BitmapBank(context.getResources());

        beeX=Width/2-sizeX/2; beeY=Height*7/9;

        enemyClass = new Enemy();
        bee = BitmapFactory.decodeResource(getResources(),R.drawable.bee);
        bg = BitmapFactory.decodeResource(getResources(),R.drawable.playbackground);
        playbutton = BitmapFactory.decodeResource(getResources(),R.drawable.playbutton2);
        helpbutton = BitmapFactory.decodeResource(getResources(),R.drawable.helpbutton2);
        quitbutton = BitmapFactory.decodeResource(getResources(),R.drawable.quitbutton2);
        playbuttonH = BitmapFactory.decodeResource(getResources(),R.drawable.playbutton23);
        helpbuttonH = BitmapFactory.decodeResource(getResources(),R.drawable.helpbutton23);
        quitbuttonH = BitmapFactory.decodeResource(getResources(),R.drawable.quitbutton23);
        sunflower = BitmapFactory.decodeResource(getResources(),R.drawable.sunflower);
        ufoX= Width-sizeX;

        glare = BitmapFactory.decodeResource(getResources(),R.drawable.glare);
        glare = Bitmap.createScaledBitmap(glare,sizeX,sizeY,true);
        bee = Bitmap.createScaledBitmap(bee,sizeX,sizeY,true);
        sunflower = Bitmap.createScaledBitmap(sunflower,Width,Height*2/3,true);

        sizeX = sizeX*2/3;
        sizeY = sizeY*2/3;
        bossSizeX=sizeX*5;
        bossSizeY=sizeY*5;
        ufoenemy = BitmapFactory.decodeResource(getResources(),R.drawable.ufoenemy);
        ufoenemy = Bitmap.createScaledBitmap(ufoenemy,sizeX,sizeY,true);

        enemy = BitmapFactory.decodeResource(getResources(),R.drawable.enemy);
        boss = BitmapFactory.decodeResource(getResources(),R.drawable.enemy);
        boss = Bitmap.createScaledBitmap(boss,bossSizeX,bossSizeY,true);

        enemy = Bitmap.createScaledBitmap(enemy,sizeX,sizeY,true);
        hps = BitmapFactory.decodeResource(getResources(),R.drawable.hp);
        hps = Bitmap.createScaledBitmap(hps,sizeX,sizeY,true);


        shield = BitmapFactory.decodeResource(getResources(),R.drawable.shield);


        shield = Bitmap.createScaledBitmap(shield,sizeX,sizeY,true);
        itemX=random.nextInt(Width-sizeX);
        itemY=random.nextInt(Height-sizeY);

        backgroundImage = new BackgroundImage();
        title = BitmapFactory.decodeResource(getResources(),R.drawable.title);
        warning = BitmapFactory.decodeResource(getResources(),R.drawable.warning);

        inv = BitmapFactory.decodeResource(getResources(),R.drawable.inv);
        inv = Bitmap.createScaledBitmap(inv,sizeX,sizeY,true);
        items[0]=shield;
        items[1]=inv;
        itemIndex= random.nextInt(2);

        for(int i=0; i< hp; i++){
            hpxs.add(Width*3/5+i*Width/10);
        }

        gap = Width/numberOfEnemy;

        for( int i=0; i<numberOfEnemy;i++){
            xs[i] = i*gap;
            ys[i]=100;
        }

    }

    public void updateAdnDrawBackgroundImage(Canvas canvas) { // it updates background image( looks like it's moving
        backgroundImage.setY(backgroundImage.getY() - backgroundImage.getVelocity());
        if (backgroundImage.getY() < -bg.getHeight()) {
            backgroundImage.setY(0);
        }
        canvas.drawBitmap(bg, backgroundImage.getX(),backgroundImage.getY(), null);

        if(backgroundImage.getY() < -(bg.getHeight() - Height)){
            canvas.drawBitmap(bg, backgroundImage.getX(),backgroundImage.getY() + bg.getHeight() , null);
        }
    }


    public void drawingBat(Canvas canvas){ // draw the red bat update every time so it looks like it's moving
        if(enemyClass.complex){
            enemyxs[0]=enemyClass.x;enemyxs[1]=enemyClass.complexX;
            enemyys[0]=enemyClass.y;enemyys[1]=enemyClass.complexY;
            if(Bee.toBeRemoved!=0) canvas.drawBitmap(battest.getBat(batCount), enemyClass.x, enemyClass.y, null);
            if(Bee.toBeRemoved!=1) canvas.drawBitmap(battest.getBat(batCount), enemyClass.complexX, enemyClass.complexY, null);
        }
        else {

            enemyxs[0]=enemyClass.x;enemyxs[1]=enemyClass.x;
            enemyys[0]=enemyClass.y;enemyys[1]=enemyClass.y-sizeY;
            if(Bee.toBeRemoved!=0) {
                canvas.drawBitmap(battest.getBat(batCount), enemyClass.x, enemyClass.y, null);
            }
            if(Bee.toBeRemoved!=1) {
                canvas.drawBitmap(battest.getBat(batCount), enemyClass.x, enemyClass.y-sizeY, null);
            }

        }
        enemyClass.update();
        batCount++;
        if(batCount > batCountMax){
            batCount = 0;
        }
    }
        // Some buttons.
    public void onPlayButtonClick(Canvas canvas){
        canvas.drawBitmap(playbuttonH,Width*5/8,Height*45/80,null);
        canvas.drawBitmap(helpbutton,Width*5/8,Height*56/80,null);
        canvas.drawBitmap(quitbutton,Width*5/8,Height*67/80,null);
    }

    public void onHelpButtonClick(Canvas canvas){
        canvas.drawBitmap(playbutton,Width*5/8,Height*45/80,null);
        canvas.drawBitmap(helpbuttonH,Width*5/8,Height*56/80,null);
        canvas.drawBitmap(quitbutton,Width*5/8,Height*67/80,null);
    }

    public void onQuitButtonClick(Canvas canvas){
        canvas.drawBitmap(playbutton,Width*5/8,Height*45/80,null);
        canvas.drawBitmap(helpbutton,Width*5/8,Height*56/80,null);
        canvas.drawBitmap(quitbuttonH,Width*5/8,Height*67/80,null);
    }
    public void ufo(Canvas canvas){
        if(!ufoCreated) {
            ufoX=Width+sizeX;
            ufoys = new int[level];
            for (int i = 0; i < level; i++) {
                ufoys[i] = random.nextInt(Height * 3 / 4) + Height / 10;
            }
            ufoCreated=true;
        }
    }

    public void updatingRepeatingEvents(Canvas canvas){ // all the events that are repeated in every state.
        Bee bee = new Bee(beeX,beeY);
        if(bee.isHit() && !invincible &&hp>=1) {
            score-=50;
            hpxs.remove(0);
            hp-=1;
            invincible = true;
            System.out.println(hp);
        }

        if(bee.isHit()&&isShieldUsed){
            score+=100;
            isShieldUsed=false;
            count=80;
        }

        for(int i=0; i<hpxs.size();i++){
            canvas.drawBitmap(hps,hpxs.get(i),hpy,null);
        }
        if(invincible){
            count++;
        }
        if(count==100){
            count=0;
            invincible=false;
        }
        if(level==2) System.out.println("level2!!!!");
        if(hp==0) System.out.println("dead");
        if(counting>0 &&counting%30==0)score+=1;
        counting++;
        if(hp==0) dead=true;
        if(hp==0&&dead) {
            dead=false;
            hp-=1;
            Context context = Store.gameActivityContext;

            Intent intent = new Intent(context, GameOver.class);
            context.startActivity(intent);
            ((Activity) context).finish();

        }
    }

    public void boss(Canvas canvas){ // drawing boss
        canvas.drawBitmap(drawingBoss.getBoss(bossCount), -Width/15, -Height/10, null);
        bossCount++;
        if(bossCount > batCountMax){
            bossCount = 0;
        }


    }


    @Override
    protected void onDraw(Canvas canvas) {// onDraw loop, it draws below codes every time.
        super.onDraw(canvas);
        updateAdnDrawBackgroundImage(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(150);
        if(gameState==0){
            canvas.drawBitmap(playbutton,Width*5/8,Height*45/80,null);
            canvas.drawBitmap(helpbutton,Width*5/8,Height*56/80,null);
            canvas.drawBitmap(quitbutton,Width*5/8,Height*67/80,null);
            canvas.drawBitmap(title,Width/10,Height/10,null);
        }

        if(play_button_clicked && gameState ==1){ onPlayButtonClick(canvas); }
        if(help_button_clicked) {onHelpButtonClick(canvas);}
        if(quit_button_clicked) {onQuitButtonClick(canvas);}

        if(gameState ==0 && help_button_clicked == true){
            gameState=3;
            Context context = Store.guideActivityContext;
            Intent intent = new Intent(context, Guide.class);
            context.startActivity(intent);
            ((Activity) context).finish();

        }

        if(gameState==1){

            play_button_clicked = false;
            paint.setTextSize(100);

            if(counting%200==0 && counting>0 ){
                creatingItem=true;
                itemX=random.nextInt((Width-sizeX));
                itemY=random.nextInt((Height-sizeY));
                itemIndex= random.nextInt(2);
            }
            if(creatingItem){
                if(itemIndex<=1) {
                    canvas.drawBitmap(items[itemIndex], itemX, itemY, null);
                    gotHpitem=false;
                }
                else {
                    gotHpitem=true;
                }
            }

            if(isShieldUsed) {
                if(count==100) isShieldUsed=false;

                canvas.drawBitmap(glare,beeX,beeY,null);
            }
            canvas.drawBitmap(bee,beeX,beeY,null);

            if(isShieldAppeared) canvas.drawBitmap(items[itemIndex],itemX,itemY,null);
            drawingBat(canvas);

            Bee bee = new Bee(beeX,beeY);

            if(creatingItem||isShieldAppeared){

                if(bee.gotShield()){
                    isShieldAppeared=false;
                    if(itemIndex==0){
                        score+=100;
                        count=0;
                        time = counting;
                        invincible=true;
                        isShieldUsed=true;
                        creatingItem=false;
                    }
                    else if(itemIndex==1){
                        score+=100;
                        count=0;
                        invincible=true;
                        creatingItem=false;
                    }
                }
            }

            String in = "";
            if(invincible) in = "invincible";
            else in = "not invincible";
            canvas.drawText(in, Width/2,Height/10,paint);
            updatingRepeatingEvents(canvas);
            canvas.drawText(score+"",Width/14,Height/14,paint);

            if( counting % 800==0 && counting>0)
                bosscomingText=true;

            if(bosscomingText){
                canvas.drawBitmap(warning,Width/9,Height/9,null);
            }


            if(counting % 900==0 && counting>0)
                bossAppeared=true;

            if(bossAppeared){ // boss
                bosscomingText=false;
                boss(canvas);
                canvas.drawBitmap(this.bee,beeX,beeY,null);

                if(bee.isHitByBoss() && !invincible &&hp>=1) {
                    score-=100;
                    hp=0;
                }
                canvas.drawText(score+"",Width/14,Height/14,paint);

                if(counting % 1300==0 && counting>0){
                    bossAppeared=false;

                }
                level=2;
                Enemy.speedbylevel=level;
                state+=1;
                if(state==1) {
                    ufoCreated=false;
                    ufo(canvas);
                }
            }

            ufo(canvas);

            for(int i=0; i<ufoys.length;i++){
                canvas.drawBitmap(ufoenemy,ufoX,ufoys[i],null);
            }
            if(bee.isHitByUfo()&&!invincible) {
                System.out.println(Arrays.toString(ufoys));
                score -= 75;
                hpxs.remove(0);
                hp -= 1;
                invincible = true;
            }


            ufoX-=enemyClass.speed;
            if(ufoX < -sizeX){
                ufoCreated=false;
            }
            levelTwoCount++;


        }

        handler.postDelayed(runnable, UPDATE_MILLIS);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event){ // touch event
        int x=beeX;
        int y=beeY;
        if(event.getAction()==MotionEvent.ACTION_MOVE ){
            x = (int) (event.getX()-(sizeX/2)*1.5);
            y = (int) (event.getY()-(sizeY/2)*1.5);
            testx=(int)event.getX();
            testy=(int)event.getY();

        }
        if(x <Width-sizeX/2 &&x>-sizeX &&y>-sizeY &&y<Height-sizeY/1.5){
            beeX=x;
            beeY=y;
        }
        int mousex=(int)event.getX();
        int mousey=(int)event.getY();
        if(gameState==0&&mousex>=Width*45/80 &&mousex<=Width*45/80+playbutton.getWidth() &&mousey>=Height*45/80 && mousey<=Height*45/80+playbutton.getHeight()){
            gameState=1;
            play_button_clicked = true;
        }
        if(gameState==0&&mousex>=Width*56/80 &&mousex<=Width*56/80+playbutton.getWidth() &&mousey>=Height*56/80 && mousey<=Height*56/80+playbutton.getHeight()){
            help_button_clicked = true;

        }if(gameState==0&&mousex>=Width*67/80 &&mousex<=Width*67/80+playbutton.getWidth() &&mousey>=Height*67/80 && mousey<=Height*67/80+playbutton.getHeight()){
            System.exit(0); // exit game

        }

        return true;
    }



}