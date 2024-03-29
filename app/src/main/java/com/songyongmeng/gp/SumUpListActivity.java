package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.songyongmeng.gp.utils.OnDetailItemClickListener;
import com.songyongmeng.gp.utils.OnItemClickListener;
import com.songyongmeng.gp.utils.Utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SumUpListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sum_up_list_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);
        Intent intent = getIntent();
        if (getIntent() != null) {
            ArrayList<StatisticsBean> receivedList = (ArrayList<StatisticsBean>) intent.getSerializableExtra("sumUpListData");
            if (receivedList != null) {
                SumUpListAdapter detailAdapter = new SumUpListAdapter(receivedList);
                RecyclerView recyclerView = findViewById(R.id.sum_up_list);
                RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(verticalLayoutManager);

                recyclerView.setAdapter(detailAdapter);

                detailAdapter.setOnDetailItemClickListener(new OnDetailItemClickListener() {
                    @Override
                    public void onItemClick(StatisticsBean position) {
                        // 处理 item 点击事件
                        Intent intent = new Intent(SumUpListActivity.this,GPDetailActivity.class);
                        intent.putExtra("gpDetailData", (Serializable) position);
                        startActivity(intent);
                    }
                });

                findViewById(R.id.sum_recover_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailAdapter.recoverData();
                    }
                });

                findViewById(R.id.sum_self_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailAdapter.changeSelfData();
                    }
                });
                findViewById(R.id.sum_result_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailAdapter.changeResultData();
                    }
                });
                findViewById(R.id.sum_sell_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailAdapter.changeSellData();
                    }
                });
                findViewById(R.id.sum_turnover_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailAdapter.changeTurnoverData();
                    }
                });
                findViewById(R.id.sum_buy_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailAdapter.changeBuyPointData();
                    }
                });
            }
        }
    }
}
