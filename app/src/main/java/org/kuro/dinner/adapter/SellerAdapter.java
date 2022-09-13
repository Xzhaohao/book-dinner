package org.kuro.dinner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Seller;
import org.kuro.dinner.ui.RunActivity;

import java.util.List;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder> {

    List<Seller> sellerList;
    Context context;

    public SellerAdapter(List<Seller> sellerList, Context context) {
        this.sellerList = sellerList;
        this.context = context;
    }

    @NonNull
    @Override
    public SellerAdapter.SellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.seller_item, parent, false);
        return new SellerAdapter.SellerViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SellerAdapter.SellerViewHolder holder, int position) {
        Seller seller = sellerList.get(position);
        holder.title.setText(seller.getName());
        holder.distance.setText(seller.getDistance());
        holder.score.setText(seller.getScore());
        holder.sales.setText("月售 " + seller.getSales());
        holder.startPrice.setText("起送 ¥" + seller.getStartPrice());
        holder.dispatching.setText("配送 ¥" + seller.getDispatching());

        holder.cover.setOnClickListener(v -> context.startActivity(new Intent(context, RunActivity.class)));
        holder.title.setOnClickListener(v -> context.startActivity(new Intent(context, RunActivity.class)));

        // 封面
        switch (position % 3) {
            case 1:
                holder.cover.setImageResource(R.mipmap.food_menu2);
                break;
            case 2:
                holder.cover.setImageResource(R.mipmap.food_menu3);
                break;
            default:
                holder.cover.setImageResource(R.mipmap.food_menu1);
        }

        // 星星
        int starNum = (int) Math.floor(Float.parseFloat(seller.getScore()));
        switch (starNum) {
            case 0:
                holder.star1.setImageResource(R.drawable.star);
            case 1:
                holder.star2.setImageResource(R.drawable.star);
            case 2:
                holder.star3.setImageResource(R.drawable.star);
            case 3:
                holder.star4.setImageResource(R.drawable.star);
            case 4:
                holder.star5.setImageResource(R.drawable.star);
        }
    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }

    static class SellerViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        TextView title;
        TextView distance;
        TextView score;
        TextView sales;
        TextView startPrice;
        TextView dispatching;

        public SellerViewHolder(@NonNull View itemView) {
            super(itemView);

            cover = itemView.findViewById(R.id.seller_cover);
            star1 = itemView.findViewById(R.id.seller_star1);
            star2 = itemView.findViewById(R.id.seller_star2);
            star3 = itemView.findViewById(R.id.seller_star3);
            star4 = itemView.findViewById(R.id.seller_star4);
            star5 = itemView.findViewById(R.id.seller_star5);
            title = itemView.findViewById(R.id.seller_title);
            distance = itemView.findViewById(R.id.seller_distance);
            score = itemView.findViewById(R.id.seller_score);
            sales = itemView.findViewById(R.id.seller_sales);
            startPrice = itemView.findViewById(R.id.seller_start_price);
            dispatching = itemView.findViewById(R.id.seller_dispatching);
        }
    }
}
