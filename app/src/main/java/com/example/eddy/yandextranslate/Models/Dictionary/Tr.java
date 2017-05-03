package com.example.eddy.yandextranslate.Models.Dictionary;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

class Tr implements Parcelable {
    public static final Creator<Tr> CREATOR = new Creator<Tr>() {
        @Override
        public Tr createFromParcel(Parcel in) {
            return new Tr(in);
        }

        @Override
        public Tr[] newArray(int size) {
            return new Tr[size];
        }
    };
    private String text;
    private String pos;
    private ArrayList<Syn> syn;
    private ArrayList<Mean> mean;
    private ArrayList<Ex> ex;

    protected Tr(Parcel in) {
        text = in.readString();
        pos = in.readString();
        syn = in.createTypedArrayList(Syn.CREATOR);
        mean = in.createTypedArrayList(Mean.CREATOR);
        ex = in.createTypedArrayList(Ex.CREATOR);
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

    public ArrayList<Syn> getSyn() {
        return syn;
    }

    public void setSyn(ArrayList<Syn> syn) {
        this.syn = syn;
    }

    public ArrayList<Mean> getMean() {
        return mean;
    }

    public void setMean(ArrayList<Mean> mean) {
        this.mean = mean;
    }

    public ArrayList<Ex> getEx() {
        return ex;
    }

    public void setEx(ArrayList<Ex> ex) {
        this.ex = ex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(pos);
        dest.writeTypedList(syn);
        dest.writeTypedList(mean);
        dest.writeTypedList(ex);
    }
}
