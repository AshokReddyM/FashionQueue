package com.fashionqueue.app.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.fashionqueue.app.data.modals.User;
import com.fashionqueue.app.interfaces.OnProfileCreateListener;
import com.fashionqueue.app.login.login_activity.LoginActivity;
import com.fashionqueue.app.utils.SharedPrefUtil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDataManager {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference mDatabaseRef;


    public static void removeWebsite(final Context context, String language, String categoryId, String websiteId) {
        mDatabaseRef = database.getReference().child("home").child("News").child("Languages").child(language).child("Websites").child(categoryId);
        mDatabaseRef.child(websiteId).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Toast.makeText(context, "Website details updated failed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Website details updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public static void addOrUpdateCategory(final Context context, String language, String category, String key) {
        mDatabaseRef = database.getReference().child("home").child("News").child("Languages").child(language).child("Categories");
        //creating the upload object to store uploaded image details
        mDatabaseRef.child(key).setValue(category, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Toast.makeText(context, "Category details updated failed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Category details updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public static DatabaseReference getCategoriesRef(String language) {
        return database.getReference().child("home").child("News").child("Languages").child(language).child("Categories");
    }


    public static void createProfile(final LoginActivity loginActivity, final String social_id, String first_name, String last_name, String mobile, final String email, String login_type, String register_date) {
        mDatabaseRef = database.getReference().child("users");
        User user = new User(first_name, last_name, mobile, email, login_type, social_id, register_date);
        mDatabaseRef.child(mDatabaseRef.push().getKey()).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Toast.makeText(loginActivity, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                } else {
                    SharedPrefUtil.setBooleanPreference(loginActivity, "isLoggedIn", true);
                    SharedPrefUtil.setStringPreference(loginActivity, "email", email);
                    ((OnProfileCreateListener) loginActivity).onProfileCreated();
                }
            }
        });


    }


    public static boolean checkUserIsExits(final String email_mobile) {
        final boolean[] status = new boolean[1];
        mDatabaseRef = database.getReference().child("users");
        mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.child("email").getValue().equals(email_mobile)) {
                        Log.d("Email ", String.valueOf(data.child("email").getValue()));
                        status[0] = true;
                    } else {
                        status[0] = false;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        return status[0];
    }
}



/*    public static void videosStructureInFireBase() {
        mDatabaseRef = database.getReference().child("home").child("Videos");
        mDatabaseRef.child("Languages").setValue("languages", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                } else {
                    mDatabaseRef = database.getReference().child("home").child("Videos").child("Languages");
                    mDatabaseRef.child("Telugu").setValue("telugu", new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if (databaseError != null) {
                            } else {
                                mDatabaseRef = database.getReference().child("home").child("Videos").child("Languages").child("Telugu");
                                mDatabaseRef.child("Websites").setValue("websites", new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                        if (databaseError != null) {
                                        } else {

                                            mDatabaseRef = database.getReference().child("home").child("Videos").child("Languages").child("Telugu").child("Websites");
                                            mDatabaseRef.child("cat1").setValue(new Websites("Tollywood circle", "UCdtwPYK_0LG3ll1Op0iAMkQ", String.valueOf(new Date().getTime()), "youtube", "",""), new DatabaseReference.CompletionListener() {
                                                @Override
                                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                    if (databaseError != null) {
                                                    } else {
                                                    }
                                                }
                                            });


                                            mDatabaseRef = database.getReference().child("home").child("Videos").child("Languages").child("Telugu");
                                            mDatabaseRef.child("Categories").setValue(new MainApp("టాప్", "ముఖ్యాంశాలు", "ఆంధ్రప్రదేశ్", "తెలంగాణ", "జాతీయం", "రాజకీయం", "వినోదం", "క్రీడలు", "వ్యాపారం", "టెక్నాలజీ", "విద్య", "రాశి ఫలాలు"));
                                        }

                                    }
                                });
                            }
                        }
                    });

                }
            }
        });

    }*/


