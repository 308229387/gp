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
import com.songyongmeng.gp.utils.SPManager;

import java.util.ArrayList;
import java.util.List;

public class FenQiActivity extends AppCompatActivity {
    List<FenQiBean> fenQiData;
    FenQiAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);

        LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);
        for (int i = 0; i < 30; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 180);
            } else if (i == 28) {
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
                    button.setText("当天最终封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLastPriceData();
                        }
                    });
                    break;
                case 3:
                    button.setText("当天版块点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerGroupPoint();
                        }
                    });
                    break;
                case 4:
                    button.setText("当日均线点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAveragePointData();
                        }
                    });
                    break;
                case 5:
                    button.setText("当日开盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerStartData();
                        }
                    });
                    break;

                case 6:
                    button.setText("次日开盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterStartPointData();
                        }
                    });
                    break;
                case 7:
                    button.setText("次日平均点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterAverageData();
                        }
                    });
                    break;
                case 8:
                    button.setText("次日最高点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterTopPointData();
                        }
                    });
                    break;
                case 9:
                    button.setText("最高点出现时间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLastTopPointTimeData();
                        }
                    });
                    break;
                case 10:
                    button.setText("首次上板量与前一天对比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeWhenWillFirstBanTurnover();
                        }
                    });
                    break;
                case 11:
                    button.setText("是否有前高");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeHasBeforeTop();
                        }
                    });
                    break;
                case 12:
                    button.setText("前一天量与大前天对比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdaySelfTurnover();
                        }
                    });
                    break;
                case 13:
                    button.setText("昨天涨停板质量分数");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdaySelfBanScoreData();
                        }
                    });
                    break;
                case 14:
                    button.setText("次日最低点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterLowPoint();
                        }
                    });
                    break;
                case 15:
                    button.setText("次日最低点位出现时间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterLowPointTime();
                        }
                    });
                    break;
                case 16:
                    button.setText("后期空间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAfterHigh();
                        }
                    });
                    break;
                case 17:
                    button.setText("昨日环境分");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayEnvironmentScore();
                        }
                    });
                    break;
                case 18:
                    button.setText("当日环境分");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeEnvironmentScore();
                        }
                    });
                    break;
                case 19:
                    button.setText("是否开板过");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeHasOpenData();
                        }
                    });
                    break;
                case 20:
                    button.setText("当日收盘点位");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerEndPointData();
                        }
                    });
                    break;

                case 21:
                    button.setText("开盘就拉升");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeLatterStartPullUpData();
                        }
                    });
                    break;
                case 22:
                    button.setText("是否有高级别均线压制");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeHasHighLevelLinePin();
                        }
                    });
                    break;
                case 23:
                    button.setText("当天上板时间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerBanTime();
                        }
                    });
                    break;


                case 24:
                    button.setText("前一天股票几板");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdaySelfBanNum();
                        }
                    });
                    break;

                case 25:
                    button.setText("前一天市场有几个涨停");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayAllBanNum();
                        }
                    });
                    break;
                case 26:
                    button.setText("前一天最高板");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayAllTopBanNum();
                        }
                    });
                    break;
                case 27:
                    button.setText("流通市值");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerAllValue();
                        }
                    });
                    break;
                case 28:
                    button.setText("当天日期");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeFormerDate();
                        }
                    });
                    break;
                case 29:
                    button.setText("昨日封单");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeYesterdayLastPrice();
                        }
                    });
                    break;


            }
            buttonLayout.addView(button);
        }

        AssetsUtils assetsUtils = new AssetsUtils();
        String statisticsName = "fen_qi.json";
        String tmp1 = assetsUtils.readAssetsText(this, statisticsName);
        fenQiData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<FenQiBean>>() {
        }.getType());

        adapter = new FenQiAdapter(fenQiData);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);

        calculateSelfTurnover();

    }


    private void calculateSelfTurnover() {
        String result = "";
        long selfTurnover = fenQiData.stream()
                .filter(bean -> {
                    return bean.getSelfTurnover() < 70;
                })
                .count();

        long selfTurnoverSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getSelfTurnover() < 70 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();

        long selfOtherTurnoverSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getSelfTurnover() > 70 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        double tmp = (double) (selfTurnoverSuc / selfTurnover * 100);
        double tmp1 = (double) (selfOtherTurnoverSuc / (double) (fenQiData.size()-selfTurnover) * 100);

        SPManager.getInstance(FenQiActivity.this).setValue(SPManager.ALL_DATA_SIZE, fenQiData.size() + "");
        String text1 = "从23年6月起统计，所有二三板分歧转一致交易共"+fenQiData.size()+"条<br><br>";
        String text2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color='red'>"  +"分歧转一致的核心就是上升过程中缩量，所以当天的量能一定要小于昨日。"+ "</font></b>";
        String text3 = "其中个股当天量对比昨天小于70%的共"+selfTurnover+"支，当天封板且次日均线点位大于0%的有"+selfTurnoverSuc+"支，概率为 <font color='black'>" + tmp +"%"+ "</font>"+"，";
        String text4 = "大于70%的共"+(fenQiData.size()-selfTurnover)+"支，当天封板且次日均线点位大于0%的有"+selfOtherTurnoverSuc+"支，概率为<font color='black'>" + tmp1 +"%"+ "</font>";
        result = text1+text2+text3+text4;
        SPManager.getInstance(FenQiActivity.this).setValue(SPManager.SELF_TURNOVER, result );
    }
}
