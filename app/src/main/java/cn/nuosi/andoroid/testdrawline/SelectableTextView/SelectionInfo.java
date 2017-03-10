package cn.nuosi.andoroid.testdrawline.SelectableTextView;

/**
 * Created by Elder on 2017/3/10.
 * 记录选择文本信息的实体类
 */

public class SelectionInfo {

    private int mStart;
    private int mEnd;
    private String mSelectionContent;

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
}
