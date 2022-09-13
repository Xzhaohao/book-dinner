package org.kuro.dinner.ui;

import android.os.Bundle;
import android.widget.ImageView;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseUIActivity;

public class OrderDetailActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        ImageView back = findViewById(R.id.order_detail_back);
        back.setOnClickListener(v -> finish());
    }
}