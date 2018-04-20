package com.geriadam.myrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geriadam.myrecyclerview.R;
import com.geriadam.myrecyclerview.model.President;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {
    private Context context;

    public ArrayList<President> getListPresident(){
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident){
        this.listPresident = listPresident;
    }

    private ArrayList<President> listPresident;

    public ListPresidentAdapter(Context context){
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position){
        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        Glide.with(context).load(getListPresident().get(position).getPhoto()).override(55,55).crossFade().into(holder.tvPhoto);
    }

    @Override
    public int getItemCount(){
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView tvPhoto;

        public CategoryViewHolder(View view){
            super(view);
            tvName = (TextView)itemView.findViewById(R.id.item_name);
            tvPhoto = (ImageView)itemView.findViewById(R.id.item_photo);
            tvRemarks = (TextView)itemView.findViewById(R.id.item_remaks);
        }
    }
}
