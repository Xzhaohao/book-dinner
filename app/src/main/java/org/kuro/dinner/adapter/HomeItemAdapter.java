package org.kuro.dinner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Category;

import java.util.List;

public class HomeItemAdapter extends BaseAdapter {

    private Context context;
    private List<Category.CategoryItem> items;

    public HomeItemAdapter(Context context, List<Category.CategoryItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if (items != null) {
            return items.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category.CategoryItem subcategory = items.get(position);
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.category_home_item, null);
            viewHold = new ViewHold();
            viewHold.tv_name = convertView.findViewById(R.id.item_home_name);
            viewHold.iv_icon = convertView.findViewById(R.id.item_album);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.tv_name.setText(subcategory.getName());
        switch (position) {
            case 1:
                viewHold.iv_icon.setImageResource(R.mipmap.food2);
                break;
            case 2:
                viewHold.iv_icon.setImageResource(R.mipmap.food3);
                break;
            default:
                viewHold.iv_icon.setImageResource(R.mipmap.food1);
        }
        return convertView;
    }

    private static class ViewHold {
        private TextView tv_name;
        private ImageView iv_icon;
    }
}
