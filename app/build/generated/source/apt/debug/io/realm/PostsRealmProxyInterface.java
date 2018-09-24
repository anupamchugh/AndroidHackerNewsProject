package io.realm;


public interface PostsRealmProxyInterface {
    public String realmGet$title();
    public void realmSet$title(String value);
    public String realmGet$link();
    public void realmSet$link(String value);
    public String realmGet$timeStamp();
    public void realmSet$timeStamp(String value);
    public String realmGet$votes();
    public void realmSet$votes(String value);
    public String realmGet$comments();
    public void realmSet$comments(String value);
    public long realmGet$id();
    public void realmSet$id(long value);
}
