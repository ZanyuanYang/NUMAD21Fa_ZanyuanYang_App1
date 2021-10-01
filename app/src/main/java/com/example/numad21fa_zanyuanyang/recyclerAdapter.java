package com.example.numad21fa_zanyuanyang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{

    private ArrayList<LinkList> linkList;
    private OnLinkListener mOnLinkListener;

    public recyclerAdapter(ArrayList<LinkList> linkList, OnLinkListener onLinkListener){
        this.linkList = linkList;
        this.mOnLinkListener = onLinkListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameText;
        private TextView urlText;
        OnLinkListener onLinkListener;

        public MyViewHolder(final View view, OnLinkListener onLinkListener){
            super(view);
            nameText = view.findViewById(R.id.name);
            urlText = view.findViewById(R.id.url);
            this.onLinkListener = onLinkListener;

//            itemView.setOnClickListener(this);
            urlText.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onLinkListener.onLinkClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_collector_list, parent, false);
        return new MyViewHolder(itemView, mOnLinkListener);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = linkList.get(position).getName();
        String url = linkList.get(position).getUrl();
        holder.nameText.setText(name);
        holder.urlText.setText(url);
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }


    public String getItemUrl(int position){
        return linkList.get(position).getUrl();
    }

    public interface OnLinkListener{
        void onLinkClick(int position);
    }

}
