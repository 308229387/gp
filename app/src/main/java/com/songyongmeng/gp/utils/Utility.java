package com.songyongmeng.gp.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.songyongmeng.gp.R;
import com.songyongmeng.gp.SystemBarTintManager;

public class Utility {
    /**
     * 改变通知栏颜色
     */
    public static void setActionBar(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(context, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager((Activity) context);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.title_bar_blue);
    }

    /**
     * 改变通知栏颜色
     */
    public static void setActionBar(Context context,int color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(context, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager((Activity) context);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
    }

    @TargetApi(19)
    public static void setTranslucentStatus(Context context, boolean on) {
        Window win = ((Activity)context).getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public static void hintTop(Activity context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = context.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            // 关键是这句，其实跟xml里的配置长得几乎一样
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(lp);
        }

    }
}