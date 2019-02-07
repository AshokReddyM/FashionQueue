package com.fashionqueue.app.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.fashionqueue.app.data.modals.Profile;
import com.fashionqueue.app.interfaces.OnProfileCreateListener;
import com.fashionqueue.app.login.login_activity.LoginActivity;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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


    public static void createProfile(final LoginActivity loginActivity, String userHashKey, String first_name, String last_name, int gender, String mobile, String dob, String email) {
        mDatabaseRef=database.getReference().child(userHashKey);
        Profile profile=new Profile(first_name,last_name,mobile,gender,email,dob);
        mDatabaseRef.child("profile").setValue(profile, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                } else {
                    ((OnProfileCreateListener)loginActivity).onProfileCreated();
                }
            }
        });



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


