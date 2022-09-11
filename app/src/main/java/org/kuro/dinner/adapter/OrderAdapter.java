package org.kuro.dinner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.Dict;
import org.kuro.dinner.model.entity.Order;
import org.kuro.dinner.ui.AppraiseActivity;
import org.kuro.dinner.view.button.RoundButton;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    List<Order> orderList;
    Context context;

    public OrderAdapter(List<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        return new OrderAdapter.OrderViewHolder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.seller.setText(order.getSellerName());
        holder.state.setText(Dict.OrderState(order.getState()));

        // 给文字设置不同的颜色
        SpannableString foodNumText = new SpannableString("共 " + order.getFoodNum() + " 件 (含配送费8.00元)");
        foodNumText.setSpan(new ForegroundColorSpan(Color.parseColor("#383838")), 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        foodNumText.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB200")), 2, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        foodNumText.setSpan(new ForegroundColorSpan(Color.parseColor("#383838")), 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        foodNumText.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 5, foodNumText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        holder.foodNum.setText(foodNumText);

        holder.price.setText(order.getPrice());

        // 嵌套ListView显示下单的食品
        holder.orderFoods.setAdapter(new FoodAdapter(context, order.getFoods()));
        // ListView自适应高度
        ListAdapter adapter = holder.orderFoods.getAdapter();
        if (adapter != null) {
            int totalHeight = 0;
            for (int i = 0; i < adapter.getCount(); i++) {
                View listItem = adapter.getView(i, null, holder.orderFoods);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = holder.orderFoods.getLayoutParams();
            params.height = totalHeight + (holder.orderFoods.getDividerHeight() * (holder.orderFoods.getCount() - 1));
            holder.orderFoods.setLayoutParams(params);
        }

        // 根据订单状态显示操作按钮
        switch (order.getState()) {
            case 1: // 待接单
                holder.btnCancel.setVisibility(View.VISIBLE);
                break;
            case 2: // 待配送
                holder.btnCancel.setVisibility(View.VISIBLE);
                holder.btnReminder.setVisibility(View.VISIBLE);
                break;
            case 3: // 待收货
                holder.btnRefundment.setVisibility(View.VISIBLE);
                holder.btnLogistics.setVisibility(View.VISIBLE);
                holder.btnTake.setVisibility(View.VISIBLE);
                break;
            case 4: // 待评价
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnBuy.setVisibility(View.VISIBLE);
                holder.btnAssess.setVisibility(View.VISIBLE);

                // 前往评价页面
                holder.btnAssess.setOnTouchListener((View v, MotionEvent event) -> {
                    // 阻止手指离开时onTouch方法的继续执行
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        context.startActivity(new Intent(context, AppraiseActivity.class));
                        return true;
                    }
                    return false;
                });
                break;
            case 5: // 交易成功
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnBuy.setVisibility(View.VISIBLE);
                break;
            case 6: // 交易取消
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnRefundmentDetail.setVisibility(View.VISIBLE);
                break;
            case 7: // 退款中
                holder.btnRefundmentCancel.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView seller;
        TextView state;
        TextView foodNum;
        TextView price;

        RoundButton btnCancel;
        RoundButton btnRefundment;
        RoundButton btnLogistics;
        RoundButton btnDelete;
        RoundButton btnBuy;
        RoundButton btnRefundmentDetail;
        RoundButton btnReminder;
        RoundButton btnTake;
        RoundButton btnAssess;
        RoundButton btnRefundmentCancel;

        ListView orderFoods;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            seller = itemView.findViewById(R.id.order_seller);
            state = itemView.findViewById(R.id.order_state);
            foodNum = itemView.findViewById(R.id.order_food_num);
            price = itemView.findViewById(R.id.order_price);

            btnCancel = itemView.findViewById(R.id.btn_cancel);
            btnRefundment = itemView.findViewById(R.id.btn_refundment);
            btnLogistics = itemView.findViewById(R.id.btn_logistics);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnBuy = itemView.findViewById(R.id.btn_buy);
            btnRefundmentDetail = itemView.findViewById(R.id.btn_refundment_detail);
            btnReminder = itemView.findViewById(R.id.btn_reminder);
            btnTake = itemView.findViewById(R.id.btn_take);
            btnAssess = itemView.findViewById(R.id.btn_assess);
            btnRefundmentCancel = itemView.findViewById(R.id.btn_refundment_cancel);

            orderFoods = itemView.findViewById(R.id.order_foods);
        }
    }
}
