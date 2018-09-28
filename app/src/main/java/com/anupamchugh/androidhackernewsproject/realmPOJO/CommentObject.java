package com.anupamchugh.androidhackernewsproject.realmPOJO;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CommentObject implements Comparable, Cloneable {


    @SerializedName("id")
    public long id;
    @SerializedName("time")
    public long time;
    public String title;
    @SerializedName("by")
    public String by;
    @SerializedName("text")
    public String text;
    @SerializedName("type")
    public String type;


    @Override
    public int compareTo(@NonNull Object o) {
        CommentObject compare = (CommentObject) o;

        if (compare.id == this.id) {
            return 0;
        }
        return 1;
    }

    @Override
    public CommentObject clone() {

        CommentObject clone;
        try {
            clone = (CommentObject) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); //should not happen
        }

        return clone;
    }
}




