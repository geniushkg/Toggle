package com.toggle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by geniushkg on 3/10/17.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.rvHolder> {

    private static final String TAG ="TOGGLE" ;
    private Context mContext;
    private List<Data> mDataList;

    public RvAdapter(Context mContext, List<Data> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public rvHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext).inflate(AppConstants.isList ? R.layout.row_rv_list : R.layout.row_rv_grid, null);
        Log.d(TAG, "onCreateViewHolder: "+AppConstants.isList);
        return new rvHolder(rootView);
    }

    @Override
    public void onBindViewHolder(rvHolder holder, int position) {
        Data eachData = mDataList.get(position);
        holder.textView.setText(eachData.getDataText());
        Picasso.with(mContext).load(eachData.getImgId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class rvHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public rvHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivHolder);
            textView = (TextView) itemView.findViewById(R.id.tvHolder);
        }
    }
}
