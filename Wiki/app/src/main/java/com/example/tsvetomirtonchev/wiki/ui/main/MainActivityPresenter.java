package com.example.tsvetomirtonchev.wiki.ui.main;

import com.example.tsvetomirtonchev.wiki.data.di.repository.WikiRepository;
import com.example.tsvetomirtonchev.wiki.data.di.rest.response.WikiResponse;
import com.example.tsvetomirtonchev.wiki.ui.base.mvp.BasePresenter;

public class MainActivityPresenter extends BasePresenter implements MainActivityContract.Presenter {

    public MainActivityPresenter(MainActivityContract.View view) {
        mView = view;
    }

    @Override
    public void getWikiInfo(String name) {
        WikiRepository.getInstance().getWikiInformation(this, name);

    }

    @Override
    public void onDataReceived(int dataType, Object data) {
        if (!mView.isActive()) {
            return;
        }
        switch (dataType) {
            case 1:
                ((MainActivityContract.View) mView).showWikiInfo((WikiResponse) data);
        }

    }

    @Override
    public void onErrorReceived(int dataType, int errorCode) {

    }
}
