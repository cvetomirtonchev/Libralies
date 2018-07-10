package com.example.tsvetomirtonchev.wiki.data.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.tsvetomirtonchev.wiki.BuildConfig;
import com.example.tsvetomirtonchev.wiki.data.di.rest.RestServices;
import com.example.tsvetomirtonchev.wiki.data.di.rest.RestServicesApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RestServicesApiModule {

    private static final int SECONDS = 60;
    public static final String REST_DATE_FORMAT = "yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'";
    private static final int DEFAULT_TIMEOUT = 1 * SECONDS; // minutes
    private static final String URL = "https://en.wikipedia.org/wiki/";
    private static final String TAG = RestServicesApiModule.class.getSimpleName();

    @Provides
    @Singleton
    public static RestServicesApi providesApiService(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder()
                .setDateFormat(REST_DATE_FORMAT)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(RestServicesApi.class);
    }

    @Provides
    @Singleton
    public static RestServices providesRestServices() {
        return new RestServices();
    }

    @Provides
    @Singleton
    public static OkHttpClient providesOkHttp() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .header("wiki", "ANDROID-" + BuildConfig.VERSION_NAME);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(interceptor);
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        return builder.build();
    }
}
