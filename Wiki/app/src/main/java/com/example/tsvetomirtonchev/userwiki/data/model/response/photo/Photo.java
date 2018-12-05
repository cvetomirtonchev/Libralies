package com.example.tsvetomirtonchev.userwiki.data.model.response.photo;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class Photo implements Parcelable {
    @SerializedName("albumId")
    private long mAlbumId;
    @SerializedName("id")
    private long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl;

    protected Photo(Parcel in) {
        mAlbumId = in.readLong();
        mId = in.readLong();
        mTitle = in.readString();
        mUrl = in.readString();
        mThumbnailUrl = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public long getAlbumId() {
        return mAlbumId;
    }

    public long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mAlbumId);
        dest.writeLong(mId);
        dest.writeString(mTitle);
        dest.writeString(mUrl);
        dest.writeString(mThumbnailUrl);
    }
}
