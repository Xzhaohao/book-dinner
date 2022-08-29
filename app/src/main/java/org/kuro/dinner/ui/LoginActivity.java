package org.kuro.dinner.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

import org.kuro.dinner.MainActivity;
import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseUIActivity;

public class LoginActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        MaterialButton btn = findViewById(R.id.login_btn);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}