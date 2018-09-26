package com.anupamchugh.androidhackernewsproject.realmPOJO;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PostIdRealmObject extends RealmObject {


    public static final String IS_CACHED = "isCached";
    public static final String POST_ID = "postId";

    @PrimaryKey
    public long postId;
    public boolean isCached;

    public PostIdRealmObject() {
    }

}
