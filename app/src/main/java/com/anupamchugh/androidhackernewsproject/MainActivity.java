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
import android.widget.Toast;

import com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.PostIdRealmObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    Realm mRealm;
    FloatingActionButton fab;
    PostsAdapter mAdapter;
    RealmResults<Posts> users;
    SwipeRefreshLayout mSwipeRefreshLayout;
    APIInterface apiInterface;
    List<PostIdRealmObject> oldPostIdList;
    RealmResults<PostIdRealmObject> postIdRealmObjectRealmResults;

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
        users = mRealm.where(Posts.class).findAll();
        Log.d("API123", users.size() + " ");
        mAdapter = new PostsAdapter(users);
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
        startActivity(new Intent(this, LoginActivity.class));
        finish();
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

    public void storeIdInRealm(final PostIdRealmObject postIdRealmObject) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insertOrUpdate(postIdRealmObject);
                }
            });
        } catch (Exception e) {
            Log.d("API123", e.toString());
        }
    }

    public List<PostIdRealmObject> getAllPostIdInRealm() {

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmResults<PostIdRealmObject> postIdRealmObjects = realm.where(PostIdRealmObject.class).findAll();
                    oldPostIdList = realm.copyFromRealm(postIdRealmObjects);
                }
            });
        } catch (Exception e) {
            Log.d("API123", e.toString());
        }

        return oldPostIdList;
    }


    public void fetchPostsFromRealm() {
        try (Realm realm = Realm.getDefaultInstance()) {
            postIdRealmObjectRealmResults = realm.where(PostIdRealmObject.class).equalTo(PostIdRealmObject.IS_CACHED, false).findAll();
        }

        Log.d("API123", "getAllPostIdRealm");
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {


                    for (PostIdRealmObject postIdRealmObject : postIdRealmObjectRealmResults) {
                        Log.d("API1234", postIdRealmObject.postId + " " + postIdRealmObject.isCached);

                        retrieveNonCachedPosts(postIdRealmObject);
                    }


                }
            });
        } catch (Exception e) {
            Log.d("API123", "fetchPostsFromRealm exception " + e.toString());
        }

        Log.d("API123456", "BREAK................\n\n\n\n");

        updateRecyclerViewFromRealm();
    }

    public void testRealm() {
        try (Realm realm = Realm.getDefaultInstance()) {
            postIdRealmObjectRealmResults = realm.where(PostIdRealmObject.class).equalTo(PostIdRealmObject.IS_CACHED, false).findAll();
        }

        Log.d("API123", "getAllPostIdRealm");
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    for (PostIdRealmObject postIdRealmObject : postIdRealmObjectRealmResults) {
                        Log.d("API123456", postIdRealmObject.postId + " " + postIdRealmObject.isCached);
                    }
                }
            });

            Log.d("API123456", "BREAK................\n\n\n\n");
        } catch (Exception e) {
            Log.d("API123", "fetchPostsFromRealm exception " + e.toString());
        }
    }

    public void updateRecyclerViewFromRealm() {
        //try (Realm realm = Realm.getDefaultInstance()) {


        Log.d("API123","\n\n\n\nUPDATE RECYCLERVIEW FROM REALM.......\n\n\n\n\n\n");
        testRealm();

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                users = realm.where(Posts.class).findAll();
                mAdapter.setData(users);
                mRecyclerView.scrollToPosition(0);
            }
        });
        //}
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
            Log.d("API123", e.toString());

            isCached = false;

        }

        if (isCached) {
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        //postIdRealmObject.isCached = true;
                        PostIdRealmObject fetched  = realm.where(PostIdRealmObject.class).equalTo(PostIdRealmObject.POST_ID, postIdRealmObject.postId).findFirst();
                        Log.d("A123",fetched.postId+" "+" "+fetched.isCached);
                        fetched.isCached = true;
                        realm.insertOrUpdate(fetched);

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

                List<PostIdRealmObject> oldPostIdRealmObjectList = getAllPostIdInRealm();

                if (integers != null) {
                    for (Long i : integers) {

                        PostIdRealmObject postIdRealmObject = new PostIdRealmObject();
                        postIdRealmObject.postId = i;

                        if (oldPostIdRealmObjectList.contains(postIdRealmObject)) {
                            Log.d("API123", "continue");
                        } else
                            storeIdInRealm(postIdRealmObject);
                    }
                    fetchPostsFromRealm();
                }
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public void retrieveNonCachedPosts(final PostIdRealmObject postIdRealmObject) {
        Call<ResponseBody> postsCall = apiInterface.getPost(postIdRealmObject.postId);
        postsCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //Posts posts = response.body();

                //JsonObject post = new JsonObject().get(response.body().toString()).getAsJsonObject();

                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    Posts posts = new Posts();
                    posts.id = jsonObject.getLong("id");
                    posts.author = jsonObject.getString("by");
                    posts.timeStamp = jsonObject.getLong("time");
                    posts.title = jsonObject.getString("title");
                    posts.url = jsonObject.getString("url");
                    posts.score = jsonObject.getInt("score");
                    JSONArray jsonArray = jsonObject.getJSONArray("kids");

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

}
