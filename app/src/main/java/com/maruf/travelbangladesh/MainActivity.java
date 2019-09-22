package com.maruf.travelbangladesh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Animation fade_in;
    public static int time_out=2500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        image = (ImageView) findViewById(R.id.image);
        fade_in = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
        image.setAnimation(fade_in);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent= new Intent(MainActivity.this,HomePage.class);
                startActivity(myIntent);
                finish();
            }
        },time_out);
    }
}
