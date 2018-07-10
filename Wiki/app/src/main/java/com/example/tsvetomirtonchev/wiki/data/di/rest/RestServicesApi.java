package com.example.tsvetomirtonchev.wiki.data.di.rest;

import com.example.tsvetomirtonchev.wiki.data.di.rest.response.WikiResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestServicesApi {

    @GET("{name}")
    Call<WikiResponse> getWikiData(@Path("name")String pageName);

}
