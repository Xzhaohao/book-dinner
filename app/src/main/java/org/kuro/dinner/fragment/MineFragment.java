package org.kuro.dinner.fragment;

import android.widget.LinearLayout;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseFragment;
import org.kuro.dinner.ui.AddressActivity;
import org.kuro.dinner.ui.BalanceActivity;
import org.kuro.dinner.ui.CartActivity;
import org.kuro.dinner.ui.PayActivity;

public class MineFragment extends BaseFragment {

    public MineFragment() {
    }

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        // 前往我的余额页面
        LinearLayout balanceRow = mRootView.findViewById(R.id.balance_row);
        balanceRow.setOnClickListener(v -> navigateTo(BalanceActivity.class));

        // 前往收货地址页面
        LinearLayout addressRow = mRootView.findViewById(R.id.address_row);
        addressRow.setOnClickListener(v -> navigateTo(AddressActivity.class));

        LinearLayout followRow = mRootView.findViewById(R.id.follow_row);
        followRow.setOnClickListener(v -> navigateTo(PayActivity.class));

        // 前往购物车页面
        LinearLayout cartRow = mRootView.findViewById(R.id.cart_row);
        cartRow.setOnClickListener(v -> navigateTo(CartActivity.class));
    }

    @Override
    protected void initData() {

    }
}