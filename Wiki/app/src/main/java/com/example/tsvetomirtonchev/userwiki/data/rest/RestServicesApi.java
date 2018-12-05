package com.example.tsvetomirtonchev.userwiki.data.rest;

import com.example.tsvetomirtonchev.userwiki.data.model.response.album.Album;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.data.model.response.post.Post;
import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestServicesApi {

    @GET("/users/{id}")
    Call<User> loginUser(@Path("id") String userId);

    @GET("/albums")
    Call<List<Album>> getAllAlbums();

    @GET("/photos")
    Call<List<Photo>> getAllAlbumPhotos();

    @GET("/posts")
    Call<List<Post>> getUserPosts(@Query("userId") String userId);

    @PUT("/posts")
    Call<ResponseBody> makePost(@Body Post post);
}
