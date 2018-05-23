package com.simoncherry.artest.ui.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.simoncherry.artest.R;

import java.util.ArrayList;

/**
 * Created by SeanMa on 2018/5/23.
 */
public class ShowItemAdapter extends RecyclerView.Adapter {


    ArrayList<Integer> mData;
    Context mContext;
    public ShowItemAdapter(Context context, ArrayList<Integer> data){
        mContext = context;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_show, parent,
                false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mItemIview = (ImageView) view.findViewById(R.id.iv_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).mItemIview.setImageResource(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView mItemIview;
    }
}
