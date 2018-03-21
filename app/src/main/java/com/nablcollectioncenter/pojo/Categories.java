package com.nablcollectioncenter.pojo;

import android.content.Loader;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by raj on 3/19/2018.
 */
public class Categories implements Parcelable{

    private String cat_name;
    private ArrayList<Question> list;

    public Categories(){

    }


    protected Categories(Parcel in) {
        cat_name = in.readString();
        list = in.readArrayList(Question.class.getClassLoader());
    }


    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories(in);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public ArrayList<Question> getList() {
        return list;
    }

    public void setList(ArrayList<Question> list) {
        this.list = list;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cat_name);
        parcel.writeTypedList(list);
    }
}
