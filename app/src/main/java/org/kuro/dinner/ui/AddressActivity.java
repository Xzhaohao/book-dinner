package org.kuro.dinner.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.adapter.AddressAdapter;
import org.kuro.dinner.base.BaseUIActivity;
import org.kuro.dinner.model.entity.Address;

public class AddressActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initView();
    }

    private void initView() {
        ImageView back = findViewById(R.id.address_back);
        back.setOnClickListener(v -> finish());

        RecyclerView addressList = findViewById(R.id.address_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        addressList.setLayoutManager(layoutManager);
        addressList.setAdapter(new AddressAdapter(Address.list(), this));
    }
}