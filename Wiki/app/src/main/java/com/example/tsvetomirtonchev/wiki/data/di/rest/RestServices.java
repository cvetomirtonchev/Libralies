package com.example.tsvetomirtonchev.wiki.data.di.rest;

import android.content.Context;

import com.example.tsvetomirtonchev.wiki.App;

import javax.inject.Inject;

public class RestServices {

    @Inject
    public RestServicesApi restServicesApi;

    @Inject
    public Context context;

    public RestServices() {
        App.getAppComponent().inject(this);
    }
}
