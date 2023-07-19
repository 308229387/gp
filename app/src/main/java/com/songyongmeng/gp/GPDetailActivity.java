package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.songyongmeng.gp.utils.ToolUtils;

import java.util.ArrayList;

public class GPDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gp_detail_layout);
        Intent intent = getIntent();
        StatisticsBean data = (StatisticsBean) intent.getSerializableExtra("gpDetailData");
        int id = ToolUtils.getImages(data.getImage());
        Glide.with(this).load(id).into((ImageView) findViewById(R.id.gp_detail_image_view));

    }
}
