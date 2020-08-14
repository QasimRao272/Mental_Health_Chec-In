package com.google.mentalhealthchec_in.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.mentalhealthchec_in.DatabaseHandler;
import com.google.mentalhealthchec_in.R;
import com.google.mentalhealthchec_in.RVAdapter;

public class FragmentEntries extends Fragment {
    ////////////////////////
    RecyclerView objectRecyclerview;
    DatabaseHandler objectDatabaseHandler;
    RVAdapter objectRvAdapter;
    TextView noviews;
    /////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_entries, container, false);

        ////////////////
        objectRecyclerview = view.findViewById(R.id.imageRV);
        noviews = view.findViewById(R.id.noviews);
        objectDatabaseHandler = new DatabaseHandler(getContext());
        showEmptyviews();
        ////////////////

        return view;
    }

    private void showEmptyviews() {
        if (objectDatabaseHandler.getAllImagesData().isEmpty()) {
            noviews.setVisibility(View.VISIBLE);
        } else {
            objectDatabaseHandler.getAllImagesData();
            noviews.setVisibility(View.GONE);
        }
    }

    public void getData() {
        try {
            objectRvAdapter = new RVAdapter(objectDatabaseHandler.getAllImagesData());
            objectRecyclerview.setHasFixedSize(true);
            objectRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
            objectRecyclerview.setAdapter(objectRvAdapter);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }
}