package com.songyongmeng.gp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;

public class FenQiActivity extends AppCompatActivity {
    List<FenQiBean> fenQiData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_qi_layout);

        LinearLayout buttonLayout = findViewById(R.id.fen_qi_top_button_layout);
        for (int i = 0; i < 26; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if(i ==25){
                layoutParams = new LinearLayout.LayoutParams(260, 300);

            }else{
                layoutParams = new LinearLayout.LayoutParams(180, 300);

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
                            Toast.makeText(FenQiActivity.this,"恢复",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case 1:
                    button.setText("当天上板时间");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(FenQiActivity.this,"当天上板时间",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case 2:
                    button.setText("当天最终封单(亿)");
                    break;
                case 3:
                    button.setText("是否开板过");
                    break;
                case 4:
                    button.setText("当天开盘点位");
                    break;
                case 5:
                    button.setText("次日开盘点位");
                    break;
                case 6:
                    button.setText("开盘就拉升");
                    break;
                case 7:
                    button.setText("次日最高点位");
                    break;
                case 8:
                    button.setText("最高点出现时间");
                    break;
                case 9:
                    button.setText("次日平均点位");
                    break;
                case 10:
                    button.setText("次日最低点位");
                    break;
                case 11:
                    button.setText("次日最低点位出现时间");
                    break;
                case 12:
                    button.setText("后期空间");
                    break;
                case 13:
                    button.setText("当天版块点位");
                    break;
                case 14:
                    button.setText("当天版块量与前天对比");
                    break;
                case 15:
                    button.setText("是否有前高");
                    break;
                case 16:
                    button.setText("是否有高级别均线压制");
                    break;
                case 17:
                    button.setText("股票当天量与前一天对比");
                    break;
                case 18:
                    button.setText("前一天量与大前天对比");
                    break;
                case 19:
                    button.setText("前一天市场量与大前天对比");
                    break;
                case 20:
                    button.setText("前一天股票几板");
                    break;
                case 21:
                    button.setText("前一天市场有几个涨停");
                    break;
                case 22:
                    button.setText("前一天最高板");
                    break;
                case 23:
                    button.setText("当天市场量能与前一天对比");
                    break;
                case 24:
                    button.setText("流通市场");
                    break;
                case 25:
                    button.setText("当天日期");
                    break;

            }
            buttonLayout.addView(button);
        }

        AssetsUtils assetsUtils = new AssetsUtils();
        String statisticsName = "fen_qi.json";
        String tmp1 = assetsUtils.readAssetsText(this, statisticsName);
        fenQiData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<FenQiBean>>() {
        }.getType());

        FenQiAdapter adapter = new FenQiAdapter(fenQiData);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);

    }
}
