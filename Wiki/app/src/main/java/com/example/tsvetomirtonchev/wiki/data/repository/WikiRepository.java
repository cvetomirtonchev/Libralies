package com.example.tsvetomirtonchev.wiki.data.repository;


import android.annotation.TargetApi;
import android.util.Log;

import com.example.tsvetomirtonchev.wiki.App;
import com.example.tsvetomirtonchev.wiki.data.rest.RestServices;
import com.example.tsvetomirtonchev.wiki.ui.base.mvp.BaseContract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        return sInstance;
    }

    public void getWikiInformation(final BaseContract.Presenter presenter, final String page) {
        mRestServices.getWikiData(page, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.isSuccessful()) {
                    try {
                        presenter.onDataReceived(1, response.body().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Failed to get wiki info", TAG);
            }
        });
    }

}
