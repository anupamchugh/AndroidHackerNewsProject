package com.anupamchugh.androidhackernewsproject;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Posts extends RealmObject implements Comparable, Cloneable {

    String link, votes, comments;

    @SerializedName("id")
    @PrimaryKey
    long id;

    @SerializedName("time")
    long timeStamp;

    @SerializedName("title")
    String title;

    @SerializedName("by")
    String author;

    @SerializedName("url")
    String url;

    @SerializedName("score")
    int score;

    @SerializedName("kids")
    RealmList<CommentIdObject> commentIdObjectRealmList;


    @Override
    public int compareTo(Object o) {
        Posts compare = (Posts) o;

        if (compare.id == this.id) {
            return 0;
        }
        return 1;
    }

    @Override
    public Posts clone() {

        Posts clone;
        try {
            clone = (Posts) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); //should not happen
        }

        return clone;
    }

}




