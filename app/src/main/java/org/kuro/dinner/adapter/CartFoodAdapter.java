package org.kuro.dinner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Cart;

import java.util.List;

public class CartFoodAdapter extends BaseAdapter {

    private final Context context;
    private final List<Cart.Food> list;

    public CartFoodAdapter(Context context, List<Cart.Food> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartFoodAdapter.ViewHolder holder = null;
        if (convertView == null) {
            holder = new CartFoodAdapter.ViewHolder();
            convertView = View.inflate(context, R.layout.cart_food_item, null);

            holder.foodName = convertView.findViewById(R.id.cart_food_name);
            holder.foodNorms = convertView.findViewById(R.id.cart_food_norms);
            holder.foodNumber = convertView.findViewById(R.id.cart_food_number);
            holder.foodPrice = convertView.findViewById(R.id.cart_food_price);

            convertView.setTag(holder);
        } else {
            holder = (CartFoodAdapter.ViewHolder) convertView.getTag();
        }

        Cart.Food food = list.get(position);
        holder.foodName.setText(food.getFoodName());
        holder.foodNumber.setText("×" + food.getNumber());
        holder.foodNorms.setText("规格：" + food.getNorms());
        holder.foodPrice.setText("¥ " + food.getPrice());
        return convertView;
    }

    static class ViewHolder {
        private TextView foodName;
        private TextView foodNorms;
        private TextView foodNumber;
        private TextView foodPrice;
    }
}
