package com.anupamchugh.androidhackernewsproject;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class PostsAdapter extends RealmRecyclerViewAdapter<Posts, PostsAdapter.PostViewHolder> {

    RealmResults<Posts> mBooks;
    ClickAdapterListener listener;

    public PostsAdapter(RealmResults<Posts> books, ClickAdapterListener listener) {
        super(books, true);
        mBooks = books;
        this.listener = listener;
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
        applyClickEvents(holder, post);
        if (post != null) {
            holder.bind(post);
        }
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);


    }

    private void applyClickEvents(PostViewHolder holder, final Posts model) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRowClicked(model);
            }
        });
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle;
        TextView textLink;
        TextView textTime;
        TextView textComments;
        TextView txtScore;
        CardView cardView;


        public PostViewHolder(View itemView) {
            // standard view holder pattern with ButterKnife view injection
            super(itemView);

            textTitle = itemView.findViewById(R.id.txtTitle);
            textLink = itemView.findViewById(R.id.txtLink);
            textTime = itemView.findViewById(R.id.txtTime);
            textComments = itemView.findViewById(R.id.txtComments);
            txtScore = itemView.findViewById(R.id.txtScore);
            cardView = itemView.findViewById(R.id.cardView);


        }

        public void bind(final Posts post) {
            final long id = post.id;


            textTitle.setText(post.title);
            textLink.setText(post.url);
            Date date = new Date((long) post.timeStamp * 1000);
            String niceDateStr = DateUtils.getRelativeTimeSpanString(date.getTime(), Calendar.getInstance().getTimeInMillis(), DateUtils.MINUTE_IN_MILLIS).toString();
            textTime.setText(niceDateStr + " - " + post.author);
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


    public interface ClickAdapterListener {

        void onRowClicked(Posts post);
    }

}

