package com.example.tibiarapv01.UI;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.UI.AchievementFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MyAchievementRecyclerViewAdapter extends RecyclerView.Adapter<MyAchievementRecyclerViewAdapter.ViewHolder> {

    private final List<Achievement> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyAchievementRecyclerViewAdapter(List<Achievement> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_achievement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position)  ;
        holder.mIdView.setText(holder.mItem.getName());
        holder.mContentView.setText(holder.mItem.getSpoiler());

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
        public final TextView mIdView;
        public final TextView mContentView;
        public Achievement mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView =  view.findViewById(R.id.textView_name);
            mContentView =  view.findViewById(R.id.textViewSpoiler);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
