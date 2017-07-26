package com.example.kushagrajindal.shooting;

/**
 * Created by kushagrajindal on 03/07/17.
 */

public class Points {
    int p=0;
    int a,b;
    public void setA(int z){
        a=z;
    }
    public void setB(int z){
        b=z;
    }
    public int check(){
        int c=Math.abs(a-b);
        if(a>=1 && a<=300){
            p=5;
        }
        else if(a>=51 && a<=100){
            p=4;
        }
        else if(a>=101 && a<=150){
            p=3;
        }
        else {
           p=2;
        }
        return p;
    }
}
