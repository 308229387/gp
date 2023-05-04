
package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public final class AppContextUtils {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static Context getAppContext() {
        if (mContext == null) {
            throw new IllegalStateException("AppContextUtils 's initApp not called!!!");
        }
        return mContext;
    }

    public static void initApp(Context app) {
        mContext = app.getApplicationContext();
    }

    /**
     * 获取包名
     */
    public static String getPackageName(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取清单文件中的元数据
     *
     * @param name the key of value
     */
    public static String getStringMetaData(String name) {
        try {
            ApplicationInfo info = getApplicationInfo(mContext);
            assert info != null;
            return info.metaData.getString(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取应用信息
     */
    public static ApplicationInfo getApplicationInfo(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            if (manager == null)
                return null;
            return manager.getApplicationInfo(getPackageName(context),
                    PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
