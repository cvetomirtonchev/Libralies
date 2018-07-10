package com.example.tsvetomirtonchev.wiki.ui.base.mvp;

import android.content.Context;

public interface BaseContract {

    interface View {

        boolean isActive();

        void setLoadingIndicator(boolean active);

        Context getContext();

    }

    interface Presenter {

        void onDataReceived(int dataType, Object data);

        void onErrorReceived(int dataType, int errorCode);

    }

}
