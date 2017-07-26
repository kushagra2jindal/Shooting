package com.example.kushagrajindal.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by kushagrajindal on 03/07/17.
 */

public class BulletFire {
    Bitmap b;
    int x,y,s,c;
    int count=0;
    BulletFire(Context c){
        x = 0;
        b = BitmapFactory.decodeResource(c.getResources(), R.drawable.bullet_right);
        y = 0;
    }
    public Bitmap getB(){
        return b;
    }
    public void setX(int a){
        x=a;
    }
    public void setY(int a){
        y=a;
    }
    public int getX(){
        update();
        return x;
    }
    public int getY(){
        return y;
    }
    public void getshhoterwidth(int a){
        s=a;
    }
    public void getcanvaswidth(int a){
        c=a;
    }
    public void update(){
        x=x+50;
        if(x>=c-s){
            count=0;
            x=-200;
        }
    }
    public void setCount(int a){
        count=a;
    }
    public int getCount(){
        return count;
    }
}
