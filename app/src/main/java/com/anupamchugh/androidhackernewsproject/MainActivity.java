package com.anupamchugh.androidhackernewsproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm mRealm;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());

        mRealm = Realm.getDefaultInstance();
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder() //
                .deleteRealmIfMigrationNeeded()
                .build());

        mRecyclerView = findViewById(R.id.recyclerView);
        RealmResults<Posts> users = mRealm.where(Posts.class).findAll();
        Log.d("API123", " " + users.size());
        mRecyclerView.setAdapter(new PostsAdapter(users));


        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Top Stories");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitle("Updated 0 minutes ago");
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

    }

    private void gotoLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRealm != null && !mRealm.isClosed())
            mRealm.close();
    }
}
