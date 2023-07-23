package com.songyongmeng.gp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(180, 300);
            layoutParams.gravity = Gravity.CENTER; // 控制位置
            layoutParams.setMargins(10, 10, 10, 10); // 设置与下方控件的距离为 16 像素
            button.setLayoutParams(layoutParams);
            button.setBackgroundColor(Color.parseColor("#D3D3D3"));
            button.setGravity(Gravity.CENTER);

            switch (i) {
                case 0:
                    button.setText("恢复");
                    break;
                case 1:
                    button.setText("当天上板时间");
                    break;
                case 2:
                    button.setText("当天最终封单(亿)");
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
