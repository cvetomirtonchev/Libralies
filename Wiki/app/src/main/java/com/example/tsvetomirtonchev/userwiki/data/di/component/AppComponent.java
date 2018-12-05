package com.example.tsvetomirtonchev.userwiki.data.di.component;

import com.example.tsvetomirtonchev.userwiki.data.di.module.AppModule;
import com.example.tsvetomirtonchev.userwiki.data.di.module.RestServicesApiModule;
import com.example.tsvetomirtonchev.userwiki.data.repository.AlbumRepository;
import com.example.tsvetomirtonchev.userwiki.data.repository.UserRepository;
import com.example.tsvetomirtonchev.userwiki.data.rest.RestServices;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RestServicesApiModule.class})
public interface AppComponent {

    void inject(RestServices restServices);

    void inject(UserRepository userRepository);

    void inject(AlbumRepository albumRepository);
}
