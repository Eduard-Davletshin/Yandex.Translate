package com.example.eddy.yandextranslate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eddy.yandextranslate.AsyncTasks.DictionaryAsyncTask;
import com.example.eddy.yandextranslate.AsyncTasks.DictionaryCallback;
import com.example.eddy.yandextranslate.AsyncTasks.TranslatorCallback;
import com.example.eddy.yandextranslate.AsyncTasks.TranslatorAsyncTask;
import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;
import com.example.eddy.yandextranslate.Models.Translate.TranslateResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static String text_to_translate;
    @BindView(R.id.input_text)
    EditText input_text;
    @BindView(R.id.translated_text)
    TextView translated_text;
    @BindView(R.id.my_toolbar)
    Toolbar toolbar;
    @BindView(R.id.dictionary)
    ListView dictionary_listview;
    TranslateResponse translateResponse;
    TranslatorAsyncTask translatorAsyncTask;
    DictionaryResponse dictionaryResponse;
    DictionaryAsyncTask dictionaryAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.app_name);
        input_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                text_to_translate = input_text.getText().toString();
                translateText();
            }
        });
    }

    public void translateText() {
        translatorAsyncTask = new TranslatorAsyncTask(new TranslatorCallback() {
            @Override
            public void onTranslationComplete(TranslateResponse callbackTranslateResponse) {
                translateResponse = callbackTranslateResponse;
                if (translateResponse != null) {
                    translated_text.setText(translateResponse.getText().get(0));
                } else {
                    translated_text.setText(null);
                }
            }
        });
        translatorAsyncTask.execute();
    }

    public void getDictionaryForText() {
        dictionaryAsyncTask = new DictionaryAsyncTask((new DictionaryCallback() {
            @Override
            public void onDictionaryComplete(DictionaryResponse callbackDictionaryResponse) {
                dictionaryResponse = callbackDictionaryResponse;
                if (dictionaryResponse != null) {

                } else {
                    translated_text.setText(null);
                }
            }
        }));
    }
}
