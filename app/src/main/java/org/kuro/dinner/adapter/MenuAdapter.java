package org.kuro.dinner.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.kuro.dinner.R;

import java.util.List;

public class MenuAdapter extends BaseAdapter {

    private final Context context;
    private int selectItem = 0;
    private final List<String> list;

    public MenuAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.category_menu, null);
            holder.tv_name = convertView.findViewById(R.id.category_item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == selectItem) {
            holder.tv_name.setBackgroundColor(context.getResources().getColor(R.color.mine_bg));
            holder.tv_name.setTextColor(context.getResources().getColor(R.color.blackText3));
        } else {
            holder.tv_name.setBackgroundColor(Color.WHITE);
            holder.tv_name.setTextColor(context.getResources().getColor(R.color.gray_6));
        }
        holder.tv_name.setText(list.get(position));
        return convertView;
    }

    static class ViewHolder {
        private TextView tv_name;
    }
}
