package com.example.cphillips.apptwo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> stringz;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        stringz = new ArrayList<String>();
        for(int i = 0; i < 10; i++){
            stringz.add(String.valueOf(i));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents(){
        RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new RyAdapter(stringz);
        mRecyclerView.setAdapter(mAdapter);
    }



}
