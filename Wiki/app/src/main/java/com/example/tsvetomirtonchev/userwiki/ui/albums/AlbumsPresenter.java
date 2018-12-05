package com.example.tsvetomirtonchev.userwiki.ui.albums;

import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.data.repository.AlbumRepository;
import com.example.tsvetomirtonchev.userwiki.ui.base.mvp.BasePresenter;

import java.util.List;

import static com.example.tsvetomirtonchev.userwiki.data.rest.response.IResponseTypes.RESPONSE_ALBUM;
import static com.example.tsvetomirtonchev.userwiki.data.rest.response.IResponseTypes.RESPONSE_PHOTOS;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class AlbumsPresenter extends BasePresenter implements AlbumsContract.Presenter {

    public AlbumsPresenter(AlbumsContract.View view) {
        mView = view;
    }

    @Override
    public void getAlbums(long userId) {
        AlbumRepository.getInstance().getAllAlbums(this, userId);
    }

    @Override
    public void getPhotos(List<Album> albums) {
        AlbumRepository.getInstance().getAlbumsPhotos(this, albums);
    }

    @Override
    public List<Album> addPhotosForEveryAlbum(List<Photo> photos, List<Album> albumList) {
        return AlbumRepository.getInstance().filterPhotoForAlbums(photos, albumList);
    }

    @Override
    public void onDataReceived(int dataType, Object data) {
        switch (dataType) {
            case RESPONSE_ALBUM:
                ((AlbumsContract.View) mView).handleAlbums((List<Album>) data);
                break;
            case RESPONSE_PHOTOS:
                ((AlbumsContract.View) mView).handlePhotos((List<Photo>) data);
                break;
        }

    }

    @Override
    public void onErrorReceived(int dataType, int errorCode) {

    }
}
