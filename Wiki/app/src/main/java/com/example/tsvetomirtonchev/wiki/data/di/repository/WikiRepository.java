package com.example.tsvetomirtonchev.wiki.data.di.repository;

import com.example.tsvetomirtonchev.wiki.App;
import com.example.tsvetomirtonchev.wiki.data.di.rest.RestServices;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WikiRepository {

    private static final String TAG = WikiRepository.class.getSimpleName();
    private static WikiRepository sInstance = new WikiRepository();

    @Inject
    public RestServices mRestServices;


    private WikiRepository() {
        App.getAppComponent().inject(this);
    }

    public static WikiRepository getInstance() {
        if(sInstance == null){
            return new WikiRepository();
        }
        return sInstance;
    }

    public void getWikiInformation(final String page){
        mRestServices.getWikiData(page, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
