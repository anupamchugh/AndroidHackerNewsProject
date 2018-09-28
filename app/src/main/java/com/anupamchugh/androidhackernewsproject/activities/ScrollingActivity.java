package com.anupamchugh.androidhackernewsproject.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.anupamchugh.androidhackernewsproject.APIClient;
import com.anupamchugh.androidhackernewsproject.APIInterface;
import com.anupamchugh.androidhackernewsproject.R;
import com.anupamchugh.androidhackernewsproject.ViewPagerAdapter;
import com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class ScrollingActivity extends AppCompatActivity {

    Posts mPosts;
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        initViews();


        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build());
        final long id = getIntent().getLongExtra("postId", 0);
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    mPosts = realm.where(Posts.class).equalTo("id", id).findFirst();
                    Log.d("API123", mPosts.commentIdObjectRealmList.size() + " ");
                    Log.d("API123", mPosts.url + " ");
                    toolbar.setTitle(mPosts.title);
                    if (!TextUtils.isEmpty(mPosts.url))
                        textView.setText(mPosts.url + "\n By " + mPosts.author);
                    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mPosts);
                    viewPager.setAdapter(viewPagerAdapter);
                    tabLayout.setupWithViewPager(viewPager);


                }
            });
        } catch (Exception e) {
        }

    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        textView = findViewById(R.id.subTitle);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
