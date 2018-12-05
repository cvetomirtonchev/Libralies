package com.example.tsvetomirtonchev.userwiki.ui.albums.photos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;

import java.util.List;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {
    private List<Photo> mPhotos;
    private Context mContext;

    PhotosAdapter(List<Photo> photos, Context context) {
        mPhotos = photos;
        mContext = context;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_album_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);
        if (TextUtils.isEmpty(photo.getUrl())) {
            Glide.with(mContext).load(photo.getUrl()).
                    into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.album_image_view);
        }
    }
}
