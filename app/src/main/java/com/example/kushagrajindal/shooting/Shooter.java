package com.example.kushagrajindal.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by kushagrajindal on 30/06/17.
 */

public class Shooter {
    Bitmap b;
    int x,y,c=1;
    int speed=8;
    int h,w;
    Shooter(Context c){
        x=0;
        b= BitmapFactory.decodeResource(c.getResources(),R.drawable.shooter);
        y=0;
    }
    public void setH(int h){
        this.h=h;
    }
    public void setW(int w){
        this.w=w;
    }
    public void update(){
        if(y<=speed){
            c=1;
            y=y+speed;
            setY(y);
        }
        else if(y>=h-b.getHeight() && y<=h-b.getHeight()+speed){
            c=0;
            y=y-speed;
            setY(y);
        }
        else{
            if(c==1){
                y=y+speed;
            }
            else{
                y=y-speed;
            }
        }
    }
    public void increaseSpeed(){
        speed=speed+5;
    }
    public Bitmap getB(){
        return b;
    }
    public void setY(int a){
        y=a;
    }
    public void setX(int a){x=a;}
    public int getX(){

        return x;
    }
    public int getY(){
        update();
        return y;
    }
    public int getSpeed(){
        return speed;
    }
}
