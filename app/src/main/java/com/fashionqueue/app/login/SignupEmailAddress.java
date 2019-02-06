package com.fashionqueue.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fashionqueue.app.R;
import com.fashionqueue.app.base.BaseActivity;
import com.fashionqueue.app.landing_page.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignupEmailAddress extends BaseActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    TextInputEditText mEmail;
    TextInputEditText mPassword;
    TextInputEditText mMobileNo;
    TextInputEditText mConfirmPassword;
    Button mBtnSignup;


/*
    @BindView(R.id.et_email)
    TextInputEditText mEmail;

    @BindView(R.id.et_password)
    TextInputEditText mPassword;

    @BindView(R.id.et_mobile)
    TextInputEditText mMobileNo;

    @BindView(R.id.et_confirm_password)
    TextInputEditText mConfirmPassword;

    @BindView(R.id.btn_signup)
    Button mBtnSignup;
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_email_address);
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mMobileNo = findViewById(R.id.et_mobile);
        mConfirmPassword = findViewById(R.id.et_confirm_password);
        mBtnSignup = findViewById(R.id.btn_signup);
        mAuth = FirebaseAuth.getInstance();
        mBtnSignup.setOnClickListener(this);
    }

    private void createAccount(String email, String mobile, String password, String confirmPassword) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && mobile.length() > 9 && password.length() >= 8 && password.equals(confirmPassword)) {
            // [START create_user_with_email]
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignupEmailAddress.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        } else {
            Toast.makeText(this, "All fields need to fill", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(this, "Ola..Registed successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignupEmailAddress.this, MainActivity.class));
            finish();
        }

    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mEmail.getText().toString().trim();
        String mobile = mMobileNo.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String rePassword = mConfirmPassword.getText().toString().trim();

        Log.d("Data Register", email + mobile + password + rePassword);

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("Invalid email address");
            valid = false;
        } else {
            mEmail.setError(null);
        }

        if (mobile.length() == 10) {
            mMobileNo.setError("Mobile number is required");
            valid = false;
        } else {
            mMobileNo.setError(null);
        }

        if (password.length() >= 8 && password.equals(rePassword)) {
            mPassword.setError("Password should contain minimum 8 letters");
            valid = false;
        } else {
            mPassword.setError(null);
        }


        return valid;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_signup:
                createAccount(mEmail.getText().toString().trim(), mMobileNo.getText().toString().trim(), mPassword.getText().toString().trim(), mConfirmPassword.getText().toString().trim());

                break;
        }
    }
}
