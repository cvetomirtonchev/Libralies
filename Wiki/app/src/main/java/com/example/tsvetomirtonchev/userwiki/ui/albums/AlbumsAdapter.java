package com.example.tsvetomirtonchev.userwiki.ui.albums;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;

import java.util.List;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {
    private List<Album> mAlbums;
    private Context mContext;
    private AlbumListener mListener;

    AlbumsAdapter(List<Album> albums, Context context, AlbumListener listener) {
        mAlbums = albums;
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlbumViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_album_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = mAlbums.get(position);
        holder.mTitleTextView.setText(album.getTitle());
        // set first image for cover
        Glide.with(mContext).load(album.getPhotos().get(0).getThumbnailUrl()).
                into(holder.mImageView);
        holder.mImageView.setOnClickListener(v -> {
            mListener.onImageClicked(mAlbums.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private ImageView mImageView;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.album_title_tv);
            mImageView = itemView.findViewById(R.id.album_image_view);
        }
    }

    interface AlbumListener {

        void onImageClicked(Album album);
    }
}
