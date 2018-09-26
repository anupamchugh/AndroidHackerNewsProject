package com.anupamchugh.androidhackernewsproject;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    SharedPreferences sharedPreferences;
    Context mContext;
    // shared pref mode
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "sessionPref";
    SharedPreferences.Editor editor;

    private static final String IS_LOGGED_IN = "IS_LOGGED_IN";
    private static final String ID_TOKEN = "ID_TOKEN";
    private static final String EMAIL_KEY = "EMAIL";
    private static final String NAME_KEY = "NAME";
    private static final String TIME_KEY = "TIMESTAMP";
    private static final String PHOTO_KEY = "PHOTO";

    public SharedPrefManager(Context context) {
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

    }


    public void saveIsLoggedIn(Context context, Boolean isLoggedIn) {
        mContext = context;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn);
        editor.apply();

    }

    public boolean getISLogged_IN() {
        //mContext = context;
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void saveToken(Context context, String toke) {
        mContext = context;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ID_TOKEN, toke);
        editor.apply();
    }

    public String getUserToken() {
        //mContext = context;
        return sharedPreferences.getString(ID_TOKEN, "");
    }

    public void saveEmail(Context context, String email) {
        mContext = context;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL_KEY, email);
        editor.apply();
    }

    public String getUserEmail() {
        return sharedPreferences.getString(EMAIL_KEY, null);
    }


    public void saveName(Context context, String name) {
        mContext = context;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, name);
        editor.apply();
    }

    public void saveTimeStamp(long timeStamp) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(TIME_KEY, timeStamp);
        editor.apply();
    }

    public Long getTimeStamp() {
        return sharedPreferences.getLong(TIME_KEY, 0);
    }

    public String getName() {
        return sharedPreferences.getString(NAME_KEY, null);
    }

    public void savePhoto(Context context, String photo) {
        mContext = context;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PHOTO_KEY, photo);
        editor.apply();
    }

    public String getPhoto() {
        return sharedPreferences.getString(PHOTO_KEY, null);
    }

    public void clear() {
        editor.clear();
        editor.apply();
    }
}
