package com.songyongmeng.gp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.utils.AssetsUtils;

import java.util.List;

public class EmptyBigImageActivity extends Activity {
    BigImageListBean imageList;
    String name;
    List<String> list;

    ViewPager viewPager;
    private Handler autoScrollHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new StatusBar(this).hide();
        setContentView(R.layout.image_pagerl_layout);


        Intent intent = getIntent();
        list = intent.getStringArrayListExtra("image_list");

        viewPager = findViewById(R.id.viewPager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(this); // 你需要创建一个适配器
        adapter.setImageList(list);
        viewPager.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    private void stopAutoScroll() {
        autoScrollHandler.removeCallbacksAndMessages(null);
    }

}
