package com.songyongmeng.gp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.viewpager.widget.ViewPager;

import com.songyongmeng.gp.utils.AssetsUtils;

import java.util.Collections;
import java.util.List;

public class BjcjImageActivity extends Activity {
    BigImageListBean imageList;
    String name;
//    List<String> list;

    ViewPager viewPager;
    private Handler autoScrollHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new StatusBar(this).hide();
        // 设置屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.image_pagerl_layout);


        Intent intent = getIntent();
        List<String> images = AssetsUtils.getImageFileNamesFromAssets(this, Constants.SHOU_BAN_NAME);

        Collections.shuffle(images);
        viewPager = findViewById(R.id.viewPager);
        BjcjImagePagerAdapter adapter = new BjcjImagePagerAdapter(this); // 你需要创建一个适配器
        adapter.setImageList(images);
        viewPager.setAdapter(adapter);

        startAutoScroll();
    }

    private void startAutoScroll() {
        autoScrollHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                int totalItems = viewPager.getAdapter().getCount();
                int nextPage = (currentItem + 1) % totalItems;
                viewPager.setCurrentItem(nextPage);
                autoScrollHandler.postDelayed(this, 5000);  // 设置自动滑动的时间间隔，这里是3秒
            }
        }, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    private void stopAutoScroll() {
        autoScrollHandler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startAutoScroll();
    }
}
