package com.anupamchugh.androidhackernewsproject;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;

public class PostDiffUtilCallBack extends DiffUtil.Callback {
    RealmResults<Posts> newList;
    RealmResults<Posts> oldList;

    public PostDiffUtilCallBack(RealmResults<Posts> newList, RealmResults<Posts> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).id == (oldList.get(oldItemPosition).id);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));

        return result == 0;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
