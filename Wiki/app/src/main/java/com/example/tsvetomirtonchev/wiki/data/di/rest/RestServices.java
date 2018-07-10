package com.example.tsvetomirtonchev.wiki.data.di.rest;

import android.content.Context;

import com.example.tsvetomirtonchev.wiki.App;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestServices {

    @Inject
    public RestServicesApi restServicesApi;

    @Inject
    public Context context;

    public RestServices() {
        App.getAppComponent().inject(this);
    }

    public void getWikiData(String pageName, Callback<ResponseBody> callback) {
        executeAsync(restServicesApi.getWikiData(pageName), callback);
    }

    private void executeAsync(Call call, Callback callback) {
        call.enqueue(callback);
    }

}
