package com.example.tsvetomirtonchev.wiki.data.di.repository;

import android.util.Log;

import com.example.tsvetomirtonchev.wiki.App;
import com.example.tsvetomirtonchev.wiki.data.di.rest.RestServices;
import com.example.tsvetomirtonchev.wiki.data.di.rest.response.WikiResponse;
import com.example.tsvetomirtonchev.wiki.ui.base.mvp.BaseContract;
import com.example.tsvetomirtonchev.wiki.ui.main.MainActivityPresenter;

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
        mRestServices.getWikiData(page, new Callback<WikiResponse>() {
            @Override
            public void onResponse(Call<WikiResponse> call, Response<WikiResponse> response) {
                if (response != null && response.isSuccessful()) {
                   presenter.onDataReceived(1, response.body());
                }

            }

            @Override
            public void onFailure(Call<WikiResponse> call, Throwable t) {
                Log.e("Failed to get wiki info", TAG);
            }
        });
    }

}
