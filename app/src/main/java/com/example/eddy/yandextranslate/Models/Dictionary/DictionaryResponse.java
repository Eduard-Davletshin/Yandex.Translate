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
    private String head;
    private ArrayList<Def> def;

    protected DictionaryResponse(Parcel in) {
        head = in.readString();
        def = in.createTypedArrayList(Def.CREATOR);
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public ArrayList<Def> getDef() {
        return def;
    }

    public void setDef(ArrayList<Def> def) {
        this.def = def;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(head);
        dest.writeTypedList(def);
    }
}

