package com.example.tsvetomirtonchev.wiki.ui.main;

import com.example.tsvetomirtonchev.wiki.ui.base.mvp.BaseContract;

public interface MainActivityContract {

    interface View extends BaseContract.View {

        void showWikiInfo();
    }

    interface Presenter extends BaseContract.Presenter {

        void getWikiInfo(String name);
    }
}
