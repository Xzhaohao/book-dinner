package org.kuro.dinner.ui;

import android.os.Bundle;
import android.widget.ImageView;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseUIActivity;

public class BalanceActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        initView();
    }

    private void initView() {
        ImageView back = findViewById(R.id.balance_back);
        back.setOnClickListener(v -> finish());
    }
}