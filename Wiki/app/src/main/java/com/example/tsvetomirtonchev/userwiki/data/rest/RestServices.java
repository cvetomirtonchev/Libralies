package com.example.tsvetomirtonchev.userwiki.data.rest;

import android.content.Context;

import com.example.tsvetomirtonchev.userwiki.App;
import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public class RestServices {

    @Inject
    public RestServicesApi restServicesApi;

    @Inject
    public Context context;

    public RestServices() {
        App.getAppComponent().inject(this);
    }

    public void loginUser(String id, Callback<User> callback) {
        executeAsync(restServicesApi.loginUser(id), callback);
    }

    public void getAllAlbums(Callback<List<Album>> callback) {
        executeAsync(restServicesApi.getAllAlbums(), callback);
    }

    public void getAlbumsPhotos(Callback<List<Photo>> callback) {
        executeAsync(restServicesApi.getAllAlbumPhotos(), callback);
    }

    private void executeAsync(Call call, Callback callback) {
        call.enqueue(callback);
    }

}
