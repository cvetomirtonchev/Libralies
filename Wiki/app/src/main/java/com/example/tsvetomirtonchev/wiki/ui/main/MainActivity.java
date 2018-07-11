package com.example.tsvetomirtonchev.wiki.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tsvetomirtonchev.wiki.R;
import com.example.tsvetomirtonchev.wiki.ui.base.BaseActivity;
import com.example.tsvetomirtonchev.wiki.util.TextViewUtils;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter mPresenter;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializedVariables();
        mPresenter = new MainActivityPresenter(this);
        mPresenter.getWikiInfo("Bulgaria");


    }

    @Override
    public void showWikiInfo(String wikiResponse) {
        mTextView.setText(TextViewUtils.fromHtml(wikiResponse));

    }

    private void initializedVariables() {
        mTextView = findViewById(R.id.wiki_tv);
    }
}
