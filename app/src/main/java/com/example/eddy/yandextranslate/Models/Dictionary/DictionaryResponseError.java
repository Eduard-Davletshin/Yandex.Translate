package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eddy on 25.05.17.
 */

public class DictionaryResponseError implements Parcelable {
    public static final Creator<DictionaryResponseError> CREATOR = new Creator<DictionaryResponseError>() {
        @Override
        public DictionaryResponseError createFromParcel(Parcel in) {
            return new DictionaryResponseError(in);
        }

        @Override
        public DictionaryResponseError[] newArray(int size) {
            return new DictionaryResponseError[size];
        }
    };
    private Integer code;
    private String message;

    public DictionaryResponseError() {
    }

    public DictionaryResponseError(Parcel in) {
        message = in.readString();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
