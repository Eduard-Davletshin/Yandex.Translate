package com.example.eddy.yandextranslate.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;
import com.example.eddy.yandextranslate.RetrofitSingletons.DictionarySingleton;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Response;

import static com.example.eddy.yandextranslate.MainActivity.text_to_translate;


public class DictionaryAsyncTask extends AsyncTask<Object, Object, DictionaryResponse> {

    static final String DICTIONARY_API_KEY = "dict.1.1.20170404T181456Z.4b08b7ccb835f2b5.23f70f0eed75bef4e95aeab26ea8ed8636540494";
    private String             s;
    private DictionaryResponse dictionaryResponse;
    private DictionaryCallback callback;
    private boolean            isError;

    public DictionaryAsyncTask(DictionaryCallback callback) {
        this.callback = callback;
    }

    @Override
    protected DictionaryResponse doInBackground(Object... params) {
        try {
            if (text_to_translate != null) {
                Response<DictionaryResponse> response = DictionarySingleton.getInstance()
                    .getRequestInterface().getDictionary(text_to_translate, DICTIONARY_API_KEY).execute();
                if (response.raw().networkResponse().code() != 200) {
                    isError = true;
                    s = response.errorBody().string();
                    Gson gson = new Gson();
                    dictionaryResponse = gson.fromJson(s, DictionaryResponse.class);
                } else {
                    dictionaryResponse = response.body();
                }

            } else {
                dictionaryResponse = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", "No dictionary response");
        }
        return dictionaryResponse;
    }

    @Override
    protected void onPostExecute(DictionaryResponse d) {
        super.onPostExecute(d);
        callback.onDictionaryComplete(dictionaryResponse, isError);
    }
}
