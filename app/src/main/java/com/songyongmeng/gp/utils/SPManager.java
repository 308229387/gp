package com.songyongmeng.gp.utils;
import android.content.Context;
import android.content.SharedPreferences;

public class SPManager {
    private static final String SP_NAME = "MyAppPreferences";
    public static final String ALL_DATA_SIZE = "AllDataSize";
    public static final String SELF_TURNOVER = "SelfTurnover";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static SPManager instance;

    private SPManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized SPManager getInstance(Context context) {
        if (instance == null) {
            instance = new SPManager(context.getApplicationContext());
        }
        return instance;
    }

    public void setValue(String key,String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getValue(String key) {
        return sharedPreferences.getString(key, "");
    }

}
