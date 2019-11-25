package com.example.tibiarapv01.UI.MenuFragments.home;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Retrofit.TibiaAuthClient;
import com.example.tibiarapv01.UI.NewsFragment.OnListFragmentInteractionListener;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;
import java.util.List;
import java.util.Locale;


public class TBNewsRecyclerViewAdapter extends RecyclerView.Adapter<TBNewsRecyclerViewAdapter.ViewHolder> {

    private  List<News> mValues;
    Context CTX;
    public TBNewsRecyclerViewAdapter(List<News> items, Context context) {
        mValues = items;
        CTX = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.newsTittle.setText(holder.mItem.getTitle());
        holder.newsContent.setText(Html.fromHtml(holder.mItem.getContent(),Html.FROM_HTML_MODE_COMPACT));

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView newsTittle;
        public final TextView newsDate;
        public final TextView newsContent;
        public News mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            newsTittle = view.findViewById(R.id.News_tittle);
            newsContent = view.findViewById(R.id.news_content);
            newsDate  = view.findViewById(R.id.news_created);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + newsContent.getText() + "'";
        }
    }



}
