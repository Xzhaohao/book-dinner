package org.kuro.dinner.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.adapter.OrderAdapter;
import org.kuro.dinner.base.BaseFragment;
import org.kuro.dinner.model.entity.Order;

public class OrderFragment extends BaseFragment {

    public OrderFragment() {
    }

    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {
        RecyclerView orderRecycler = mRootView.findViewById(R.id.order_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        orderRecycler.setLayoutManager(layoutManager);
        orderRecycler.setAdapter(new OrderAdapter(Order.getList(), requireContext()));
    }

    @Override
    protected void initData() {

    }
}