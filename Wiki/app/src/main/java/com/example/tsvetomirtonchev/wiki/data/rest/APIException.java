package com.example.tsvetomirtonchev.wiki.data.di.rest;

import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class APIException extends Exception {

    public static final String TAG = APIException.class.getSimpleName();

    private final int mStatus;
    private String mMessage;

    public APIException(Response response) throws IOException {
        mStatus = response.code();
        mMessage = "";
        try {
            if (response.errorBody() != null) {
                mMessage = response.errorBody().string();
            }
        } catch (IOException e) {
            mMessage = "Can not read error message";
            Log.e(TAG, mMessage, e);
        }
    }

    public int getStatus() {
        return mStatus;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }
}
