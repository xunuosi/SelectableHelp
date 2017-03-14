package cn.nuosi.andoroid.testdrawline;

import android.app.Application;
import android.content.Context;

/**
 * Created by Elder on 2017/3/14.
 *
 */

public class DrawLineApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
