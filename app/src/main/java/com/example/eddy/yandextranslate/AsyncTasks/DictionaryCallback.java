package com.example.eddy.yandextranslate.AsyncTasks;

import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;


public interface DictionaryCallback {

    void onDictionaryComplete(DictionaryResponse callbackDictionaryResponse, boolean isError);
//    void onDictionaryError(DictionaryResponseError responseError);
}
