package com.example.eddy.yandextranslate;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import static com.example.eddy.yandextranslate.MainActivity.text_to_translate;


public class TranslatorAsyncTask extends AsyncTask<Object, Object, Response> {
    private Response response;
    private Callback callback;

    public TranslatorAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected Response doInBackground(Object... params) {
        try {
            if (text_to_translate != null) {
                response = RetrofitSingleton.getInstance().getRequestInterface().getResponse(text_to_translate).execute()
                        .body();
            } else {
                response = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", "No response");
        }
        return response;
    }

    @Override
    protected void onPostExecute(Response r) {
        super.onPostExecute(r);
        callback.onTranslationComplete(response);
    }
}
