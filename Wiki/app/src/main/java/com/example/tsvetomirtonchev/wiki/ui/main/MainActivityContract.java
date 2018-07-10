package com.example.tsvetomirtonchev.wiki.ui.main;

import com.example.tsvetomirtonchev.wiki.data.di.rest.response.WikiResponse;
import com.example.tsvetomirtonchev.wiki.ui.base.mvp.BaseContract;

public interface MainActivityContract {

    interface View extends BaseContract.View {

        void showWikiInfo(WikiResponse wikiResponse);
    }

    interface Presenter extends BaseContract.Presenter {

        void getWikiInfo(String name);
    }
}
