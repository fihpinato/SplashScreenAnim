package com.example.filipe.splashscreenanim;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenAnim extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen_anim);

        carregar();
    }


    private void carregar() {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash);

        anim.reset();

        ImageView iv = (ImageView) findViewById(R.id.splash);

        if (iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);

        }new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenAnim.this, MenuActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                startActivity(intent);

                SplashScreenAnim.this.finish();
            }

        }, SPLASH_DISPLAY_LENGTH);
        
    }
}

