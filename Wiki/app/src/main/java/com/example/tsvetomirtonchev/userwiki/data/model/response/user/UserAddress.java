package com.example.tsvetomirtonchev.userwiki.data.model.response.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018
 */
public class UserAddress {
    @SerializedName("street")
    private String mStreet;
    @SerializedName("suite")
    private String mSuite;
    @SerializedName("city")
    private String mCity;
    @SerializedName("zipcode")
    private String mZipcode;

    public String getStreet() {
        return mStreet;
    }

    public String getSuite() {
        return mSuite;
    }

    public String getCity() {
        return mCity;
    }
}
