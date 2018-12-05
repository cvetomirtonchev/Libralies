package com.example.tsvetomirtonchev.userwiki.data.repository;

import android.util.Log;

import com.example.tsvetomirtonchev.userwiki.App;
import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.data.rest.RestServices;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.tsvetomirtonchev.userwiki.data.rest.response.IResponseTypes.RESPONSE_ALBUM;
import static com.example.tsvetomirtonchev.userwiki.data.rest.response.IResponseTypes.RESPONSE_PHOTOS;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class AlbumRepository {

    private static final String TAG = AlbumRepository.class.getSimpleName();
    private static AlbumRepository sInstance = new AlbumRepository();

    @Inject
    public RestServices mRestServices;


    private AlbumRepository() {
        App.getAppComponent().inject(this);
    }

    public static AlbumRepository getInstance() {
        return sInstance;
    }

    public void getAllAlbums(final BasePresenter presenter, long userId) {
        mRestServices.getAllAlbums(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if (response != null && response.isSuccessful()) {
                    presenter.onDataReceived(RESPONSE_ALBUM, filterAlbumsForCurrentUser((List<Album>) response.body(), userId));
                } else {
                    presenter.onErrorReceived(RESPONSE_ALBUM, 1);
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e(TAG, "failed to load albums");
                presenter.onErrorReceived(RESPONSE_ALBUM, 1);
            }
        });
    }

    public void getAlbumsPhotos(final BasePresenter presenter, List<Album> albums) {
        mRestServices.getAlbumsPhotos(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response != null && response.isSuccessful()) {
                    presenter.onDataReceived(RESPONSE_PHOTOS, (List<Photo>) response.body());
                } else {
                    presenter.onErrorReceived(RESPONSE_PHOTOS, 1);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e(TAG, "failed to load albums");
                presenter.onErrorReceived(RESPONSE_PHOTOS, 1);
            }
        });

    }

    public List<Album> filterPhotoForAlbums(List<Photo> photos, List<Album> albums) {
        for (int i = 0; i < albums.size(); i++) {
            for (int y = 0; y < photos.size(); y++) {
                if (albums.get(i).getAlbumId() == photos.get(y).getAlbumId()) {
                    albums.get(i).addPhoto(photos.get(y));
                }
            }
        }
        return albums;
    }

    private List<Album> filterAlbumsForCurrentUser(List<Album> allAlbums, long userId) {
        List<Album> currentUserAlbums = new ArrayList<>();
        if (allAlbums != null) {
            for (int i = 0; i < allAlbums.size(); i++) {
                if (allAlbums.get(i).getUserId() == userId) {
                    currentUserAlbums.add(allAlbums.get(i));
                }
            }
        }
        return currentUserAlbums;
    }
}
