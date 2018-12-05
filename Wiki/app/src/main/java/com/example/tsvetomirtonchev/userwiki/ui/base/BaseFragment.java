package com.example.tsvetomirtonchev.userwiki.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BaseContract;

public class BaseFragment extends Fragment implements BaseContract.View {

    private ProgressBar mProgressBar;
    private View mNoDataView;
    private BaseContract.View mCurrentView;

    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        mProgressBar = rootView.findViewById(R.id.progress_bar);
        mCurrentView = this;
    }


    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(active ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}


