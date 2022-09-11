package org.kuro.dinner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Order;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private final Context context;
    private final List<Order.Food> list;

    public FoodAdapter(Context context, List<Order.Food> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
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
        FoodAdapter.ViewHolder holder = null;
        if (convertView == null) {
            holder = new FoodAdapter.ViewHolder();
            convertView = View.inflate(context, R.layout.order_food_item, null);

            holder.food_name = convertView.findViewById(R.id.order_food_name);
            holder.food_number = convertView.findViewById(R.id.order_food_number);
            convertView.setTag(holder);
        } else {
            holder = (FoodAdapter.ViewHolder) convertView.getTag();
        }

        Order.Food food = list.get(position);
        holder.food_name.setText(food.getFoodName());
        holder.food_number.setText("×" + food.getNumber());
        return convertView;
    }

    static class ViewHolder {
        private TextView food_name;
        private TextView food_number;
    }
}
