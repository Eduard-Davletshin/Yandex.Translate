package com.example.eddy.yandextranslate;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eddy.yandextranslate.AsyncTasks.DictionaryAsyncTask;
import com.example.eddy.yandextranslate.AsyncTasks.DictionaryCallback;
import com.example.eddy.yandextranslate.AsyncTasks.TranslatorAsyncTask;
import com.example.eddy.yandextranslate.AsyncTasks.TranslatorCallback;
import com.example.eddy.yandextranslate.Models.Dictionary.DictionaryResponse;
import com.example.eddy.yandextranslate.Models.Dictionary.Tr;
import com.example.eddy.yandextranslate.Models.Translate.TranslateResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static                   String   text_to_translate;
    @BindView(R.id.input_text)      EditText input_text;
    @BindView(R.id.translated_text) TextView translated_text;
    @BindView(R.id.main_toolbar)
    Toolbar        toolbar;
    @BindView(R.id.pos)
    TextView       pos;
    @BindView(R.id.syn)
    TextView       syn;
    @BindView(R.id.mean)
    TextView       mean;
    @BindView(R.id.ex)
    TextView       ex;
    @BindView(R.id.input_layout)
    RelativeLayout input_layout;
    @BindView(R.id.first_language_text)
    TextView       first_language_text;
    @BindView(R.id.second_language_text)
    TextView       second_language_text;
    @BindView(R.id.erase_image)
    ImageView      erase_image;
    TranslateResponse  translateResponse;
    DictionaryResponse dictionaryResponse;
    @Nullable
    TranslatorAsyncTask translatorAsyncTask;
    @Nullable
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
                text_to_translate = input_text.getText().toString();
                if (!text_to_translate.equals("")) {
                    if (translatorAsyncTask != null && translatorAsyncTask.getStatus() == AsyncTask
                        .Status.RUNNING) {
                        translatorAsyncTask.cancel(true);
                        translateText();
                    } else {
                        translateText();
                    }
                    if (dictionaryAsyncTask != null && dictionaryAsyncTask.getStatus() == AsyncTask
                        .Status.RUNNING) {
                        dictionaryAsyncTask.cancel(true);
                        getDictionaryForText();
                    } else {
                        getDictionaryForText();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        input_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    input_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    input_layout.setPadding(5, 5, 5, 5);
                } else {
                    input_layout.setBackgroundColor(getResources().getColor(R.color.borders));
                    input_layout.setPadding(2, 2, 2, 2);
                }
            }
        });

        erase_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_text.setText("");
                translated_text.setText("");
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
            public void onDictionaryComplete(DictionaryResponse callbackDictionaryResponse, boolean isError) {
                dictionaryResponse = callbackDictionaryResponse;
                if (isError) {
                    Toast.makeText(MainActivity.this, dictionaryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    if (dictionaryResponse != null) {
                        Tr getFirstTr = dictionaryResponse.getDef().get(0).getTr().get(0);
                        pos.setText(getFirstTr.getPos());
                        syn.setText(getFirstTr.getSyn().get(0).getText());
                        mean.setText(getFirstTr.getMean().get(0).getText());
                        ex.setText(getFirstTr.getEx().get(0).getText());
                    } else {
                        pos.setText(null);
                        syn.setText(null);
                        mean.setText(null);
                        ex.setText(null);
                    }
                }
            }
        }));
        dictionaryAsyncTask.execute();
    }
}
