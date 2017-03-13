package cn.nuosi.andoroid.testdrawline.SelectableTextView;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Elder on 2017/3/10.
 * 记录选择文本信息的实体类
 */

public class SelectionInfo implements Parcelable{

    private int mStart;
    private int mEnd;
    private String mSelectionContent;

    public SelectionInfo() {
    }

    protected SelectionInfo(Parcel in) {
        mStart = in.readInt();
        mEnd = in.readInt();
        mSelectionContent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStart);
        dest.writeInt(mEnd);
        dest.writeString(mSelectionContent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SelectionInfo> CREATOR = new Creator<SelectionInfo>() {
        @Override
        public SelectionInfo createFromParcel(Parcel in) {
            return new SelectionInfo(in);
        }

        @Override
        public SelectionInfo[] newArray(int size) {
            return new SelectionInfo[size];
        }
    };

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

    @Override
    public String toString() {
        return "SelectionInfo{" +
                "mStart=" + mStart +
                ", mEnd=" + mEnd +
                ", mSelectionContent='" + mSelectionContent + '\'' +
                '}';
    }
}
