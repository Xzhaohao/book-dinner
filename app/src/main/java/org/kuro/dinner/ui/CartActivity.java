package org.kuro.dinner.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.adapter.CartAdapter;
import org.kuro.dinner.base.BaseUIActivity;
import org.kuro.dinner.model.entity.Cart;

public class CartActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initView();
    }

    private void initView() {
        ImageView cartBack = findViewById(R.id.cart_back);
        cartBack.setOnClickListener(v -> finish());

        RecyclerView cartRecycler = findViewById(R.id.cart_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        cartRecycler.setLayoutManager(layoutManager);
        cartRecycler.setAdapter(new CartAdapter(Cart.list(), this));
    }
}