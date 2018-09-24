package com.anupamchugh.androidhackernewsproject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Posts extends RealmObject {

    String title, link, timeStamp, votes, comments;
    @PrimaryKey
    long id;
}
