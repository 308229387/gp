package com.songyongmeng.gp.utils;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * assets 文件操作-读取
 * Created by Sogrey on 2018/8/8.
 */

public class AssetsUtils {
    public static List<String> getImageFileNamesFromAssets(Context context, String folderName) {
        List<String> fileNames = new ArrayList<>();

        AssetManager assetManager = context.getAssets();
        try {
            String[] files = assetManager.list(folderName);
            for (String file : files) {
                fileNames.add(file);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error listing assets", e);
        }

        return fileNames;
    }

    public static Bitmap getBitmapFromAsset(Context context, String fileName) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open(fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bitmap;
        } catch (IOException e) {
            Log.e(TAG, "Error loading image: " + fileName, e);
            return null;
        }
    }

    /**
     * 读取文本文件返回字符串
     *
     * @param context  上下文
     * @param fileName 文件名（包含路径）
     * @return
     */
    public String readAssetsText(Context context, String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            String text = InputStream2String(is);
//            LogUtil.E(text);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String InputStream2String(InputStream is) throws IOException {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
//            buffer.append("\n");
        }
        return buffer.toString();
    }


}
