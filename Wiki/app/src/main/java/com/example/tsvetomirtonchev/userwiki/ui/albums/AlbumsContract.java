package com.example.tsvetomirtonchev.userwiki.ui.albums;

import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BaseContract;

import java.util.List;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public interface AlbumsContract {
    interface View extends BaseContract.View {

        void handleAlbums(List<Album> albumList);

        void handlePhotos(List<Photo> photos);

    }

    interface Presenter extends BaseContract.Presenter {

        void getAlbums(long userId);

        void getPhotos(List<Album> albums);

        List<Album> addPhotosForEveryAlbum(List<Photo> photos, List<Album> albumList);
    }
}
