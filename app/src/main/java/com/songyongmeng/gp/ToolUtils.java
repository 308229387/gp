package com.songyongmeng.gp;

import android.util.Log;

import java.lang.reflect.Field;

public class ToolUtils {
    public static int getImages(String name) {
        Class drawable = R.drawable.class;
        Field field = null;
        try {
            field = drawable.getField(name);
            int images = field.getInt(field.getName());
            return images;
        } catch (Exception e) {
            Log.d("song_test", e.getMessage());
        }
        return 0;
    }

    public static boolean startWithText(String tmp) {
        if (tmp.startsWith("text:")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean startWithImage(String tmp) {
        if (tmp.startsWith("image:")) {
            return true;
        } else {
            return false;
        }
    }

    public static String replaceText(String tmp) {
        return tmp.replace("text:", "");
    }

    public static String replaceImage(String tmp) {
        return tmp.replace("image:", "");
    }
}
