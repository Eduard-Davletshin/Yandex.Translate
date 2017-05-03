package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by eddy on 4/7/2017.
 */

public class Ex implements Parcelable {
    public static final Creator<Ex> CREATOR = new Creator<Ex>() {
        @Override
        public Ex createFromParcel(Parcel in) {
            return new Ex(in);
        }

        @Override
        public Ex[] newArray(int size) {
            return new Ex[size];
        }
    };
    private String text;
    @SerializedName("tr")
    private ArrayList<Tr_ex> tr;

    protected Ex(Parcel in) {
        text = in.readString();
        tr = in.createTypedArrayList(Tr_ex.CREATOR);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Tr_ex> getTr() {
        return tr;
    }

    public void setTr(ArrayList<Tr_ex> tr) {
        this.tr = tr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeTypedList(tr);
    }
}
