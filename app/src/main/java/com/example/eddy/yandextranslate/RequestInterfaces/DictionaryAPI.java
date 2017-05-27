package com.example.eddy.yandextranslate.RequestInterfaces;

import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface DictionaryAPI {

    @POST("api/v1/dicservice.json/lookup?lang=en-ru")
    Call<DictionaryResponse> getDictionary(@Query("text") String text,
                                           @Query("key") String key
    );
}
