package com.songyongmeng.gp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
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
import com.songyongmeng.gp.utils.OnNewItemClickListener;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthStatisticsActivity extends AppCompatActivity {
    //    ArrayList<NewStatisticsBean> newStatisticsBean;
    MonthStatisticsAdapter adapter;

    String dataName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);
        LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);

        dataName = "new_statistics.json";
        addHeaderButton(buttonLayout);


        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, dataName);

        Map<String, List<NewStatisticsBean>> monthData = groupItemsByMonth(tmp1);


//        newStatisticsBean = new Gson().fromJson(tmp1, new TypeToken<ArrayList<NewStatisticsBean>>() {
//        }.getType());
//
        adapter = new MonthStatisticsAdapter(this, monthData);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnNewItemClickListener() {
            @Override
            public void onItemClick(List<NewStatisticsBean> position) {
                // 处理 item 点击事件
                Intent intent = new Intent(MonthStatisticsActivity.this, NewSumUpListActivity.class);
                intent.putExtra("newSumUpListData", (Serializable) position);
                startActivity(intent);
            }
        });

    }

    private void addHeaderButton(LinearLayout buttonLayout) {
        for (int i = 0; i < 17; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 250);
            } else if (i == 16) {
                layoutParams = new LinearLayout.LayoutParams(970, 250);
            } else {
                layoutParams = new LinearLayout.LayoutParams(180, 250);
            }
            layoutParams.gravity = Gravity.CENTER; // 控制位置
            layoutParams.setMargins(10, 0, 10, 0); // 设置与下方控件的距离为 16 像素
            button.setLayoutParams(layoutParams);
            button.setBackgroundColor(Color.parseColor("#D3D3D3"));
            button.setGravity(Gravity.CENTER);
            switch (i) {
                case 0:
                    button.setText("月份");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.recoverData();
                        }
                    });
                    break;
                case 1:
                    button.setBackgroundColor(Color.parseColor("#00ff00"));
                    button.setText("总次数");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 2:
                    button.setText("胜率");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 3:
                    button.setText("均盈利");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 4:
                    button.setText("均亏损");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 5:
                    button.setText("首板胜率");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 6:
                    button.setText("首板封板率");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 7:
                    button.setText("首板均盈利");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 8:
                    button.setText("首板均亏损");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 9:
                    button.setBackgroundColor(Color.parseColor("#00ff00"));
                    button.setText("二板次数");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeAllTimeData();
                        }
                    });
                    break;
                case 10:
                    button.setText("二板胜率");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeAllTimeData();
                        }
                    });
                    break;
                case 11:
                    button.setText("二板封板率");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeAllTimeData();
                        }
                    });
                    break;
                case 12:
                    button.setText("二板均盈利");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeAllTimeData();
                        }
                    });
                    break;
                case 13:
                    button.setText("二板均亏损");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeAllTimeData();
                        }
                    });
                    break;
                case 14:
                    button.setBackgroundColor(Color.parseColor("#00ff00"));

                    button.setText("中位次数");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeRadioData();
                        }
                    });
                    break;
                case 15:
                    button.setText("中位胜率");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeRadioData();
                        }
                    });
                    break;
                case 16:
                    button.setText("亏损主要原因");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            adapter.changeRadioData();
                        }
                    });
                    break;
            }
            buttonLayout.addView(button);
        }

    }


    public static Map<String, List<NewStatisticsBean>> groupItemsByMonth(String jsonString) {
        Gson gson = new Gson();
        Type itemType = new TypeToken<List<NewStatisticsBean>>() {
        }.getType();
        List<NewStatisticsBean> items = gson.fromJson(jsonString, itemType);

        Map<String, List<NewStatisticsBean>> groupedItems = new HashMap<>();

        for (NewStatisticsBean item : items) {
            try {
                // 解析日期
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(item.getFormerDate());

                // 提取月份
                SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
                String monthKey = monthFormat.format(date);

                // 将项目添加到相应月份的列表中
                List<NewStatisticsBean> monthItems = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    monthItems = groupedItems.getOrDefault(monthKey, new ArrayList<>());
                }
                monthItems.add(item);
                groupedItems.put(monthKey, monthItems);

            } catch (ParseException e) {
                e.printStackTrace();
                // 处理日期解析错误的情况
            }
        }

        // 对月份键进行降序排序


        return groupedItems;
    }


}
