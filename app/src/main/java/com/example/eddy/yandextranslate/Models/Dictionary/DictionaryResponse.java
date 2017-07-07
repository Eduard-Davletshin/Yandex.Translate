package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DictionaryResponse implements Parcelable {

    public static final Creator<DictionaryResponse> CREATOR = new Creator<DictionaryResponse>() {
        @Override
        public DictionaryResponse createFromParcel(Parcel in) {
            return new DictionaryResponse(in);
        }

        @Override
        public DictionaryResponse[] newArray(int size) {
            return new DictionaryResponse[size];
        }
    };

    private Head           head;
    private ArrayList<Def> def;
    private Integer        code;
    private String         message;

    private DictionaryResponse(Parcel in) {
        def = in.createTypedArrayList(Def.CREATOR);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Def> getDef() {
        return def;
    }

    public void setDef(ArrayList<Def> def) {
        this.def = def;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(def);
    }
}

