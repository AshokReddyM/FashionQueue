package com.fashionqueue.app.gender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.fashionqueue.app.R;
import com.fashionqueue.app.landing_page.MainActivity;
import com.fashionqueue.app.login.BaseActivity;
import com.fashionqueue.app.utils.SharedPrefUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenderActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ll_male)
    LinearLayout male;

    @BindView(R.id.ll_female)
    LinearLayout female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ButterKnife.bind(this);

        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_male:
                SharedPrefUtil.SharedPrefsUtils.setIntegerPreference(this, "gender_type", 0);
                startActivity(new Intent(GenderActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.ll_female:
                SharedPrefUtil.SharedPrefsUtils.setIntegerPreference(this, "gender_type", 1);
                startActivity(new Intent(GenderActivity.this, MainActivity.class));
                finish();
                break;
        }
    }
}
