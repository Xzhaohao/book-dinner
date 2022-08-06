package org.kuro.dinner.base;

import android.os.Bundle;

import org.kuro.dinner.utils.SystemUI;

/**
 * UI 基类
 */
public class BaseUIActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 沉浸式布局
        SystemUI.fixSystemUI(this, true);
    }
}
