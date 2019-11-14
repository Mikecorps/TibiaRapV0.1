package com.example.tibiarapv01.UI;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.Achievements;




public class MyAchievementRecyclerViewAdapter extends RecyclerView.Adapter<MyAchievementRecyclerViewAdapter.ViewHolder> {
    private Context ctx;
    private final Achievements mValues;


    public MyAchievementRecyclerViewAdapter(Context context, Achievements achievements) {
        mValues = achievements;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_achievement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.getData().get(position);

        holder.achiv_tittle.setText(holder.mItem.getName());
        holder.achiv_spoiler.setText(holder.mItem.getSpoiler());

    }

    @Override
    public int getItemCount() {
        return mValues.getData().size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView achiv_tittle;
        public final TextView achiv_spoiler;
        public Achievement mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            achiv_tittle = (TextView) view.findViewById(R.id.Achiv_tittle);
            achiv_spoiler = (TextView) view.findViewById(R.id.Achiv_spoiler);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + achiv_tittle.getText() + "'";
        }
    }
}
