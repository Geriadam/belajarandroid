package com.geriadam.myrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geriadam.myrecyclerview.R;
import com.geriadam.myrecyclerview.model.President;

import java.util.ArrayList;

public class GridPresidentAdapter extends RecyclerView.Adapter<GridPresidentAdapter.GridViewHolder>{
    private Context context;
    private ArrayList<President> listPresident;

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident){
        this.listPresident = listPresident;
    }

    public GridPresidentAdapter(Context context){
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_president, parent, false);
        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    public void onBindViewHolder(GridViewHolder holder, int postion){
        Glide.with(context).load(getListPresident().get(postion).getPhoto()).override(350,550).into(holder.itemPhoto);
    }

    @Override
    public int getItemCount(){
        return getListPresident().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView itemPhoto;
        public GridViewHolder(View view){
            super(view);
            itemPhoto = (ImageView)view.findViewById(R.id.item_grid_photo);
        }
    }
}
