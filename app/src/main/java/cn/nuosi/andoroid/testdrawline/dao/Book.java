package cn.nuosi.andoroid.testdrawline.dao;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Elder on 2017/3/14.
 * 每本书的实体类
 */
@Entity
public class Book implements Parcelable {
    @Index
    @Id(autoincrement = true)
    private Long id;

    private String name;

    @NotNull
    private int start;
    private int end;
    private int color;

    private String content;
    private String note;
    
    public Book() {
    }


    @Generated(hash = 647292832)
    public Book(Long id, String name, int start, int end, int color, String content,
            String note) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.color = color;
        this.content = content;
        this.note = note;
    }

    protected Book(Parcel in) {
        name = in.readString();
        start = in.readInt();
        end = in.readInt();
        color = in.readInt();
        content = in.readString();
        note = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(start);
        dest.writeInt(end);
        dest.writeInt(color);
        dest.writeString(content);
        dest.writeString(note);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
