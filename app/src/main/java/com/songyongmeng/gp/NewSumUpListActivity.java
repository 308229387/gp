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

import com.songyongmeng.gp.utils.NewOnDetailItemClickListener;
import com.songyongmeng.gp.utils.OnDetailItemClickListener;

import java.io.Serializable;
import java.util.ArrayList;

public class NewSumUpListActivity extends AppCompatActivity {
    NewSumUpListAdapter adapter;

    String dataName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);

        Intent intent = getIntent();
        if (getIntent() != null) {
            ArrayList<NewStatisticsBean> receivedList = (ArrayList<NewStatisticsBean>) intent.getSerializableExtra("newSumUpListData");
            LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);
            two(buttonLayout);
            adapter = new NewSumUpListAdapter(receivedList);

            adapter.setOnDetailItemClickListener(new NewOnDetailItemClickListener() {
                @Override
                public void onItemClick(NewStatisticsBean position) {
                    // 处理 item 点击事件
                    Intent intent = new Intent(NewSumUpListActivity.this,NewGPDetailActivity.class);
                    intent.putExtra("gpDetailData", (Serializable) position);
                    startActivity(intent);
                }
            });

            RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
            recyclerView.setAdapter(adapter);
        }
    }

    private void two(LinearLayout buttonLayout) {
        for (int i = 0; i < 6; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 180);
            } else if (i == 5) {
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
                            adapter.recoverFenQiData();
                        }
                    });
                    break;
                case 1:
                    button.setText("盈利点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeResultPoint();
                        }
                    });
                    break;
                case 2:
                    button.setText("模式");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeMode();
                        }
                    });
                    break;
                case 3:
                    button.setText("收盘是否涨停");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeIsHasBan();
                        }
                    });
                    break;
                case 4:
                    button.setText("封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLastPriceData();
                        }
                    });
                    break;
                case 5:
                    button.setText("买入日期");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerDate();
                        }
                    });
                    break;
//                case 5:
//                    button.setText("当日最高点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeFormerTopData();
//                        }
//                    });
//                    break;
//                case 6:
//                    button.setText("当日最低点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeFormerLowData();
//                        }
//                    });
//                    break;
//                case 7:
//                    button.setText("当日收盘点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeFormerEndPointData();
//                        }
//                    });
//                    break;
//                case 8:
//                    button.setText("当日平均点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeFormerAveragePointData();
//                        }
//                    });
//                    break;
//                case 9:
//                    button.setText("次日开盘点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeLatterStartPointData();
//                        }
//                    });
//                    break;
//
//                case 10:
//                    button.setText("次日最高点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeLatterTopPointData();
//                        }
//                    });
//                    break;
//                case 11:
//                    button.setText("次日最低点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeLatterLowPoint();
//                        }
//                    });
//                    break;
//                case 12:
//                    button.setText("次日收盘点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeLatterEndPoint();
//                        }
//                    });
//                    break;
//                case 13:
//                    button.setText("次日平均点位");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeLatterAverageData();
//                        }
//                    });
//                    break;
//                case 14:
//                    button.setText("后期空间");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeAfterHigh();
//                        }
//                    });
//                    break;
//
//                case 15:
//                    button.setText("昨天封单");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeLastPriceData();
//                        }
//                    });
//                    break;
//                case 16:
//                    button.setText("流通市值");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeFormerAllValue();
//                        }
//                    });
//                    break;
//                case 17:
//                    button.setText("当天日期");
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            adapter.changeFormerDate();
//                        }
//                    });
//                    break;
            }
            buttonLayout.addView(button);
        }

    }


}
