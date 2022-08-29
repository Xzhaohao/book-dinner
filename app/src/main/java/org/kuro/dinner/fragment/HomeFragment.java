package org.kuro.dinner.fragment;

import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseFragment;
import org.kuro.dinner.ui.LoginActivity;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        TextView homeText = mRootView.findViewById(R.id.home_text);
        homeText.setOnClickListener(v -> navigateTo(LoginActivity.class));
    }

    @Override
    protected void initData() {

    }
}