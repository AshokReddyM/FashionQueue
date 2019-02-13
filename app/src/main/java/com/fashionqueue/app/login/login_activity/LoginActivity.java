package com.fashionqueue.app.login.login_activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.fashionqueue.app.R;
import com.fashionqueue.app.base.BaseActivity;
import com.fashionqueue.app.data.FirebaseDataManager;
import com.fashionqueue.app.interfaces.OnProfileCreateListener;
import com.fashionqueue.app.landing_page.MainActivity;
import com.fashionqueue.app.login.ForgotPasswordActivity;
import com.fashionqueue.app.login.SignupEmailAddress;
import com.fashionqueue.app.utils.UiUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity implements LoginMvp, View.OnClickListener, OnProfileCreateListener {

    private static final int RC_SIGN_IN = 9001;
    private static String TAG = null;
    @BindView(R.id.tv_forgot_password)
    TextView forgotPassword;
    private FirebaseAuth mAuth;
    private CallbackManager mCallbackManager;
    private LoginButton loginButton;
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton googleLoginButton;
    private TextInputEditText mEmailField;
    private TextInputEditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();

        mEmailField = findViewById(R.id.et_email);
        mPasswordField = findViewById(R.id.et_password);

        findViewById(R.id.emailSignInButton).setOnClickListener(this);
        findViewById(R.id.emailCreateAccountButton).setOnClickListener(this);

        forgotPassword.setOnClickListener(this);


        Button fbButton = findViewById(R.id.facebook_login_button);
        Button googleButton = findViewById(R.id.google_login_button);

        googleLoginButton = findViewById(R.id.signInButton);
        googleButton.setOnClickListener(this);

        // Add code to print out the key hash
        try {
            PackageInfo info;
            info = getPackageManager().getPackageInfo(
                    "com.fashionqueue.app",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

        //facebook
        fbButton.setOnClickListener(this);
        googleButton.setOnClickListener(this);

        loginButton = findViewById(R.id.buttonFacebookLogin);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                // App code
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                LoginManager.getInstance().logOut();

                                String social_id = null;
                                try {
                                    social_id = object.getString("id");
                                    String email = object.getString("email");
                                    String name = object.getString("name");

                                    checkUserExist(social_id, email, name);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                                // Application code

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                updateUI(null);
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("facebook login", error.toString());
                updateUI(null);
            }
        });

        //google
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }


    @Override
    public void onStart() {
        super.onStart();
    }


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                String social_id = null;

                social_id = account.getId();
                String email = account.getEmail();
                String name = account.getDisplayName();
                checkUserExist(social_id, email, name);

            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
                updateUI(null);
            }
        }

    }


    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        showProgressDialog();

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            hideProgressDialog();
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        hideProgressDialog();
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    public void signOut() {
        mAuth.signOut();
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        updateUI(null);
    }

    private void updateUI(final FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {


        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.facebook_login_button:
                TAG = "FacebookLogin";
                loginButton.performClick();
                UiUtils.hideKeyboard(LoginActivity.this);
                break;
            case R.id.google_login_button:
                TAG = "GoogleLogin";
                signIn();
                UiUtils.hideKeyboard(LoginActivity.this);
                break;
            case R.id.emailCreateAccountButton:
                TAG = "emailLogin";
                startActivity(new Intent(LoginActivity.this, SignupEmailAddress.class));
                UiUtils.hideKeyboard(LoginActivity.this);
                break;
            case R.id.emailSignInButton:
                signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
                UiUtils.hideKeyboard(LoginActivity.this);
                break;

            case R.id.tv_forgot_password:
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        signOut();
    }


    @Override
    public void onProfileCreated() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        Toast.makeText(this, "Logged Successfully", Toast.LENGTH_SHORT).show();
    }


    /**
     * checking user already exist or not
     *
     * @param social_id social id
     * @param email     email
     * @param name      name
     */
    public void checkUserExist(final String social_id, final String email, final String name) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        Query query = databaseReference.orderByChild("email").equalTo(email);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Toast.makeText(LoginActivity.this, "User already exist", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDataManager.createUser(LoginActivity.this, social_id, name, "", "", email, "4", String.valueOf(System.currentTimeMillis()));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException(); // don't ignore errors
            }
        });


    }
}