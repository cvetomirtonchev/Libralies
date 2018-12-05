package com.example.tsvetomirtonchev.userwiki.ui.albums;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.ui.albums.photos.PhotosActivity;
import com.example.tsvetomirtonchev.userwiki.ui.base.BaseFragment;
import com.example.tsvetomirtonchev.userwiki.util.SharedPreferenceManager;

import java.util.ArrayList;
import java.util.List;

import static com.example.tsvetomirtonchev.userwiki.ui.albums.photos.PhotosActivity.ALBUMS;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018
 */
public class AlbumsFragment extends BaseFragment implements AlbumsContract.View, AlbumsAdapter.AlbumListener {
    //Data
    private List<Album> mAlbums;
    private List<Photo> mPhotos;
    private SharedPreferenceManager mSharedPreferenceManager;
    private boolean a;
    //Presenter
    private AlbumsContract.Presenter mPresenter;
    //Views
    private RecyclerView mRecyclerView;

    public AlbumsFragment() {
        // Required empty public constructor
    }

    public static AlbumsFragment newInstance() {
        AlbumsFragment fragment = new AlbumsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        mRecyclerView = view.findViewById(R.id.album_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        mPresenter = new AlbumsPresenter(this);
        mSharedPreferenceManager = SharedPreferenceManager.getInstance(getActivity());
        if (mAlbums == null) {
            mPresenter.getAlbums(mSharedPreferenceManager.getCurrentUser().getId());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //TODO need to be added logic
    }

    @Override
    public void handleAlbums(List<Album> albumList) {
        mAlbums = albumList;
        mPresenter.getPhotos(albumList);
    }

    @Override
    public void handlePhotos(List<Photo> photos) {
        mPhotos = photos;
        mAlbums = mPresenter.addPhotosForEveryAlbum(photos, mAlbums);
        mRecyclerView.setAdapter(new AlbumsAdapter(mAlbums, getActivity(), this));
    }

    @Override
    public void onImageClicked(Album album) {
        Intent intent = new Intent(getContext(), PhotosActivity.class);
        intent.putParcelableArrayListExtra(ALBUMS, (ArrayList<Photo>) album.getPhotos());
        startActivity(intent);
    }
}
