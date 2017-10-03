package com.toggle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RvAdapter mAdapter;
    private Button btnToggle;
    private List<Data> mDataList = new ArrayList<>();
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataList.add(new Data("first", R.drawable.kotlin));
        mDataList.add(new Data("second", R.drawable.kotlin));
        mDataList.add(new Data("third", R.drawable.kotlin));
        mDataList.add(new Data("forth", R.drawable.kotlin));
        mAdapter = new RvAdapter(mContext, mDataList);
        rvData = (RecyclerView) findViewById(R.id.rvData);
        btnToggle = (Button) findViewById(R.id.btnToggle);
        //by default AppConstants.isList = true
        rvData.setLayoutManager(AppConstants.isList ? new LinearLayoutManager(mContext) : new GridLayoutManager(mContext, 2));
        rvData.setAdapter(mAdapter);
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppConstants.isList = !AppConstants.isList;
                Log.d("TOGGLE", "onClick mainactivity: "+AppConstants.isList);
                rvData.setLayoutManager(AppConstants.isList ? new LinearLayoutManager(mContext) : new GridLayoutManager(mContext, 2));
                rvData.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
