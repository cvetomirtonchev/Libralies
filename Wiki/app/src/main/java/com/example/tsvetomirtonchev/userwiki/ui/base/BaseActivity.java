package com.example.tsvetomirtonchev.userwiki.ui.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BaseContract;

public abstract class  BaseActivity extends AppCompatActivity implements BaseContract.View {

    private boolean mIsActive;

    @Override
    protected void onStart() {
        super.onStart();
        mIsActive = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mIsActive = false;
    }

    @Override
    public boolean isActive() {
        return mIsActive;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }
}
