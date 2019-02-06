package com.fashionqueue.app.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fashionqueue.app.R;
import com.fashionqueue.app.base.BaseActivity;
import com.fashionqueue.app.login.login_activity.LoginActivity;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class));
                overridePendingTransition(R.anim.enter_animation, R.anim.exit_animation);
                finish();
            }
        },2000);
    }
}
