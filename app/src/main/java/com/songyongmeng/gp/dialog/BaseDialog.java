package com.songyongmeng.gp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;


/**
 * @author admin on 2018/8/31.
 */
public class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    private void init() {
        SystemBarUtil.setStatusBarTranslucent(getWindow());
    }

    /**
     * 这是dialog 宽高的
     */
    public BaseDialog setAttributes(Context context) {
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        Point p=new Point();
        display.getSize(p);

        lp.width = (int) (p.x * getWidthRatio());
        lp.height=(int) (p.y * getHeightRatio());

        getWindow().setAttributes(lp);
        return this;
    }

    public float getWidthRatio(){
        return 1.0f;
    }

    public float getHeightRatio(){
        return 1.0f;
    }
}
