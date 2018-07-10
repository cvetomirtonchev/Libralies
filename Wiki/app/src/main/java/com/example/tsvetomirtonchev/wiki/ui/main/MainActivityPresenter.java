package com.example.tsvetomirtonchev.wiki.ui.main;

import com.example.tsvetomirtonchev.wiki.data.di.repository.WikiRepository;
import com.example.tsvetomirtonchev.wiki.ui.base.mvp.BasePresenter;

public class MainActivityPresenter extends BasePresenter implements MainActivityContract.Presenter{

     public MainActivityPresenter(MainActivityContract.View view) {
        mView = view;
    }

    @Override
    public void getWikiInfo(String name) {
        WikiRepository.getInstance().getWikiInformation(name);

    }

    @Override
    public void onDataReceived(int dataType, Object data) {

    }

    @Override
    public void onErrorReceived(int dataType, int errorCode) {

    }
}
