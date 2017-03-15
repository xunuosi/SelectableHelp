package cn.nuosi.andoroid.testdrawline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.greendao.query.CursorQuery;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import cn.nuosi.andoroid.testdrawline.dao.Book;
import cn.nuosi.andoroid.testdrawline.greendao.gen.BookDao;
import cn.nuosi.andoroid.testdrawline.greendao.gen.DaoMaster;

/**
 * 浮动的Activity
 */

public class FlaotActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Book mBook;
    private TextView mSendTextView;
    private BookDao mBookDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);

        mTextView = (TextView) findViewById(R.id.tv_show);
        mEditText = (EditText) findViewById(R.id.et);
        mSendTextView = (TextView) findViewById(R.id.tv_send);

        Intent intent = getIntent();
        if (intent != null) {
            mBook = intent.getParcelableExtra("book");
            mTextView.setText(mBook.getContent());
            if (mBook.getNote() != null) {
                mEditText.setText(mBook.getNote());
            }
        }

        mSendTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = mEditText.getText().toString();
                mBookDao = GreenDaoManager.getInstance().getSession().getBookDao();
                QueryBuilder<Book> queryBuilder = mBookDao.queryBuilder();
                Book book = queryBuilder.where(BookDao.Properties.Start.eq(mBook.getStart())).unique();
                mBook = book;
                mBook.setNote(note);
                mBookDao.update(mBook);
                // 跳转到主界面
                Intent intent = new Intent(FlaotActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
