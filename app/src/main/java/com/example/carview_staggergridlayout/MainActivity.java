package com.example.carview_staggergridlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;

    private RecyclerView mREcyclerView;

    private RecyclerView.Adapter mAdapter;
    private REcyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        String[] colors = {
                "Red", "Green", "Blue", "Yellow", "Magenta", "Cyan", "Orange"
                "Aqua", "Azure","Beige", "Bisque", "Brown", "Coral", "Crimson"
        };

        mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mREcyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ColorAdapter(mContext, colors);

        mRecyclerView.setAdapter(mAdapter);
    }
}
