package org.kuro.dinner.fragment;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseFragment;
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
    }

    @Override
    protected void initData() {

    }
}