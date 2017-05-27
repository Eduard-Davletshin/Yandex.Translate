package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;

public class Tr_ex implements Parcelable {
    public static final Creator<Tr_ex> CREATOR = new Creator<Tr_ex>() {
        @Override
        public Tr_ex createFromParcel(Parcel in) {
            return new Tr_ex(in);
        }

        @Override
        public Tr_ex[] newArray(int size) {
            return new Tr_ex[size];
        }
    };
    private String text;

    protected Tr_ex(Parcel in) {
        text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
