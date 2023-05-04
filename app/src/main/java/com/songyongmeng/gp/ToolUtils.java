package com.songyongmeng.gp;

import android.util.Log;

import java.lang.reflect.Field;

public class ToolUtils {
    public static int getImages(String name){
        Class drawable = R.drawable.class;
        Field field = null;
        try {
            field =drawable.getField(name);
            int images = field.getInt(field.getName());
            return images;
        } catch (Exception e) {
            Log.d("song_test",e.getMessage());
        }
        return 0;
    }
}
