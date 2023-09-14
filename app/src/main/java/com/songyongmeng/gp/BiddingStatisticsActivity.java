package com.songyongmeng.gp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.utils.AssetsUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class BiddingStatisticsActivity extends AppCompatActivity {
    ArrayList<BiddingStatisticsBean> bean;
    BiddingStatisticsAdapter adapter;

    String dataName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);
        LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);

        dataName = "bidding_statistics.json";
        addHeaderButton(buttonLayout);


        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, dataName);
        bean = new Gson().fromJson(tmp1, new TypeToken<ArrayList<BiddingStatisticsBean>>() {
        }.getType());

        adapter = new BiddingStatisticsAdapter(this, bean);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnBiddingItemClickListener() {
            @Override
            public void onItemClick(BiddingStatisticsBean position) {
                // 处理 item 点击事件
//                Intent intent = new Intent(BiddingStatisticsActivity.this, NewSumUpListActivity.class);
//                intent.putExtra("newSumUpListData", (Serializable) position);
//                startActivity(intent);
            }
        });

    }

    private void addHeaderButton(LinearLayout buttonLayout) {
        for (int i = 0; i < 7; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 180);
            } else if (i == 6) {
                layoutParams = new LinearLayout.LayoutParams(260, 180);
            } else {
                layoutParams = new LinearLayout.LayoutParams(210, 180);
            }
            layoutParams.gravity = Gravity.CENTER; // 控制位置
            layoutParams.setMargins(10, 10, 10, 10); // 设置与下方控件的距离为 16 像素
            button.setLayoutParams(layoutParams);
            button.setBackgroundColor(Color.parseColor("#D3D3D3"));
            button.setGravity(Gravity.CENTER);
            switch (i) {
                case 0:
                    button.setText("恢复");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.recoverData();
                        }
                    });
                    break;
                case 1:
                    button.setText("后期涨幅");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAfterHigh();
                        }
                    });
                    break;
                case 2:
                    button.setText("昨日封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayLastPriceData();
                        }
                    });
                    break;
                case 3:
                    button.setText("板质量");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeDescription();
                        }
                    });
                    break;
                case 4:
                    button.setText("几板");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeRadioData();
                        }
                    });
                    break;
                case 5:
                    button.setText("涨停几cm");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeBanData();
                        }
                    });
                    break;
                case 6:
                    button.setText("日期");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerDate();
                        }
                    });
                    break;

            }
            buttonLayout.addView(button);
        }

    }


}
