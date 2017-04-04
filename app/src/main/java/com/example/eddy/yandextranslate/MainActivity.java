package com.example.eddy.yandextranslate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    Response response;
    TranslatorAsyncTask translatorAsyncTask;
    @BindView(R.id.translate)
    Button translate;

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
        translatorAsyncTask = new TranslatorAsyncTask(new Callback() {
            @Override
            public void onTranslationComplete(Response callbackResponse) {
                response = callbackResponse;
                if (response != null) {
                    translated_text.setText(response.getText().get(0));
                }
                else {
                    translated_text.setText(null);
                }
            }
        });
        translatorAsyncTask.execute();
    }
}
