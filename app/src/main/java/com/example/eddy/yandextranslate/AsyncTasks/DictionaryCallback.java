package com.example.eddy.yandextranslate.AsyncTasks;

import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;
import com.example.eddy.yandextranslate.Models.Translate.TranslateResponse;


public interface DictionaryCallback {

    void onDictionaryComplete(DictionaryResponse callbackDictionaryResponse);

}
