package com.example.tsvetomirtonchev.wiki.data.rest;


import com.example.tsvetomirtonchev.wiki.data.rest.response.WikiResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestServicesApi {

    @GET("{name}")
    Call<ResponseBody> getWikiData(@Path("name")String pageName);

}
