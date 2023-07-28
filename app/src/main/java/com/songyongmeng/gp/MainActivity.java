package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.Hawk;
import com.songyongmeng.gp.dialog.RememberDialog;
import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.SPManager;
import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainBean> allData;
    ArrayList<StatisticsBean> statisticsData;
    boolean allOpenTag = false;
    FrameLayout personDetail;
    FrameLayout clear;
    ExpandableListView expandListId;
    MainListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utility.setActionBar(this);
        personDetail = findViewById(R.id.person_detail);
        expandListId = findViewById(R.id.expand_list_id);
        clear = findViewById(R.id.clear);

        AssetsUtils assetsUtils = new AssetsUtils();
        String name = "all_data.json";
        String tmp = assetsUtils.readAssetsText(this, name);
        allData = new Gson().fromJson(tmp, new TypeToken<ArrayList<MainBean>>() {
        }.getType());

        String statisticsName = "statistics.json";
        String tmp1 = assetsUtils.readAssetsText(this, statisticsName);
        statisticsData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<StatisticsBean>>() {
        }.getType());

        initView();

    }

    private void initView() {
        personDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allOpenTag) {
                    for (int i = 0; i < allData.size(); i++) {
                        expandListId.expandGroup(i);
                    }
                    allOpenTag = false;
                } else {
                    for (int i = 0; i < allData.size(); i++) {
                        expandListId.collapseGroup(i);
                    }
                    allOpenTag = true;
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RememberDialog dialog = new RememberDialog(MainActivity.this, "是否要清除全部状态");
                dialog.setListener(new RememberDialog.RememberDialogCallBack() {
                    @Override
                    public void result() {
                        Hawk.deleteAll();
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }

                    @Override
                    public void cancel() {
                        dialog.dismiss();
                    }
                }).show();
            }
        });

        adapter = new MainListAdapter(this, allData);
        expandListId.setAdapter(adapter);

        for (int i = 0; i < allData.size(); i++) {
            expandListId.expandGroup(i);
        }

        expandListId.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                return false;
            }
        });

        expandListId.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:概率总结")) {
                    toStatistics(statisticsData);
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:卖出决策器")) {
                    toSell();
                }else if(allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:分歧转一致")){
                    toFenQi();
                }else {
                    toDetail((ArrayList<String>) allData.get(groupPosition).getData().get(childPosition).getRichText());

                }
                return true;
            }
        });


    }


    private void toFenQi() {
        Intent intent = new Intent(MainActivity.this, FenQiActivity.class);
        startActivity(intent);
    }
    private void toDetail(ArrayList<String> imageList) {
        Intent intent = new Intent(MainActivity.this, QADetailActivity.class);
        intent.putStringArrayListExtra("imageList", imageList);
        startActivity(intent);
    }

    private void toStatistics(ArrayList<StatisticsBean> allStatistics) {
        Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
        intent.putExtra("statistics", allStatistics);
        startActivity(intent);
    }

    private void toSell() {
        Intent intent = new Intent(MainActivity.this, SellActivity.class);
        startActivity(intent);
    }
}