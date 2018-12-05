package com.example.tsvetomirtonchev.userwiki.ui.login;

import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BaseContract;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018
 */
public interface LoginContract {

    interface View extends BaseContract.View {

        void handleLogin(User user);

        void enableViews();
    }

    interface Presenter extends BaseContract.Presenter {

        void loginUser(String id);
    }
}
