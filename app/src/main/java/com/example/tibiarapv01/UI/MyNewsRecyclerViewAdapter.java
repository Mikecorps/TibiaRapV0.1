package com.example.tibiarapv01.UI;

import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.UI.NewsFragment.OnListFragmentInteractionListener;


import java.util.List;


public class MyNewsRecyclerViewAdapter extends RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ViewHolder> {

    private  List<News> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyNewsRecyclerViewAdapter(List<News> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.newsTittle.setText(holder.mItem.getTitle());
        holder.newsContent.setText(Html.fromHtml(holder.mItem.getContent(),Html.FROM_HTML_MODE_COMPACT));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView newsTittle;
        public final TextView newsContent;
        public News mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            newsTittle = view.findViewById(R.id.textNews_tittle);
            newsContent = view.findViewById(R.id.textNews_content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + newsContent.getText() + "'";
        }
    }
}
