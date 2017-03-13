package com.carl.co.topnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carl.co.topnews.R;

import java.util.List;

/**
 * Created by Host-0 on 2017/3/13.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {
    private List<String> mList = null;
    private Context mContext;
    private OnItemClickListener onItemClickListener;
    public ItemRecyclerViewAdapter(Context context, List<String> list){
        mList = list;
        mContext = context;
    }

    @Override
    public ItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemRecyclerViewAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_tabcolumn,parent,false));
    }

    @Override
    public void onBindViewHolder(final ItemRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
//        if(position == 0)
//            holder.textView.setSelected(true);
        if(onItemClickListener!=null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.item_text);
        }
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }
}
