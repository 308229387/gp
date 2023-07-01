package com.songyongmeng.gp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;

public class QADetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_a_detail_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);
        if (getIntent() != null) {
            if(null!= getIntent().getStringArrayListExtra("imageList")){
                ArrayList<String> imageList = getIntent().getStringArrayListExtra("imageList");
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
                recyclerView.setAdapter(new MyAdapter(imageList)); // 设置适配器
            }

        }
    }
}
