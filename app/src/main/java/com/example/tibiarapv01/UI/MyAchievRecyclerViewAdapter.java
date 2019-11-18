package com.example.tibiarapv01.UI;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.UI.AchieveFragment.OnListFragmentInteractionListener;
import com.example.tibiarapv01.UI.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAchievRecyclerViewAdapter extends RecyclerView.Adapter<MyAchievRecyclerViewAdapter.ViewHolder> {

    private final List<Achievement> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyAchievRecyclerViewAdapter(List<Achievement> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_achievment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
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
            mIdView =  view.findViewById(R.id.Achv_name );
            mContentView =  view.findViewById(R.id.Achv_spoiler);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
