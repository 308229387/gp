package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.GridSpacingItemDecoration;
import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);


        Intent intent = getIntent();

        if (getIntent() != null) {
            ArrayList<StatisticsBean> receivedList = (ArrayList<StatisticsBean>) intent.getSerializableExtra("statistics");
            if (receivedList != null) {
                RecyclerView recyclerView = findViewById(R.id.statistics_grid);
                recyclerView.setLayoutManager(new GridLayoutManager(this, 4 )); // 设置布局管理器
                recyclerView.setAdapter(new GridAdapter(this, receivedList)); // 设置适配器
                // 处理接收到的对象 bean 列表

            }
        }
    }
}
