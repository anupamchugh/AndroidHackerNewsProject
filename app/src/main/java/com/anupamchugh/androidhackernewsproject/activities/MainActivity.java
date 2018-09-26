package com.anupamchugh.androidhackernewsproject.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.Toast;

import com.anupamchugh.androidhackernewsproject.APIClient;
import com.anupamchugh.androidhackernewsproject.APIInterface;
import com.anupamchugh.androidhackernewsproject.PostsAdapter;
import com.anupamchugh.androidhackernewsproject.R;
import com.anupamchugh.androidhackernewsproject.SharedPrefManager;
import com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PostsAdapter.ClickAdapterListener {


    RecyclerView mRecyclerView;
    Realm mRealm;
    PostsAdapter mAdapter;
    RealmResults<Posts> users;
    SwipeRefreshLayout mSwipeRefreshLayout;
    APIInterface apiInterface;
    List<PostIdRealmObject> oldPostIdList;
    RealmResults<PostIdRealmObject> postIdRealmObjectRealmResults;
    Toolbar toolbar;
    long timeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build());

        mRealm = Realm.getDefaultInstance();

        initViews();
        updateTimeStamp();


        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                updateTimeStamp();
                handler.postDelayed(this, 60000);
            }
        };
        handler.postDelayed(r, 60000);


        users = mRealm.where(Posts.class).findAllSorted(Posts.TIMESTAMP, Sort.DESCENDING);
        mAdapter = new PostsAdapter(users, this);
        mRecyclerView.setAdapter(mAdapter);
        fetchAllIdsFromRetrofit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRealm != null && !mRealm.isClosed()) {
            mRealm.close();
        }
    }

    private void gotoLogin() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Top Stories");
        toolbar.setTitleTextColor(Color.WHITE);
        //toolbar.setSubtitle("Updated 0 minutes ago");


        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchAllIdsFromRetrofit();
            }
        });

    }

    public void storeIdInRealm(final PostIdRealmObject postIdRealmObject) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(postIdRealmObject);
                }
            });
        } catch (Exception e) {
            Log.d("API123", e.toString());
        }
    }

    public List<Long> getAllPostIdInRealm() {

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmResults<PostIdRealmObject> postIdRealmObjects = realm.where(PostIdRealmObject.class).findAll();
                    oldPostIdList = realm.copyFromRealm(postIdRealmObjects);


                }
            });
        } catch (Exception e) {
        }

        List<Long> longList = new ArrayList<>();
        for (PostIdRealmObject p : oldPostIdList) {
            longList.add(p.postId);
        }

        return longList;
    }


    public void fetchPostsFromRealm() {


        try (Realm realm = Realm.getDefaultInstance()) {
            postIdRealmObjectRealmResults = realm.where(PostIdRealmObject.class).equalTo(PostIdRealmObject.IS_CACHED, false).findAll();
        }

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {


                    for (PostIdRealmObject postIdRealmObject : postIdRealmObjectRealmResults) {
                        retrieveNonCachedPosts(postIdRealmObject);
                    }


                }
            });
        } catch (Exception e) {
        }

        updateRecyclerViewFromRealm();
    }

    public void updateRecyclerViewFromRealm() {

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                users = realm.where(Posts.class).findAll();
                mAdapter.setData(users);
                mRecyclerView.scrollToPosition(0);
            }
        });
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void insertPostInRealm(final Posts post, final PostIdRealmObject postIdRealmObject) {

        boolean isCached = true;


        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insertOrUpdate(post);

                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "insertPostRealm failed", Toast.LENGTH_SHORT).show();
            isCached = false;

        }

        if (isCached) {
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        PostIdRealmObject fetched = realm.where(PostIdRealmObject.class).equalTo(PostIdRealmObject.POST_ID, postIdRealmObject.postId).findFirst();
                        fetched.isCached = true;
                        realm.copyToRealmOrUpdate(fetched);

                    }
                });
            }

        }
    }

    public void fetchAllIdsFromRetrofit() {
        Call<List<Long>> listCall = apiInterface.getAllPostId();
        listCall.enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                List<Long> integers = response.body();

                List<Long> oldPostIdRealmObjectList = getAllPostIdInRealm();

                boolean allCached = true;
                if (integers != null) {
                    for (Long i : integers) {

                        if (!oldPostIdRealmObjectList.contains(i)) {
                            PostIdRealmObject postIdRealmObject = new PostIdRealmObject();
                            postIdRealmObject.postId = i;
                            allCached = false;
                            storeIdInRealm(postIdRealmObject);
                        }
                    }
                    if (!allCached)
                        fetchPostsFromRealm();
                    else
                        mSwipeRefreshLayout.setRefreshing(false);

                }
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                call.cancel();
            }
        });

        resetTimeStamp();
    }

    public void retrieveNonCachedPosts(final PostIdRealmObject postIdRealmObject) {
        Call<ResponseBody> postsCall = apiInterface.getPost(postIdRealmObject.postId);
        postsCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    Posts posts = new Posts();
                    posts.id = jsonObject.getLong("id");
                    posts.author = jsonObject.getString("by");
                    posts.timeStamp = jsonObject.getLong("time");
                    posts.title = jsonObject.getString("title");
                    posts.url = jsonObject.optString("url", "");
                    posts.score = jsonObject.getInt("score");
                    JSONArray jsonArray = jsonObject.optJSONArray("kids");

                    if (jsonArray == null)
                        jsonArray = new JSONArray();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        CommentIdObject commentIdObject = new CommentIdObject();
                        commentIdObject.commentId = jsonArray.getLong(i);
                        posts.commentIdObjectRealmList.add(commentIdObject);
                    }

                    insertPostInRealm(posts, postIdRealmObject);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.cancel();
            }
        });

    }

    private void updateTimeStamp() {
        SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        timeStamp = sharedPrefManager.getTimeStamp();
        if (timeStamp == 0)
            timeStamp = Calendar.getInstance().getTimeInMillis();
        Date date = new Date(timeStamp);
        String niceDateStr = DateUtils.getRelativeTimeSpanString(date.getTime(), Calendar.getInstance().getTimeInMillis(), DateUtils.MINUTE_IN_MILLIS).toString();
        toolbar.setSubtitle("Updated " + niceDateStr);
    }

    private void resetTimeStamp() {
        timeStamp = Calendar.getInstance().getTimeInMillis();
        SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        sharedPrefManager.saveTimeStamp(timeStamp);
        updateTimeStamp();
    }


    @Override
    public void onRowClicked(Posts post) {
        gotoCommentActivity();
    }

    public void gotoCommentActivity() {
        Log.d("API123", "gotoComment");
        startActivity(new Intent(this, ScrollingActivity.class));
    }
}
