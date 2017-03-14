package cn.nuosi.andoroid.testdrawline;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.nuosi.andoroid.testdrawline.SelectableTextView.OnSelectListener;
import cn.nuosi.andoroid.testdrawline.SelectableTextView.SelectableTextHelper;
import cn.nuosi.andoroid.testdrawline.dao.Book;
import cn.nuosi.andoroid.testdrawline.greendao.gen.BookDao;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    /**
     * 自定义TextView的属性
     */
    private TextView mTextView2;
    private SelectableTextHelper mSelectableTextHelper;

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // 解析菜单
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.selection_action_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //根据item的ID处理点击事件
            switch (item.getItemId()) {
                case R.id.Informal22:
                    Toast.makeText(MainActivity.this, "点击的是22", Toast.LENGTH_SHORT).show();
                    mode.finish();//收起操作菜单
                    break;
                case R.id.Informal33:
                    Toast.makeText(MainActivity.this, "点击的是33", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    break;
            }
            return false;//返回true则系统的"复制"、"搜索"之类的item将无效，只有自定义item有响应
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    private List<Book> mBookList = new ArrayList<>();
    private BookDao mBookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化数据库读取笔记信息
        initData();

        mTextView = (TextView) findViewById(R.id.test_view);

//        setActionMode();
        setListener();

        mTextView2 = (TextView) findViewById(R.id.test_tv2);

        mSelectableTextHelper = new SelectableTextHelper.Builder(mTextView2)
                .setSelectedColor(ContextCompat.getColor(MainActivity.this, R.color.selected_blue))
                .setCursorHandleSizeInDp(20)
                .setPopMenu(R.layout.layout_pop_menu)
                .setCursorHandleColor(ContextCompat.getColor(MainActivity.this, R.color.cursor_handle_color))
                .build();

        mSelectableTextHelper.setSelectListener(new OnSelectListener() {
            @Override
            public void onTextSelected(CharSequence content) {

            }
        });

    }

    private void initData() {
        mBookDao = GreenDaoManager.getInstance().getSession().getBookDao();
        mBookList = GreenDaoManager.getInstance().getSession()
                .getBookDao().queryBuilder().build().list();
        Log.e("xns", "mBookList:" + mBookList.toString());

    }


    private void setListener() {

        mTextView.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // 解析菜单
                MenuInflater menuInflater = mode.getMenuInflater();
                if (menuInflater != null) {
                    menuInflater.inflate(R.menu.selection_action_menu, menu);
                }
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                //根据item的ID处理点击事件
                switch (item.getItemId()) {
                    case R.id.Informal22:
                        Toast.makeText(MainActivity.this, "点击的是22", Toast.LENGTH_SHORT).show();
                        mode.finish();//收起操作菜单
                        break;
                    case R.id.Informal33:
                        Toast.makeText(MainActivity.this, "点击的是33", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        break;
                }
                return false;//返回true则系统的"复制"、"搜索"之类的item将无效，只有自定义item有响应
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

        });

    }
}
