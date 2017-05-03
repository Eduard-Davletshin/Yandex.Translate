package com.example.eddy.yandextranslate.AsyncTasks;


import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;
import com.example.eddy.yandextranslate.Models.Translate.TranslateResponse;

public interface TranslatorCallback {
    void onTranslationComplete(TranslateResponse callbackTranslateResponse);

}
