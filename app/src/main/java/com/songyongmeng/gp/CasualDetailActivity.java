package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class CasualDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt_detail_layout);

        Intent intent = getIntent();
        LTBean data = (LTBean) intent.getSerializableExtra("ltDetailData");
        List<String> images = data.getLt_image_list();
//        Glide.with(this).load(id).into((ImageView) findViewById(R.id.gp_detail_image_view));

        TextView name = findViewById(R.id.lt_name);
        TextView reason = findViewById(R.id.lt_buy_reason);
        name.setText("股票名称： " + data.getLtName());
        reason.setText("描述： " + data.getLtReason());

        ViewPager viewPager = findViewById(R.id.lt_view_pager);
        MyPagerAdapter adapter = new MyPagerAdapter(this); // 你需要创建一个适配器
        adapter.setImageList(images);
        viewPager.setAdapter(adapter);
    }
}
