package com.example.tsvetomirtonchev.userwiki.data.repository;


import android.util.Log;

import com.example.tsvetomirtonchev.userwiki.App;
import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;
import com.example.tsvetomirtonchev.userwiki.data.rest.RestServices;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BaseContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.tsvetomirtonchev.userwiki.data.rest.response.IResponseTypes.RESPONSE_USER;

public class UserRepository {

    private static final String TAG = UserRepository.class.getSimpleName();
    private static UserRepository sInstance = new UserRepository();

    @Inject
    public RestServices mRestServices;


    private UserRepository() {
        App.getAppComponent().inject(this);
    }

    public static UserRepository getInstance() {
        return sInstance;
    }

    public void loginUser(final BaseContract.Presenter presenter, final String id) {
        mRestServices.loginUser(id, new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response != null && response.isSuccessful()) {
                    presenter.onDataReceived(RESPONSE_USER, response.body());
                } else {
                    presenter.onErrorReceived(RESPONSE_USER, 1);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Failed to get wiki info", TAG);
                presenter.onErrorReceived(RESPONSE_USER, 1);
            }
        });
    }

}
