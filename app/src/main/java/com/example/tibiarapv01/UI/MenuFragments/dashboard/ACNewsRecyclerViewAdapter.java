package com.example.tibiarapv01.UI.MenuFragments.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.UI.MenuActivity;

import java.util.List;


public class ACNewsRecyclerViewAdapter extends RecyclerView.Adapter<ACNewsRecyclerViewAdapter.ViewHolder> {

    private  List<Achievement> mValues;
    Context CTX;
    public ACNewsRecyclerViewAdapter(List<Achievement> items, Context context) {
        mValues = items;
        CTX = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_achievement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.AC_Tittle.setText(holder.mItem.getName());
        holder.AC_type.setText(holder.mItem.getType());
        holder.AC_spoiler.setText(Html.fromHtml(holder.mItem.getSpoiler(),Html.FROM_HTML_MODE_COMPACT));
        holder.AC_points.setText(holder.mItem.getPoints().toString() + " PTS" );

        if (holder.mItem.getChecked()){
            holder.AC_marc.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else {
            holder.AC_marc.setImageResource(R.drawable.ic_star_border_black_24dp);
        }


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView AC_Tittle;
        public final TextView AC_type;
        public final TextView AC_points;
        public final TextView AC_spoiler;
        public final ImageView AC_marc;
        public Achievement mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            AC_Tittle = view.findViewById(R.id.ach_tittle);
            AC_type   = view.findViewById(R.id.ach_type);
            AC_points = view.findViewById(R.id.ach_points);
            AC_spoiler = view.findViewById(R.id.ach_spoiler);
            AC_marc = view.findViewById(R.id.ac_star);

            AC_marc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Response code:", "===========" + "image view"  );
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + AC_points.getText() + "'";
        }
    }



}
