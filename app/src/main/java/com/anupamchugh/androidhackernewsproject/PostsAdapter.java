package com.anupamchugh.androidhackernewsproject;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import java.util.List;

import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class PostsAdapter extends RealmRecyclerViewAdapter<Posts, PostsAdapter.PostViewHolder> {

    RealmResults<Posts> mBooks;


    public PostsAdapter(RealmResults<Posts> books) {
        super(books, true);
        mBooks = books;
    }

    // create new views (invoked by the layout manager)
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate a new card view
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_rows, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {
        // get the article
        final Posts post = getItem(position);
        if (post != null) {
            holder.bind(post);
        }
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle;
        TextView textLink;
        TextView textTime;
        TextView textComments;
        TextView txtScore;


        public PostViewHolder(View itemView) {
            // standard view holder pattern with ButterKnife view injection
            super(itemView);

            textTitle = itemView.findViewById(R.id.txtTitle);
            textLink = itemView.findViewById(R.id.txtLink);
            textTime = itemView.findViewById(R.id.txtTime);
            textComments = itemView.findViewById(R.id.txtComments);
            txtScore = itemView.findViewById(R.id.txtScore);

        }

        public void bind(final Posts post) {
            final long id = post.id;

            Log.d("API123", post.title + " " + post.commentIdObjectRealmList.size());

            textTitle.setText(post.title);
            textLink.setText(post.url);
            textTime.setText(String.valueOf(post.timeStamp));
            textComments.setText(String.valueOf(post.commentIdObjectRealmList.size()));
            txtScore.setText(String.valueOf(post.score));
        }
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public RealmResults<Posts> getData() {
        return mBooks;
    }

    public void setData(RealmResults<Posts> newData) {

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtilCallBack(newData, mBooks));
        mBooks = newData;
        diffResult.dispatchUpdatesTo(this);
    }
}

