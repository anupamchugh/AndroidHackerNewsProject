package com.anupamchugh.androidhackernewsproject;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class PostsAdapter extends RealmRecyclerViewAdapter<Posts, PostsAdapter.BookViewHolder> {

    RealmResults<Posts> mBooks;


    public PostsAdapter(RealmResults<Posts> books) {
        super(books, true);
        mBooks = books;
    }

    // create new views (invoked by the layout manager)
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate a new card view
        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_rows, parent, false));
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        // get the article
        final Posts book = getItem(position);
        if (book != null) {
            holder.bind(book);
        }
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle;
        TextView textLink;
        TextView textTime;
        TextView textComments;
        TextView textVotes;


        public BookViewHolder(View itemView) {
            // standard view holder pattern with ButterKnife view injection
            super(itemView);

            textTitle = itemView.findViewById(R.id.txtTitle);
            textLink = itemView.findViewById(R.id.txtLink);
            textTime = itemView.findViewById(R.id.txtTime);
            textComments = itemView.findViewById(R.id.txtComments);
            textVotes = itemView.findViewById(R.id.txtVotes);

        }

        public void bind(final Posts book) {
            final long id = book.id;

            textTitle.setText(book.title);
            textLink.setText(book.link);
            textTime.setText(book.timeStamp);
            textComments.setText(book.comments);
            textVotes.setText(book.votes);
        }
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }
}

