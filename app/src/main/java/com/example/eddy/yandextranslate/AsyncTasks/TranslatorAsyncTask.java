package com.example.eddy.yandextranslate.AsyncTasks;

import android.os.AsyncTask;

import com.example.eddy.yandextranslate.Models.Translate.TranslateResponse;
import com.example.eddy.yandextranslate.RetrofitSingletons.TranslateSingleton;
import com.google.gson.Gson;

import java.io.IOException;

import static com.example.eddy.yandextranslate.MainActivity.text_to_translate;


public class TranslatorAsyncTask extends AsyncTask<Object, Object, TranslateResponse> {

    static final String TRANSLATE_API_KEY = "trnsl.1.1.20170326T150556Z.5522637a85e74abe.a63e4958467a4690262f902428edc7217fd5caab";
    private TranslateResponse translateResponse;
    private TranslatorCallback callback;

    public TranslatorAsyncTask(TranslatorCallback callback) {
        this.callback = callback;
    }

    @Override
    protected TranslateResponse doInBackground(Object... params) {
        try {
            if (text_to_translate != null) {
                translateResponse = TranslateSingleton.getInstance().getRequestInterface()
                        .getTranslation(text_to_translate, TRANSLATE_API_KEY).execute()
                        .body();
            } else {
                translateResponse = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return translateResponse;
    }

    @Override
    protected void onPostExecute(TranslateResponse r) {
        super.onPostExecute(r);
        callback.onTranslationComplete(translateResponse);
    }
}
