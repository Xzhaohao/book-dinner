package org.kuro.dinner.ui;

import android.os.Bundle;
import android.widget.ImageView;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseUIActivity;

public class PayActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        initView();
    }

    private void initView() {
        ImageView back = findViewById(R.id.pay_back);
        back.setOnClickListener(v -> finish());
    }
}