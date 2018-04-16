package com.example.administrator.konlintapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.konlitapp.Test;

import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Test> list;
    private itemOnClickListener itemListener;
    interface itemOnClickListener<T>{
        void onClick(int position, T t);
    }
    public Adapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    public Adapter(Context context, List<Test> list, itemOnClickListener itemListener) {
        this.context = context;
        this.list = list;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Test t = list.get(position);
        holder.textView.setText(t.getN());
        if(itemListener != null){
            holder.textView.setOnClickListener(v -> itemListener.onClick(position, t));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemListener(itemOnClickListener<Test> itemListener) {
        this.itemListener = itemListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ViewHolder(View v){
            super(v);
            textView = v.findViewById(R.id.item_content);
        }
    }
}
