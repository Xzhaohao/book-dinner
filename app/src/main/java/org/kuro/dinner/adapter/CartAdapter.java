package org.kuro.dinner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    List<Cart> cartList;
    Context context;

    public CartAdapter(List<Cart> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartAdapter.CartViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = cartList.get(position);
        List<Cart.Food> foods = cart.getFoods();

        holder.seller.setText(cart.getSellerName());
        holder.foodList.setAdapter(new CartFoodAdapter(context, foods));
        // ListView自适应高度
        ListAdapter adapter = holder.foodList.getAdapter();
        if (adapter != null) {
            int totalHeight = 0;
            for (int i = 0; i < adapter.getCount(); i++) {
                View listItem = adapter.getView(i, null, holder.foodList);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = holder.foodList.getLayoutParams();
            params.height = totalHeight + (holder.foodList.getDividerHeight() * (holder.foodList.getCount() - 1));
            holder.foodList.setLayoutParams(params);
        }

        double price = 0;
        for (Cart.Food food : foods) {
            price += Double.parseDouble(food.getPrice());
        }
        holder.totalPrice.setText("¥" + price);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView seller;
        ListView foodList;
        TextView totalPrice;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            seller = itemView.findViewById(R.id.cart_seller);
            foodList = itemView.findViewById(R.id.cart_food_list);
            totalPrice = itemView.findViewById(R.id.cart_total_price);
        }
    }
}
