package cn.nuosi.andoroid.testdrawline.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Elder on 2017/3/14.
 * 每本书的实体类
 */
@Entity(indexes = {
    @Index(value = "id, id DESC", unique = true)})
public class Book {
    @Id
    private int id;

    private String name;

    @NotNull
    private int start;
    private int end;

    private String content;
    private String note;


    @Generated(hash = 1899122326)
    public Book(int id, String name, int start, int end, String content,
            String note) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.content = content;
        this.note = note;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
