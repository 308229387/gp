package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.songyongmeng.gp.utils.OnItemClickListener;
import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    Button allTimeBtn;
    Button sucTimeBtn;
    Button radioBtn;
    StatisticsAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);

        allTimeBtn = findViewById(R.id.all_time_btn);
        sucTimeBtn = findViewById(R.id.suc_time_btn);
        radioBtn = findViewById(R.id.radio_btn);

        allTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAllTimeData();
            }
        });

        sucTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeSucTimeData();
            }
        });

        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeRadioData();
            }
        });
        findViewById(R.id.average_suc_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAverageSucData();
            }
        });
        findViewById(R.id.average_fai_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAverageFaiData();
            }
        });
        findViewById(R.id.recover_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.recoverData();
            }
        });


        Intent intent = getIntent();

        if (getIntent() != null) {
            ArrayList<StatisticsBean> receivedList = (ArrayList<StatisticsBean>) intent.getSerializableExtra("statistics");
            if (receivedList != null) {
                adapter = new StatisticsAdapter(this,receivedList);

                RecyclerView recyclerView = findViewById(R.id.statistics_grid);
                recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
                recyclerView.setAdapter(adapter); // 设置适配器
                // 处理接收到的对象 bean 列表
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(List<StatisticsBean> position) {
                        // 处理 item 点击事件
                        Toast.makeText(StatisticsActivity.this,new Gson().toJson(position),Toast.LENGTH_LONG).show();
                    }
                });

            }
        }
    }

}
