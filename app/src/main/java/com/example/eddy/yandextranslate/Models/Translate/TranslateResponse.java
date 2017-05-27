package com.example.eddy.yandextranslate.Models.Translate;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class TranslateResponse implements Parcelable {

    public static final Creator<TranslateResponse> CREATOR = new Creator<TranslateResponse>() {
        @Override
        public TranslateResponse createFromParcel(Parcel in) {
            return new TranslateResponse(in);
        }

        @Override
        public TranslateResponse[] newArray(int size) {
            return new TranslateResponse[size];
        }
    };
    private int code;
    private String lang;
    private ArrayList<String> text;

    private TranslateResponse(Parcel in) {
        code = in.readInt();
        lang = in.readString();
        text = in.createStringArrayList();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(lang);
        dest.writeStringList(text);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
