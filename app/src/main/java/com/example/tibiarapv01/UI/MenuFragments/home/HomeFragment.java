package com.example.tibiarapv01.UI.MenuFragments.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.News;
import com.example.tibiarapv01.Retrofit.TibiaClient;
import com.example.tibiarapv01.Retrofit.TibiaService;
import com.example.tibiarapv01.UI.MenuFragments.notifications.NotificationsViewModel;
import com.example.tibiarapv01.UI.MyNewsRecyclerViewAdapter;
import com.example.tibiarapv01.UI.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private int mColumnCount = 1;
    private static final String ARG_COLUMN_COUNT = "column-count";
    RecyclerView recyclerView;
    List<News> news = new ArrayList<>();
    TibiaService tibiaService;
    TibiaClient tibiaClient;
    public HomeFragment() {

    }
    @SuppressWarnings("unused")
    public static NewsFragment newInstance(int columnCount) {
        NewsFragment fragment = new NewsFragment();
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


    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        if (root instanceof RecyclerView) {
            final Context context = root.getContext();
            recyclerView = (RecyclerView) root;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            retEnit();
            Call<List<News>> call = tibiaService.getNews();
            call.enqueue(new Callback<List<News>>() {
                @Override
                public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                    if (response.isSuccessful())
                    {
                        news = response.body();
                        recyclerView.setAdapter(new TBNewsRecyclerViewAdapter(news, context));

                    }
                }

                @Override
                public void onFailure(Call<List<News>> call, Throwable t) {

                }
            });


        }
        return root;
    }



    public void retEnit()
    {
        tibiaClient = TibiaClient.getInstance();
        tibiaService = tibiaClient.getService();
    }


}