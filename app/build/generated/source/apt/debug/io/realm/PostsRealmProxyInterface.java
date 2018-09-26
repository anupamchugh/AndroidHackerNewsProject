package io.realm;


public interface PostsRealmProxyInterface {
    public long realmGet$id();
    public void realmSet$id(long value);
    public long realmGet$timeStamp();
    public void realmSet$timeStamp(long value);
    public String realmGet$title();
    public void realmSet$title(String value);
    public String realmGet$author();
    public void realmSet$author(String value);
    public String realmGet$url();
    public void realmSet$url(String value);
    public int realmGet$score();
    public void realmSet$score(int value);
    public RealmList<com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject> realmGet$commentIdObjectRealmList();
    public void realmSet$commentIdObjectRealmList(RealmList<com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject> value);
}
