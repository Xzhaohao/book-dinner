package org.kuro.dinner.fragment;

import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.adapter.SellerAdapter;
import org.kuro.dinner.base.BaseFragment;
import org.kuro.dinner.model.entity.Seller;
import org.kuro.dinner.view.swipe.Swipe;
import org.kuro.dinner.view.swipe.entity.LocalImageInfo;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    private Swipe swiper;

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
        swiper = mRootView.findViewById(R.id.swipe_home);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT, DisplayUtil.getScreenWidth(requireActivity()) / 2
//        );
//        swiper.setLayoutParams(layoutParams);

        initSwipe(swiper);

        RecyclerView recyclerView = mRootView.findViewById(R.id.home_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SellerAdapter(Seller.getList(), requireActivity()));
    }

    @Override
    protected void initData() {
        initLocalImage();
    }

    // 初始化Swipe
    private void initSwipe(Swipe swiper) {
        swiper.loadImage((banner, model, view, position) -> {
            // 加载本地图片展示
            ((ImageView) view).setImageResource(((LocalImageInfo) model).getSwipeUrl());
        });
    }

    // 加载本地图片
    private void initLocalImage() {
        List<LocalImageInfo> data = new ArrayList<>();
        data.add(new LocalImageInfo(R.mipmap.banner));
        data.add(new LocalImageInfo(R.mipmap.banner));
        data.add(new LocalImageInfo(R.mipmap.banner));
        swiper.setBannerData(data);
        swiper.setAutoPlayAble(true);
    }
}