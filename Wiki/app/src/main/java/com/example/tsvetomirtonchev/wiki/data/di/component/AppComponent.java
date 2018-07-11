package com.example.tsvetomirtonchev.wiki.data.di.component;

import com.example.tsvetomirtonchev.wiki.data.di.module.AppModule;
import com.example.tsvetomirtonchev.wiki.data.di.module.RestServicesApiModule;
import com.example.tsvetomirtonchev.wiki.data.repository.WikiRepository;
import com.example.tsvetomirtonchev.wiki.data.rest.RestServices;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RestServicesApiModule.class})
public interface AppComponent {

    void inject(RestServices restServices);

    void inject(WikiRepository wikipedia);
}
