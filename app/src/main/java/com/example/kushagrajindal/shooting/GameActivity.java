package com.example.kushagrajindal.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by kushagrajindal on 30/06/17.
 */

public class GameActivity extends SurfaceView implements Runnable {
    volatile boolean playing;
    int y=0;
    Thread t=null;
    SurfaceHolder s;
    Canvas c;
    gun g;
    Shooter sh;
    Bullet e[]=new Bullet[5];
    int chances=5;
    BulletFire bf;
    public GameActivity(Context c){
        super(c);
        s=getHolder();
        g=new gun(c);
        sh=new Shooter(c);
        for(int i=0;i<5;i++){
            e[i]=new Bullet(c);
        }
        bf=new BulletFire(c);
        bf.setX(g.getB().getWidth());
    }
    public void run(){
        while(playing){
            update();
            draw();
            control();
        }
    }

    public void update() {
    }
    public void control(){
        try{
            t.sleep(25);
        }catch (InterruptedException e){}
    }
    public void resume(){
        playing=true;
        t=new Thread(this);
        t.start();
    }
    public void pause(){
        try{
            t.join();
        }catch(InterruptedException e){}
    }
    public void draw(){
        if(s.getSurface().isValid()) {
            c=s.lockCanvas();
            c.drawRGB(255,255,255);
            for(int i=0;i<chances;i++){
                c.drawBitmap(e[i].getB(),400+i*150,200,null);
            }
            bf.getshhoterwidth(sh.getB().getWidth());
            bf.getcanvaswidth(c.getWidth());
            if(bf.getCount()==1){
            c.drawBitmap(bf.getB(),bf.getX(),bf.getY(),null);
            }
            g.setH(c.getHeight());
            g.setW(c.getWidth());
            sh.setH(c.getHeight());
            sh.setW(c.getWidth());
            Bitmap b1=sh.getB();
            sh.setX(c.getWidth()-b1.getWidth());
            Bitmap b=g.getB();
            c.drawBitmap(g.getB(),g.getX(),g.getY(),null);
            c.drawBitmap(b1,sh.getX(),sh.getY(),null);
            s.unlockCanvasAndPost(c);
        }
    }
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x,y;
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                    x = g.getX();
                    y = g.getY();
                    bf.setX(x + g.getB().getWidth());
                    bf.setY(y);
                    bf.setCount(1);
                    chances--;
                break;
        }
        return true;
    }

}
