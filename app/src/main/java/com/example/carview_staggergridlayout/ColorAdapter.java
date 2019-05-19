package com.example.carview_staggergridlayout;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    private String[] mDataSet;
    private Context mContext;
    private Random mRandom = new Random();

    public ColorAdapter(Context context, String[] DataSet){
        mDataSet = DataSet;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v){
            super(v);
            mTextView = (TextView)v.findViewById(R.id.tv);
        }
    }

    public ColorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataSet[position]);

        holder.mTextView.getLayoutParams().height = getRandomIntInRange(250,75);

        holder.mTextView.setBackgroundColor(getRandomHSVColor());
    }

    public int getItemCount(){
        return mDataSet.length;
    }

    protected int getRandomIntInRange(int max, int min) {
        return mRandom.nextInt((max-min)+min) + min;
    }

    protected int getRandomHSVColor(){
        int hue = mRandom.nextInt(361);
        float saturation = 1.0f;
        float value = 1.0f;
        int alph = 255;
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});

        return color;
    }
}
