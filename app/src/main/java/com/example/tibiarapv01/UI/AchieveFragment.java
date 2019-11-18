package com.example.tibiarapv01.UI;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tibiarapv01.R;
import com.example.tibiarapv01.Response.Achievement;
import com.example.tibiarapv01.Response.Achievements;
import com.example.tibiarapv01.Retrofit.TibiaAuthClient;
import com.example.tibiarapv01.Retrofit.TibiaAuthService;
import com.example.tibiarapv01.UI.dummy.DummyContent;
import com.example.tibiarapv01.UI.dummy.DummyContent.DummyItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class AchieveFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    Achievements achievements;

    TibiaAuthService tibiaService;
    TibiaAuthClient tibiaClient;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AchieveFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AchieveFragment newInstance(int columnCount) {
        AchieveFragment fragment = new AchieveFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_achievment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            RefitInit();
            Call<Achievements> call = tibiaService.getAllAchievements();
            call.enqueue(new Callback<Achievements>() {
                @Override
                public void onResponse(Call<Achievements> call, Response<Achievements> response) {
                    if (response.isSuccessful()){
                        achievements = new Achievements(response.body().getData());
                    }
                }

                @Override
                public void onFailure(Call<Achievements> call, Throwable t) {

                }
            });

            recyclerView.setAdapter(new MyAchievRecyclerViewAdapter(achievements.getData() , mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Achievement item);
    }

    private void RefitInit() {
        tibiaClient = TibiaAuthClient.getInstance();
        tibiaService = tibiaClient.getAuthService();
    }


}
