package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.songyongmeng.gp.utils.AssetsUtils;

import java.util.List;

public class FenQiSucDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_detail_layout);

        Intent intent = getIntent();
        FenQiSucBean data = (FenQiSucBean) intent.getSerializableExtra("data");
        List<String> images = data.getImage_list();

        TextView name = findViewById(R.id.gp_name);
        TextView result = findViewById(R.id.result_point);
        TextView reason = findViewById(R.id.buy_reason);
        TextView last = findViewById(R.id.gp_last_price);
        name.setText("股票名称： "+data.getGpName());
//        result.setText("获利： "+data.getResultPoint() + "%");
        last.setText(data.getLastPrice()==0?"未涨停":"封单: "+data.getLastPrice()+"亿");
//        reason.setText("购买原因： "+data.getBuyReason());
        ViewPager viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter adapter = new MyPagerAdapter(this); // 你需要创建一个适配器
        adapter.setImageList(images);
        adapter.setPath(Constants.COMMON_IMG_NAME);
        viewPager.setAdapter(adapter);
    }
}
