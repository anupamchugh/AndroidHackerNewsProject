package com.anupamchugh.androidhackernewsproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Realm mRealm;
    RecyclerView mRecyclerView;
    FloatingActionButton fab;
    PostsAdapter mAdapter;
    RealmResults<Posts> users;
    SwipeRefreshLayout mSwipeRefreshLayout;
    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
        apiInterface = APIClient.getClient().create(APIInterface.class);
        mRealm = Realm.getDefaultInstance();
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build());


        //loadDummyData();

        Call<List<Integer>> integerList = apiInterface.doGetPostId();
        integerList.enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                Log.d("API123", response.body() + " ");


            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {

            }
        });

        initViews();
        users = mRealm.where(Posts.class).findAll();
        mAdapter = new PostsAdapter(users);
        Log.d("API123", " " + users.size());
        mRecyclerView.setAdapter(mAdapter);

        users.addChangeListener(new RealmChangeListener<RealmResults<Posts>>() {
            @Override
            public void onChange(RealmResults<Posts> posts) {
                Log.d("API123", "onChanged " + posts.size());
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Posts post = new Posts();

                post.id = new Random().nextLong();
                post.title = ("Anupam Chugh");
                post.comments = "0";
                post.votes = "0";
                post.link = "anupamchugh.com";
                post.timeStamp = 12343545;

                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insertOrUpdate(post);
                    }
                });


                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        users = realm.where(Posts.class).findAll();
                        mAdapter.setData(users);
                        mRecyclerView.scrollToPosition(0);
                    }
                });


            }
        });

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

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Top Stories");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitle("Updated 0 minutes ago");
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        mSwipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void loadDummyData() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Posts post = new Posts();

                post.id = 1;
                post.title = ("Reto Meier");
                post.comments = "20";
                post.votes = "50";
                post.link = "google.com";
                post.timeStamp = 12343545;
                realm.insertOrUpdate(post);

                post.id = 2;
                post.title = ("Hello how are you doing?");
                post.comments = "200";
                post.votes = "0";
                post.link = "asasasas.com";
                post.timeStamp = 12343545;
                realm.insertOrUpdate(post);
            }
        });
    }
}
