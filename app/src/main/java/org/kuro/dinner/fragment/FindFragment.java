package org.kuro.dinner.fragment;

import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.adapter.HomeAdapter;
import org.kuro.dinner.adapter.MenuAdapter;
import org.kuro.dinner.base.BaseFragment;
import org.kuro.dinner.model.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends BaseFragment {

    private List<String> menuList = new ArrayList<>();
    private List<Category> homeList = new ArrayList<>();
    private List<Integer> showTitle = new ArrayList<>();

    private TextView rightTitle;
    private ListView leftMenu;
    private ListView rightHome;

    private MenuAdapter menuAdapter;
    private HomeAdapter homeAdapter;
    private int currentItem;

    public FindFragment() {
    }

    public static FindFragment newInstance() {
        return new FindFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        leftMenu = mRootView.findViewById(R.id.left_menu);
        rightHome = mRootView.findViewById(R.id.right_home);
        rightTitle = mRootView.findViewById(R.id.right_title);

        menuAdapter = new MenuAdapter(requireActivity(), menuList);
        leftMenu.setAdapter(menuAdapter);

        homeAdapter = new HomeAdapter(requireActivity(), homeList);
        rightHome.setAdapter(homeAdapter);

        // 左侧菜单点击事件
        leftMenu.setOnItemClickListener((parent, view, position, id) -> {
            menuAdapter.setSelectItem(position);
            menuAdapter.notifyDataSetInvalidated();
            rightTitle.setText(menuList.get(position));
            rightHome.setSelection(showTitle.get(position));
        });

        // 右侧列表滚动事件
        rightHome.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                this.scrollState = scrollState;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    return;
                }
                int current = showTitle.indexOf(firstVisibleItem);
                if (currentItem != current && current >= 0) {
                    currentItem = current;
                    rightTitle.setText(menuList.get(currentItem));
                    menuAdapter.setSelectItem(currentItem);
                    menuAdapter.notifyDataSetInvalidated();
                }
            }
        });
    }

    @Override
    protected void initData() {
        List<Category> data = Category.data();

        for (int i = 0; i < data.size(); i++) {
            menuList.add(data.get(i).getMenu());
            showTitle.add(i);
            homeList.add(data.get(i));
        }
        rightTitle.setText(data.get(0).getMenu());

        menuAdapter.notifyDataSetChanged();
        homeAdapter.notifyDataSetChanged();
    }

}