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

public class NewStatisticsActivity extends AppCompatActivity {
    ArrayList<NewStatisticsBean> newStatisticsBean;
    NewStatisticsAdapter adapter;

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
        newStatisticsBean = new Gson().fromJson(tmp1, new TypeToken<ArrayList<NewStatisticsBean>>() {
        }.getType());

        adapter = new NewStatisticsAdapter(this,  newStatisticsBean);
        RecyclerView recyclerView = findViewById(R.id.fen_qi_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(adapter);
    }

    private void addHeaderButton(LinearLayout buttonLayout) {
        for (int i = 0; i < 6; i++) {
            Button button = new Button(this);
            LinearLayout.LayoutParams layoutParams;
            if (i == 0) {
                layoutParams = new LinearLayout.LayoutParams(230, 180);
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
                            adapter.recoverData();
                        }
                    });
                    break;
                case 1:
                    button.setText("共计");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAllTimeData();
                        }
                    });
                    break;
                case 2:
                    button.setText("盈利");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeSucTimeData();
                        }
                    });
                    break;
                case 3:
                    button.setText("占比");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeRadioData();
                        }
                    });
                    break;
                case 4:
                    button.setText("盈平均");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAverageSucData();
                        }
                    });
                    break;
                case 5:
                    button.setText("亏平均");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.changeAverageFaiData();
                        }
                    });
                    break;
            }
            buttonLayout.addView(button);
        }

    }


}
