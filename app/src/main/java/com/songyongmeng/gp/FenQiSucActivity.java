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

public class FenQiSucActivity extends AppCompatActivity {
    List<FenQiSucBean> erBanShangYingXianData;
    FenQiSucAdapter adapter;

    String dataName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);
        int where = 0;
        LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);

        dataName = "fen_qi_suc.json";
        addLayout(buttonLayout);

        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, dataName);
        erBanShangYingXianData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<FenQiSucBean>>() {
        }.getType());

        adapter = new FenQiSucAdapter(erBanShangYingXianData, this);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);
    }

    private void addLayout(LinearLayout buttonLayout) {
        for (int i = 0; i < 20; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 180);
            } else if (i == 19) {
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
                    button.setText("后期高度");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAfterHigh();
                        }
                    });
                    break;
                case 2:
                    button.setText("竞价强度");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeBidStrong();
                        }
                    });
                    break;
                case 3:
                    button.setText("比昨天高开点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeCompareHigh();
                        }
                    });
                    break;
                case 4:
                    button.setText("竞价最后有无买入");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLastHasBuy();
                        }
                    });
                    break;
                case 5:
                    button.setText("与昨日量比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeSelfTurnover();
                        }
                    });
                    break;
                case 6:
                    button.setText("竞价开板时间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeBidBreakTime();
                        }
                    });
                    break;
                case 7:
                    button.setText("最终上板时间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerBanTime();
                        }
                    });
                    break;
                case 8:
                    button.setText("当天开盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerStartData();
                        }
                    });
                    break;
                case 9:
                    button.setText("当天平均点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAveragePoint();
                        }
                    });
                    break;
                case 10:
                    button.setText("昨天与前天成交比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdaySelfTurnover();
                        }
                    });
                    break;
                case 11:
                    button.setText("昨天开盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayStartPoint();
                        }
                    });
                    break;
                case 12:
                    button.setText("昨天平均点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayAveragePoint();
                        }
                    });
                    break;
                case 13:
                    button.setText("第一天大单金额");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFirstDayLargeOrder();
                        }
                    });
                    break;
                case 14:
                    button.setText("昨日大单金额");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayLargeOrder();
                        }
                    });
                    break;
                case 15:
                    button.setText("大单金额");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerLargeOrder();
                        }
                    });
                    break;
                case 16:
                    button.setText("封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLastPriceData();
                        }
                    });
                    break;
                case 17:
                    button.setText("昨日封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayLastPriceData();
                        }
                    });
                    break;
                case 18:
                    button.setText("市值");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAllValue();
                        }
                    });
                    break;
                case 19:
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
