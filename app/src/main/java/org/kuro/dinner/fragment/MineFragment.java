package org.kuro.dinner.fragment;

import android.widget.LinearLayout;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseFragment;
import org.kuro.dinner.ui.AddressActivity;
import org.kuro.dinner.ui.BalanceActivity;
import org.kuro.dinner.ui.PayActivity;
import org.kuro.dinner.view.avatar.Avatar;

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
        // 头像
        Avatar avatar = mRootView.findViewById(R.id.mine_avatar);
        avatar.setImageUrl(avatar, "https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/3.png", true);

        // 前往我的余额页面
        LinearLayout balanceRow = mRootView.findViewById(R.id.balance_row);
        balanceRow.setOnClickListener(v -> navigateTo(BalanceActivity.class));

        // 前往收货地址页面
        LinearLayout addressRow = mRootView.findViewById(R.id.address_row);
        addressRow.setOnClickListener(v -> navigateTo(AddressActivity.class));

        LinearLayout followRow = mRootView.findViewById(R.id.follow_row);
        followRow.setOnClickListener(v -> navigateTo(PayActivity.class));

    }

    @Override
    protected void initData() {

    }
}