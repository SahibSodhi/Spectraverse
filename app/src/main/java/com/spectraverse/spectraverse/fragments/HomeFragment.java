package com.spectraverse.spectraverse.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spectraverse.spectraverse.R;
import com.spectraverse.spectraverse.Adapters.ExampleAdapter;
import com.spectraverse.spectraverse.activities.ExampleItem;
import com.spectraverse.spectraverse.activities.MainActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> exampleList;
    private FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Types of Different Abilities");
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.visually_impaired, "Visually Impaired"));
        exampleList.add(new ExampleItem(R.drawable.hearing_speech_impaired, "Hearing and Speech Impaired"));
        exampleList.add(new ExampleItem(R.drawable.physical_disability, "Physical Disability"));
        exampleList.add(new ExampleItem(R.drawable.mental_disability, "Mental Disability"));

        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                exampleList.get(position);
                fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new LearningFragment()).commit();

            }
        });
        return rootView;
    }

}

