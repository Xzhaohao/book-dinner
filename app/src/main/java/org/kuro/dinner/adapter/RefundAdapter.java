package org.kuro.dinner.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Refund;

import java.util.List;

public class RefundAdapter extends BaseAdapter {

    private final Context context;
    private final List<Refund> list;

    public RefundAdapter(Context context, List<Refund> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RefundAdapter.ViewHolder holder = null;
        if (convertView == null) {
            holder = new RefundAdapter.ViewHolder();
            convertView = View.inflate(context, R.layout.time_line_item, null);
            holder.refundTopLine = convertView.findViewById(R.id.refund_top_line);
            holder.refundSpot = convertView.findViewById(R.id.refund_spot);
            holder.refundText = convertView.findViewById(R.id.refund_text);
            holder.refundTime = convertView.findViewById(R.id.refund_time);
            holder.footLine = convertView.findViewById(R.id.refund_foot_line);
            holder.refundTitle = convertView.findViewById(R.id.refund_title);
            convertView.setTag(holder);
        } else {
            holder = (RefundAdapter.ViewHolder) convertView.getTag();
        }

        if (position == list.size() - 1) {
            holder.footLine.setVisibility(View.GONE);
        }

        if (position == 0) {
            holder.refundTopLine.setBackgroundColor(Color.TRANSPARENT);
            holder.refundTitle.setTextColor(context.getResources().getColor(R.color.primary));
            holder.refundSpot.setBackgroundResource(R.drawable.shape_refund_active);

        } else {
            holder.refundTopLine.setBackgroundColor(context.getResources().getColor(R.color.nodeLine));
        }

        Refund refund = list.get(position);
        holder.refundText.setText(refund.getContent());
        holder.refundTime.setText(refund.getTime());
        holder.refundTitle.setText(refund.getTitle());
        return convertView;
    }

    static class ViewHolder {
        public View refundTopLine;
        public View footLine;
        private ImageView refundSpot;
        private TextView refundText;
        private TextView refundTime;
        private TextView refundTitle;
    }
}
