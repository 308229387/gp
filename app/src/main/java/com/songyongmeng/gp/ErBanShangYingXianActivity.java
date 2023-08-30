package com.songyongmeng.gp;

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

import java.util.ArrayList;
import java.util.List;

public class ErBanShangYingXianActivity extends AppCompatActivity {
    List<ErBanShangYingXianBean> erBanShangYingXianData;
    ErBanShangYingXianAdapter adapter;

    String dataName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);
        int where = 0;
        LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);

//        if (getIntent().getStringExtra("from").equals("3")) {
        dataName = "shang_ying_xian.json";
//        } else if (getIntent().getStringExtra("from").equals("2")) {
//            dataName = "er_ban.json";
        two(buttonLayout);
//            where = 2;
//        }


        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, dataName);
        erBanShangYingXianData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<ErBanShangYingXianBean>>() {
        }.getType());

        adapter = new ErBanShangYingXianAdapter(erBanShangYingXianData);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);
    }

    private void two(LinearLayout buttonLayout) {
        for (int i = 0; i < 18; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 180);
            } else if (i == 17) {
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
                    button.setText("个股量能比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeSelfTurnover();
                        }
                    });
                    break;
                case 2:
                    button.setText("前一天量与大前天对比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdaySelfTurnover();
                        }
                    });
                    break;
                case 3:
                    button.setText("高点在上下午");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAmPm();
                        }
                    });
                    break;
                case 4:
                    button.setText("当日开盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerStartData();
                        }
                    });
                    break;
                case 5:
                    button.setText("当日最高点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerTopData();
                        }
                    });
                    break;
                case 6:
                    button.setText("当日最低点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerLowData();
                        }
                    });
                    break;
                case 7:
                    button.setText("当日收盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerEndPointData();
                        }
                    });
                    break;
                case 8:
                    button.setText("当日平均点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAveragePointData();
                        }
                    });
                    break;
                case 9:
                    button.setText("次日开盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterStartPointData();
                        }
                    });
                    break;

                case 10:
                    button.setText("次日最高点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterTopPointData();
                        }
                    });
                    break;
                case 11:
                    button.setText("次日最低点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterLowPoint();
                        }
                    });
                    break;
                case 12:
                    button.setText("次日收盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterEndPoint();
                        }
                    });
                    break;
                case 13:
                    button.setText("次日平均点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterAverageData();
                        }
                    });
                    break;
                case 14:
                    button.setText("后期空间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAfterHigh();
                        }
                    });
                    break;

                case 15:
                    button.setText("昨天封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLastPriceData();
                        }
                    });
                    break;
                case 16:
                    button.setText("流通市值");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAllValue();
                        }
                    });
                    break;
                case 17:
                    button.setText("当天日期");
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
