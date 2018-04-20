package com.geriadam.myrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.geriadam.myrecyclerview.R;
import com.geriadam.myrecyclerview.model.President;

import java.util.ArrayList;

public class CardviewPresidentAdapter extends RecyclerView.Adapter<CardviewPresidentAdapter.CardViewHolder> {
    private ArrayList<President>listPresident;
    private Context context;

    public CardviewPresidentAdapter(Context context){
        this.context = context;
    }

    public ArrayList<President> getListPresident(){
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident){
        this.listPresident = listPresident;
    }

    @Override
    public CardViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder (CardViewHolder holder, int position){
        President p = getListPresident().get(position);
        Glide.with(context).load(p.getPhoto()).override(350,550).into(holder.tvPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public int getItemCount(){
        return getListPresident().size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;
        ImageView tvPhoto;

        public CardViewHolder(View view){
            super(view);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}
