package com.anupamchugh.androidhackernewsproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.util.Log;

import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    Posts mPosts;

    public ViewPagerAdapter(FragmentManager fm, Posts posts) {
        super(fm);
        mPosts = posts;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0) {
            fragment = new CommentsFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("id", mPosts.id);
            fragment.setArguments(bundle);
        } else if (position == 1) {
            fragment = new WebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", mPosts.url);
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        if (TextUtils.isEmpty(mPosts.url))
            return 1;
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = mPosts.commentIdObjectRealmList.size() + " COMMENTS";
        } else if (position == 1) {
            title = "ARTICLE";
        }
        return title;
    }
}

