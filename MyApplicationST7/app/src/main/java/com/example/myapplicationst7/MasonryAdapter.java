package com.example.myapplicationst7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryViewHolder> {
    private static List<Product> products;


    public MasonryAdapter(List<Product> list) {
        products = list;
    }

    @NonNull
    @Override
    public MasonryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item_card, viewGroup, false);
        return new MasonryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MasonryViewHolder holder, int position) {
        // 在viewHolder绑定的时候触发
        holder.imageView.setImageResource(products.get(position).getImg());
        holder.textView.setText(products.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void swap(int firstPosition, int secondPosition) {
        Collections.swap(products, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    public void remove(int position) {
        products.remove(position);
        notifyItemRemoved(position);
    }

    public static class MasonryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MasonryViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.masonry_item_img);
            textView = itemView.findViewById(R.id.masonry_item_title);
        }

    }


}