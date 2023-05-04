package com.songyongmeng.gp;

import android.app.Application;

import com.orhanobut.hawk.Hawk;


public class GPApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this).build();
    }
}
