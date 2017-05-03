package com.example.eddy.yandextranslate.RetrofitSingletons;

import com.example.eddy.yandextranslate.RequestInterfaces.TranslateAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TranslateSingleton {

    private static TranslateSingleton instance = new TranslateSingleton();
    private TranslateAPI requestInterface;

    private TranslateSingleton() {
        String URL = "https://translate.yandex.net/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestInterface = retrofit.create(TranslateAPI.class);
    }

    public static TranslateSingleton getInstance() {
        return instance;
    }

    public TranslateAPI getRequestInterface() {
        return requestInterface;
    }
}