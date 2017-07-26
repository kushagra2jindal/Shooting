package com.example.kushagrajindal.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by kushagrajindal on 02/07/17.
 */

public class Bullet {
    Bitmap b;
    int x, y;
        Bullet(Context c) {
        x = 300;
        b = BitmapFactory.decodeResource(c.getResources(), R.drawable.bullet_up);
        y = 300;
    }

    public void update() {
         x=x+b.getWidth()+50;
    }

    public Bitmap getB() {
        return b;
    }

    public int getX() {
        update();
        return x;
    }

    public int getY() {
        return y;
    }
}