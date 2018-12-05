package com.example.tsvetomirtonchev.userwiki;

import android.app.Application;

import com.example.tsvetomirtonchev.userwiki.data.di.component.AppComponent;
import com.example.tsvetomirtonchev.userwiki.data.di.component.DaggerAppComponent;
import com.example.tsvetomirtonchev.userwiki.data.di.module.AppModule;

public class App extends Application {

    private static AppComponent mAppComponent;

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
