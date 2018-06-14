package com.aniketvishal.conversationimproviser;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.aniketvishal.conversationimproviser.Adapters.MainCategoryAdapter;
import com.aniketvishal.conversationimproviser.Database.DatabaseHelper;
import com.aniketvishal.conversationimproviser.Models.MainCategoryModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatternsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private DatabaseHelper mDatabaseHelper;

    public PatternsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patterns, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String fragment = getClass().getSimpleName();

        mDatabaseHelper = new DatabaseHelper(getContext());

        mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.pattern_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new MainCategoryAdapter(mDatabaseHelper.getCategorieList("patterns"),getContext(), fragment);

        ScaleInAnimationAdapter alphaAdapter = new ScaleInAnimationAdapter(mAdapter);
        alphaAdapter.setDuration(1000);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        alphaAdapter.setFirstOnly(false);

        mRecyclerView.setAdapter(alphaAdapter);

    }
}
