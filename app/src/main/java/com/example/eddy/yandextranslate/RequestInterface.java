package com.example.eddy.yandextranslate;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface RequestInterface {

    @POST("api/v1.5/tr.json/translate?lang=en-ru&key=trnsl.1.1.20170326T150556Z.5522637a85e74abe.a63e4958467a4690262f902428edc7217fd5caab")
    Call<Response> getResponse(@Query("text") String text_to_translate);
}
