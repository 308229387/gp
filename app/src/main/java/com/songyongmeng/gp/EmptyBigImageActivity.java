package com.songyongmeng.gp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.utils.AssetsUtils;

public class EmptyBigImageActivity extends Activity {
    BigImageListBean imageList;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new StatusBar(this).hide();
        setContentView(R.layout.image_pagerl_layout);


        Intent intent = getIntent();
        name = intent.getStringExtra("image_list");

        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, name);
        imageList = new Gson().fromJson(tmp1, new TypeToken<BigImageListBean>() {
        }.getType());

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(this); // 你需要创建一个适配器
        adapter.setImageList(imageList.getImage_list());
        viewPager.setAdapter(adapter);
    }
}
