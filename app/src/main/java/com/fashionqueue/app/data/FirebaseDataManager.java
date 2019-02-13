package com.fashionqueue.app.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.fashionqueue.app.data.modals.Profile;
import com.fashionqueue.app.data.modals.User;
import com.fashionqueue.app.interfaces.OnProfileCreateListener;
import com.fashionqueue.app.login.login_activity.LoginActivity;
import com.fashionqueue.app.utils.SharedPrefUtil;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDataManager {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference mDatabaseRef;


    public static void createUser(final LoginActivity loginActivity, final String social_id, final String first_name, final String last_name, final String mobile, final String email, final String login_type, final String register_date) {
        mDatabaseRef = database.getReference().child("users");
        User user = new User(mobile, email);
        mDatabaseRef.child(mDatabaseRef.push().getKey()).
                setValue(user, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        if (databaseError != null) {
                            Toast.makeText(loginActivity, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
                            SharedPrefUtil.setBooleanPreference(loginActivity, "isLoggedIn", true);
                            SharedPrefUtil.setStringPreference(loginActivity, "email", email);
                            createProfileTable(loginActivity, databaseReference.getKey(), first_name, last_name, mobile, email, "", "", login_type, social_id, register_date);
                            ((OnProfileCreateListener) loginActivity).onProfileCreated();
                        }
                    }
                });
    }


    public static void createProfileTable(final LoginActivity loginActivity, String uID, String first_name, String last_name, String mobile, final String email, String dob, String gender, String login_type, String social_id, String register_date) {
        mDatabaseRef = database.getReference().child("users");
        Profile user = new Profile(first_name, last_name, mobile, email, dob, gender, login_type, social_id, register_date);
        mDatabaseRef.child(uID).child("profile").setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Toast.makeText(loginActivity, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                }
            }
        });
    }





}




