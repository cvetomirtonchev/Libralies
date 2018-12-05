package com.example.tsvetomirtonchev.userwiki.util;

import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018
 */
public class SharedPreferenceManager {
    //Const
    private static final String PREF_NAME = SharedPreferenceManager.class.getName();
    private static final String CURRENT_USER = "current_user";
    //Data
    private static SharedPreferenceManager mInstance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mCurrentLanguageCode;
    private Context mContext;

    private SharedPreferenceManager(Context context) {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static synchronized SharedPreferenceManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPreferenceManager(context);
        }
        return mInstance;
    }

    public void saveCurrentUser(User user) {
        Gson gson = new Gson();
        String assetValue = gson.toJson(user);
        mEditor.putString(CURRENT_USER, assetValue).apply();
    }

    public User getCurrentUser() {
        Gson gson = new Gson();
        String assetValue = mSharedPreferences.getString(CURRENT_USER, "");
        if (!TextUtils.isEmpty(assetValue)) {
            return gson.fromJson(assetValue, User.class);
        }
        return null;
    }
}
