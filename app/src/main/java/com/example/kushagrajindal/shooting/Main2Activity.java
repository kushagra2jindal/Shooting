package com.example.kushagrajindal.shooting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    GameActivity g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        g=new GameActivity(this);
        setContentView(g);
    }
    protected void onResume(){
        super.onResume();
        g.resume();
    }
    protected void onPause(){
        super.onPause();
        g.pause();
    }
}
