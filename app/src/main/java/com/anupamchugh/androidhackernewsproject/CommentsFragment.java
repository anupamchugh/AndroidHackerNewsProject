package com.anupamchugh.androidhackernewsproject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anupamchugh.androidhackernewsproject.realmPOJO.CommentIdObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsFragment extends Fragment {

    RecyclerView recyclerView;
    Posts mPosts;
    RealmList<CommentIdObject> realmList;
    APIInterface apiInterface;


    CommentsAdapter commentsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.comments_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        recyclerView = view.findViewById(R.id.recycler_view);
        List<CommentObject> mCommentObjectList = new ArrayList<>();
        commentsAdapter = new CommentsAdapter(mCommentObjectList);
        recyclerView.setAdapter(commentsAdapter);
        Bundle bundle = getArguments();

        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build());

        final long id = bundle.getLong("id");
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    mPosts = realm.where(Posts.class).equalTo("id", id).findFirst();
                    realmList = mPosts.commentIdObjectRealmList;

                    fetchAllComments(realmList);

                }
            });
        } catch (Exception e) {
        }


    }

    private void fetchAllComments(RealmList<CommentIdObject> mCommentIdList) {

        for (CommentIdObject commentIdObject : mCommentIdList) {
            fetchComment(commentIdObject.commentId);
        }

    }

    private void fetchComment(long commentId) {

        Call<CommentObject> call = apiInterface.getComment(commentId);
        call.enqueue(new Callback<CommentObject>() {
            @Override
            public void onResponse(Call<CommentObject> call, Response<CommentObject> response) {
                CommentObject commentObject = response.body();
                List<CommentObject> mCommentObjectList = new ArrayList<>();
                mCommentObjectList.add(commentObject);
                commentsAdapter.setData(mCommentObjectList);
            }

            @Override
            public void onFailure(Call<CommentObject> call, Throwable t) {

            }
        });
    }
}