package org.kuro.dinner.view.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

import org.kuro.dinner.R;

public class RoundButton extends AppCompatButton {

    private ColorStateList colorStateListForTextColorForPressed;
    private ColorStateList colorStateListTemp = null;


    public RoundButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    /**
     * xml引入方式
     */
    public RoundButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.RoundButtonStyle);
        init(context, attrs, R.attr.RoundButtonStyle);
    }

    public RoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        RoundButtonDrawable mRoundButtonDrawable = RoundButtonDrawable.obtainAttributeData(context, attrs, defStyleAttr);
        colorStateListForTextColorForPressed = mRoundButtonDrawable.getColorStateListForTextColorForPressed();
        // 处理原按钮padding
        int[] padding = new int[]{this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom()};
        // 将drawable设置给当前Button
        this.setBackground(mRoundButtonDrawable);
        this.setPadding(padding[0], padding[1], padding[2], padding[3]);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                colorStateListTemp = getTextColors();
                this.setTextColor(colorStateListForTextColorForPressed);

                break;
            case MotionEvent.ACTION_UP:
                this.setTextColor(colorStateListTemp);
                break;
        }
        return true;
    }


    @Override
    public boolean callOnClick() {
        return super.callOnClick();
    }
}
