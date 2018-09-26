package com.anupamchugh.androidhackernewsproject.realmPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Posts extends RealmObject implements Comparable, Cloneable {

    public static final String TIMESTAMP = "timeStamp";


    @PrimaryKey
    public long id;
    public long timeStamp;
    public String title;
    public String author;
    public String url;
    public int score;
    public RealmList<CommentIdObject> commentIdObjectRealmList = new RealmList<>();


    public Posts() {
    }

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




