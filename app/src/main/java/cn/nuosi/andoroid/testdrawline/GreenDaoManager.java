package cn.nuosi.andoroid.testdrawline;

import cn.nuosi.andoroid.testdrawline.greendao.gen.DaoMaster;
import cn.nuosi.andoroid.testdrawline.greendao.gen.DaoSession;

/**
 * Created by Elder on 2017/3/14.
 * 数据库帮助类
 */

public class GreenDaoManager {

    private static GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(DrawLineApplication.getContext(),                "users-db", null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            mInstance = new GreenDaoManager();
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
