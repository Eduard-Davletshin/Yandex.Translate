package com.example.eddy.yandextranslate.RequestInterfaces;

import com.example.eddy.yandextranslate.Models.Translate.TranslateResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface TranslateAPI {

    @POST("api/v1.5/tr.json/translate?lang=en-ru")
    Call<TranslateResponse> getTranslation(@Query("text") String text,
                                           @Query("key") String key
    );
}
