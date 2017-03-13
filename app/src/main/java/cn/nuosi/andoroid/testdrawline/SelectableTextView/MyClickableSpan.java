package cn.nuosi.andoroid.testdrawline.SelectableTextView;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.View;

/**
 * Created by Elder on 2017/3/13.
 * 自定义ClickableSpan用于动态调整画线颜色
 */

public abstract class MyClickableSpan extends CharacterStyle implements UpdateAppearance {

    private float mTextSize;
    private int mColor;

    public MyClickableSpan(float textSize, int color) {
        mTextSize = textSize;
        mColor = color;
    }

    /**
     * Performs the click action associated with this span.
     */
    public abstract void onClick(View widget);

    /**
     * Makes the text underlined and in the link color.
     */
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(mColor);
        ds.setTextSize(mTextSize);
        ds.setUnderlineText(true);
    }

}
