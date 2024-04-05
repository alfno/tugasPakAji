package com.example.tugaspakaji;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterBangun extends RecyclerView.Adapter<AdapterBangun.ViewHolder> {

    List<modelBangun>listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public AdapterBangun(List<modelBangun> listData, Context context){
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterBangun.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_bangun, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBangun.ViewHolder holder, int position) {
        modelBangun modelBangun = listData.get(position);
        holder.tvname.setText(modelBangun.getNamaBangun());
        holder.tvDesc.setText(modelBangun.getDesc());
        Glide.with(holder.itemView.getContext()).load(modelBangun.getImageBangun()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvname;
        TextView tvDesc;
        ImageView imageView;
        public ViewHolder(View itemview) {
            super(itemview);
            tvname = itemView.findViewById(R.id.tvname);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null ) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    public modelBangun getItem(int id) {
        return listData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        View oncCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

        void onItemClick(View view, int position);
    }

}
