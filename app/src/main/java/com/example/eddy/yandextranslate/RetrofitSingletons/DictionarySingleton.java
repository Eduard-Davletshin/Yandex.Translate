package com.example.eddy.yandextranslate.RetrofitSingletons;

import com.example.eddy.yandextranslate.RequestInterfaces.DictionaryAPI;
import com.example.eddy.yandextranslate.RequestInterfaces.TranslateAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DictionarySingleton {

    private static DictionarySingleton instance = new DictionarySingleton();
    private DictionaryAPI requestInterface;

    private DictionarySingleton() {
        String URL = "https://dictionary.yandex.net/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestInterface = retrofit.create(DictionaryAPI.class);
    }

    public static DictionarySingleton getInstance() {
        return instance;
    }

    public DictionaryAPI getRequestInterface() {
        return requestInterface;
    }

}
