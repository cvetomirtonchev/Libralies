package com.example.tsvetomirtonchev.userwiki.data.model.response.album;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class Album implements Parcelable {
    @SerializedName("userId")
    private long mUserId;
    @SerializedName("id")
    private long mAlbumId;
    @SerializedName("title")
    private String mTitle;
    private List<Photo> mPhotos;

    protected Album(Parcel in) {
        mUserId = in.readLong();
        mAlbumId = in.readLong();
        mTitle = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public long getUserId() {
        return mUserId;
    }

    public long getAlbumId() {
        return mAlbumId;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void addPhoto(Photo photo) {
        if (mPhotos == null) {
            mPhotos = new ArrayList<>();
        }
        mPhotos.add(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mUserId);
        dest.writeLong(mAlbumId);
        dest.writeString(mTitle);
    }
}
