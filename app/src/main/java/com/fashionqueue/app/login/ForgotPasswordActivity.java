package com.fashionqueue.app.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fashionqueue.app.R;
import com.fashionqueue.app.base.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.et_email)
    TextInputEditText email;

    @BindView(R.id.btn_submit)
    Button submit;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);

        submit.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                if (!TextUtils.isEmpty(email.getText().toString().trim()) && Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()) {
                    showProgressDialog();
                    callForgotPassword(email.getText().toString().trim());
                }
        }
    }


    public void callForgotPassword(String email) {
        try {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                hideProgressDialog();
                                Toast.makeText(ForgotPasswordActivity.this, R.string.reset_password, Toast.LENGTH_SHORT).show();
                            } else {
                                hideProgressDialog();
                                Toast.makeText(ForgotPasswordActivity.this, R.string.opps_sww, Toast.LENGTH_SHORT).show();
                            }
                            if (task.isCanceled()) {
                                hideProgressDialog();
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
