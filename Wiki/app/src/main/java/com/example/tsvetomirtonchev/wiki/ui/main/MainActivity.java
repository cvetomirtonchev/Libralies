package com.example.tsvetomirtonchev.wiki.ui.main;

import android.os.Bundle;

import com.example.tsvetomirtonchev.wiki.R;
import com.example.tsvetomirtonchev.wiki.data.di.rest.response.WikiResponse;
import com.example.tsvetomirtonchev.wiki.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainActivityPresenter(this);
        mPresenter.getWikiInfo("Bulgaria");

    }

    @Override
    public void showWikiInfo(WikiResponse wikiResponse) {

    }
}
