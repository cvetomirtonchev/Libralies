package com.example.tsvetomirtonchev.userwiki.data.model.response.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018
 */
public class User {
    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("address")
    private UserAddress mAddress;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("website")
    private String mWebsite;

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public UserAddress getAddress() {
        return mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return mWebsite;
    }
}
