package com.example.tibiarapv01.UI.MenuFragments.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.UI.MenuFragments.home.TBNewsRecyclerViewAdapter;
import com.example.tibiarapv01.UI.NewsFragment;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private int mColumnCount = 1;
    private static final String ARG_COLUMN_COUNT = "column-count";
    RecyclerView recyclerView;
    List<Achievement> Ac_list = new ArrayList<>();


    public DashboardFragment(){

    }

    @SuppressWarnings("unused")
    public static DashboardFragment newInstance(int columnCount) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        if (root instanceof RecyclerView) {
            final Context context = root.getContext();
            recyclerView = (RecyclerView) root;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            dashboardViewModel.getAchievements().observe(this, new Observer<List<Achievement>>() {
                @Override
                public void onChanged(List<Achievement> achievements) {
                    Ac_list = achievements;
                    recyclerView.setAdapter(new ACNewsRecyclerViewAdapter(Ac_list, context));
                }
            });


        }
        return root;
    }
}