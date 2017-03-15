package cn.nuosi.andoroid.testdrawline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import cn.nuosi.andoroid.testdrawline.dao.Book;

/**
 * 浮动的Activity
 */

public class FlaotActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Book mBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);

        mTextView = (TextView) findViewById(R.id.tv_show);
        mEditText = (EditText) findViewById(R.id.et);

        Intent intent = getIntent();
        if (intent != null) {
            mBook = intent.getParcelableExtra("book");
            mTextView.setText(mBook.getContent());
        }
    }
}
