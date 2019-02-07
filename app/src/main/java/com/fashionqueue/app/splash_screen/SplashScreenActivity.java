package com.fashionqueue.app.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fashionqueue.app.R;
import com.fashionqueue.app.base.BaseActivity;
import com.fashionqueue.app.landing_page.MainActivity;
import com.fashionqueue.app.login.login_activity.LoginActivity;
import com.fashionqueue.app.utils.SharedPrefUtil;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPrefUtil.getBooleanPreference(SplashScreenActivity.this, "isLoggedIn", false)) {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
                finish();
            }
        }, 2000);
    }
}
