package com.anupamchugh.androidhackernewsproject;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anupamchugh.androidhackernewsproject.realmPOJO.CommentObject;
import com.anupamchugh.androidhackernewsproject.realmPOJO.Posts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.RealmResults;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    List<CommentObject> commentObjects;

    public CommentsAdapter(List<CommentObject> commentObjectList) {
        this.commentObjects = commentObjectList;
        Log.d("API123", "adapter " + commentObjectList.size());
    }

    // create new views (invoked by the layout manager)
    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate a new card view
        return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_comments, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, final int position) {
        holder.bind(commentObjects.get(position));

    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView textCommentDesc;
        TextView txtDate;


        public CommentViewHolder(View itemView) {
            // standard view holder pattern with ButterKnife view injection
            super(itemView);
            textCommentDesc = itemView.findViewById(R.id.txtCommentDescription);
            txtDate = itemView.findViewById(R.id.txtDateComment);
        }

        public void bind(final CommentObject object) {
            Log.d("API123", object.text);
            textCommentDesc.setText(Html.fromHtml(object.text));
            String date = getDate(object.time);
            txtDate.setText(date+" - " +object.by);
        }

        private String getDate(long timeStamp){

            try{
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date netDate = (new Date(timeStamp*1000L));
                return sdf.format(netDate);
            }
            catch(Exception ex){
                return "xx";
            }
        }

    }




    @Override
    public int getItemCount() {
        return commentObjects.size();
    }

    public List<CommentObject> getData() {
        return commentObjects;
    }

    public void setData(List<CommentObject> newData) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CommentDiffUtilCallBack(newData, commentObjects));
        commentObjects.addAll(newData);

        diffResult.dispatchUpdatesTo(this);
    }


}

