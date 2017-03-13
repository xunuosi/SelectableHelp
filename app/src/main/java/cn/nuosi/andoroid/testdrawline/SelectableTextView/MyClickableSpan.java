package cn.nuosi.andoroid.testdrawline.SelectableTextView;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/**
 * Created by Elder on 2017/3/13.
 * 自定义ClickableSpan用于动态调整画线颜色
 */

public abstract class MyClickableSpan extends ClickableSpan {

    private float mTextSize;
    private int mColor;
    private TextPaint mPaint;
    private SelectionInfo mInfo;

    public MyClickableSpan(TextPaint paint) {
        mPaint = paint;
        mColor = paint.getColor();
        mTextSize = paint.getTextSize();
    }

    /**
     * Makes the text underlined and in the link color.
     */
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.set(mPaint);
        ds.setColor(mColor);
        ds.setTextSize(mTextSize);
        ds.setUnderlineText(true);
    }

    /**
     * 更新文本画笔的方法
     * @param paint
     */
    public void setTextPaint(TextPaint paint) {
        mPaint = paint;
        mColor = paint.getColor();
        mTextSize = paint.getTextSize();
        updateDrawState(mPaint);
    }

    public SelectionInfo getInfo() {
        return mInfo;
    }

    public void setInfo(SelectionInfo info) {
        mInfo = info;
    }

    @Override
    public String toString() {
        return "MyClickableSpan{" +
                "mTextSize=" + mTextSize +
                ", mColor=" + mColor +
                ", mPaint=" + mPaint +
                ", mInfo=" + mInfo +
                '}';
    }
}
