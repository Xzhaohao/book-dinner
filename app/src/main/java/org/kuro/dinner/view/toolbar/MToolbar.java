package org.kuro.dinner.view.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import org.kuro.dinner.R;

public class MToolbar extends Toolbar {

    private View mView;
    private TextView mTitle;
    private TextView rightText;
    private EditText searchInput;

    public MToolbar(Context context) {
        this(context, null);
    }

    public MToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {
        if (mView == null) {
            LayoutInflater mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.tool_bar, null);

            searchInput = mView.findViewById(R.id.toolbar_search);
            mTitle = mView.findViewById(R.id.toolbar_title);
            rightText = mView.findViewById(R.id.toolbar_right_text);

            LayoutParams layoutParams = new LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.CENTER_VERTICAL);

            addView(mView, layoutParams);
        }
    }


    @Override
    public void setNavigationOnClickListener(OnClickListener listener) {
        super.setNavigationOnClickListener(listener);
    }


    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTitle != null) {
            mTitle.setText(title);
            showTitle();
        }
    }


    public void showSearch() {
        if (searchInput != null) {
            searchInput.setVisibility(VISIBLE);
        }
    }


    public void hideSearch() {
        if (searchInput != null) {
            searchInput.setVisibility(GONE);
        }
    }


    public void showTitle() {
        if (mTitle != null) {
            mTitle.setVisibility(VISIBLE);
        }
    }


    public void hideTitle() {
        if (mTitle != null) {
            mTitle.setVisibility(GONE);
        }
    }


    public void showRightText() {
        if (rightText != null) {
            rightText.setVisibility(VISIBLE);
        }
    }


    public void hideRightText() {
        if (rightText != null) {
            rightText.setVisibility(GONE);
        }
    }
}
