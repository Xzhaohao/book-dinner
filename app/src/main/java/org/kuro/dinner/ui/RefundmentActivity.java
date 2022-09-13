package org.kuro.dinner.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import org.kuro.dinner.R;
import org.kuro.dinner.adapter.RefundAdapter;
import org.kuro.dinner.base.BaseUIActivity;
import org.kuro.dinner.model.entity.Refund;

public class RefundmentActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refundment);

        initView();
    }


    private void initView() {
        ImageView back = findViewById(R.id.refund_back);
        back.setOnClickListener(v -> finish());

        ListView refundList = findViewById(R.id.refund_list);
        refundList.setAdapter(new RefundAdapter(this, Refund.list()));
    }
}