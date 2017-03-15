package cn.nuosi.andoroid.testdrawline.SelectableTextView;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Elder on 2017/3/10.
 * 记录选择文本信息的实体类
 */

public class SelectionInfo {

    private int mStart;
    private int mEnd;
    private String mSelectionContent;
    private String mNoteContent;
    private int mColor;

    public SelectionInfo() {
    }



    public int getStart() {
        return mStart;
    }

    public void setStart(int start) {
        mStart = start;
    }

    public int getEnd() {
        return mEnd;
    }

    public void setEnd(int end) {
        mEnd = end;
    }

    public String getSelectionContent() {
        return mSelectionContent;
    }

    public void setSelectionContent(String selectionContent) {
        mSelectionContent = selectionContent;
    }

    public String getNoteContent() {
        return mNoteContent;
    }

    public void setNoteContent(String noteContent) {
        mNoteContent = noteContent;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    @Override
    public String toString() {
        return "SelectionInfo{" +
                "mStart=" + mStart +
                ", mEnd=" + mEnd +
                ", mSelectionContent='" + mSelectionContent + '\'' +
                ", mNoteContent='" + mNoteContent + '\'' +
                ", mColor=" + mColor +
                '}';
    }
}
