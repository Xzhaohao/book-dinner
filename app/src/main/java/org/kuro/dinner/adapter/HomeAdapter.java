package org.kuro.dinner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Category;
import org.kuro.dinner.view.grid.GridViewForScrollView;

import java.util.List;

public class HomeAdapter extends BaseAdapter {

    private final Context context;
    private final List<Category> list;

    public HomeAdapter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        } else {
            return 10;
        }
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
        Category dataBean = list.get(position);
        List<Category.CategoryItem> dataList = dataBean.getList();
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.category_home, null);
            viewHold = new ViewHold();
            viewHold.gridView = convertView.findViewById(R.id.grid_view);
            viewHold.blank = convertView.findViewById(R.id.blank);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        HomeItemAdapter adapter = new HomeItemAdapter(context, dataList);
        viewHold.blank.setText(dataBean.getMenu());
        viewHold.gridView.setAdapter(adapter);
        return convertView;
    }


    private static class ViewHold {
        private GridViewForScrollView gridView;
        private TextView blank;
    }
}
