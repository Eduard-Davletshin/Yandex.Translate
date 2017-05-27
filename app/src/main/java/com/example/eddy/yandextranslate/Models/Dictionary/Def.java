package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;


public class Def implements Parcelable {

    public static final Creator<Def> CREATOR = new Creator<Def>() {
        @Override
        public Def createFromParcel(Parcel in) {
            return new Def(in);
        }

        @Override
        public Def[] newArray(int size) {
            return new Def[size];
        }
    };
    private String text;
    private String pos;
    private ArrayList<Tr> tr;

    protected Def(Parcel in) {
        text = in.readString();
        pos = in.readString();
        tr = in.createTypedArrayList(Tr.CREATOR);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public ArrayList<Tr> getTr() {
        return tr;
    }

    public void setTr(ArrayList<Tr> tr) {
        this.tr = tr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(pos);
        dest.writeTypedList(tr);
    }
}
