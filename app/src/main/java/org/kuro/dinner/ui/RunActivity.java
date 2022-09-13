package org.kuro.dinner.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import org.kuro.dinner.R;
import org.kuro.dinner.base.BaseUIActivity;

public class RunActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        initView();
    }

    private void initView() {
        TextView distance = findViewById(R.id.run_distance);
        SpannableString distanceText = new SpannableString("3公里内 预计 60 分钟内送达");
        distanceText.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        distanceText.setSpan(new ForegroundColorSpan(Color.parseColor("#31A2FD")), 4, distanceText.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        distance.setText(distanceText);

        ImageView back = findViewById(R.id.run_back);
        back.setOnClickListener(v -> finish());
    }
}