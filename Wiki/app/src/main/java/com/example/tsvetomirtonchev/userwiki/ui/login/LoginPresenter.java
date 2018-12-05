package com.example.tsvetomirtonchev.userwiki.ui.login;

import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;
import com.example.tsvetomirtonchev.userwiki.data.repository.UserRepository;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BasePresenter;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018
 */
public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void loginUser(String id) {
        UserRepository.getInstance().loginUser(this, id);

    }

    @Override
    public void onDataReceived(int dataType, Object data) {
        if (!mView.isActive()) {
            return;
        }
        switch (dataType) {
            case 1:
                ((LoginContract.View) mView).handleLogin((User) data);
        }
    }

    @Override
    public void onErrorReceived(int dataType, int errorCode) {
        ((LoginContract.View) mView).enableViews();
    }
}

