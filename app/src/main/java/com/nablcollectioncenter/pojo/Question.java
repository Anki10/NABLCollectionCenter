package com.nablcollectioncenter.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by raj on 3/19/2018.
 */

public class Question implements Parcelable{

    private String QName;
    private List<String> options;
    int answerIndex = -1;

    public Question(){

    }
    protected Question(Parcel in) {
        QName = in.readString();
        options = in.createStringArrayList();
        answerIndex = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQName() {
        return QName;
    }

    public void setQName(String QName) {
        this.QName = QName;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(QName);
        parcel.writeStringList(options);
        parcel.writeInt(answerIndex);
    }
}
