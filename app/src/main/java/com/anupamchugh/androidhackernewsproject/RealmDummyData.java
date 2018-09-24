package com.anupamchugh.androidhackernewsproject;

import io.realm.Realm;

public class RealmDummyData implements Realm.Transaction {
    @Override
    public void execute(Realm realm) {
        Posts book = new Posts();

        book.id = 1;
        book.title = ("Reto Meier");
        book.comments = "20";
        book.votes = "50";
        book.link = "google.com";
        book.timeStamp = "4th June 2012";
        realm.insertOrUpdate(book);

        book.id = 2;
        book.title = ("Hello how are you doing?");
        book.comments = "200";
        book.votes = "0";
        book.link = "asasasas.com";
        book.timeStamp = "12 July 2012";
        realm.insertOrUpdate(book);

    }

    @Override
    public int hashCode() {
        return RealmDummyData.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof RealmDummyData;
    }
}
