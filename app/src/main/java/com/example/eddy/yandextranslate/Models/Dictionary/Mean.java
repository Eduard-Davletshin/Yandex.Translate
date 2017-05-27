package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;

public class Mean implements Parcelable {
    public static final Creator<Mean> CREATOR = new Creator<Mean>() {
        @Override
        public Mean createFromParcel(Parcel in) {
            return new Mean(in);
        }

        @Override
        public Mean[] newArray(int size) {
            return new Mean[size];
        }
    };
    private String text;

    protected Mean(Parcel in) {
        text = in.readString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
    }
}
