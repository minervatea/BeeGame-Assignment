package com.example.comp2100_appproject;

import android.view.View;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CodingTests {


    @Test
    public void isEnemyOffScreen(){
        Enemy enemy = new Enemy(0);

        enemy.h=1500;enemy.w=800;enemy.x=400;enemy.y=200;enemy.offScreen();
        Assert.assertEquals(enemy.isOff,false);

        enemy.x=2000;enemy.y=2000;enemy.offScreen();
        Assert.assertEquals(enemy.isOff,true);
        enemy.x=-100;enemy.y=600;enemy.offScreen();
        Assert.assertEquals(enemy.isOff,true);
        enemy.x=600;enemy.y=400;enemy.offScreen();
        Assert.assertEquals(enemy.isOff,false);

    }

    @Test
    public void EnemyShuffleTest(){

        Enemy enemy = new Enemy(0);
        int[] dir= {0,1,2,3,4,5};

        enemy.directions = dir;
        for(int i=0; i<100;i++){

            enemy.shuffle();
            Assert.assertNotEquals(dir,enemy.directions);
        }

    }


}














