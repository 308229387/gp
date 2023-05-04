package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainBean> allData;
    boolean allOpenTag = false;
    FrameLayout personDetail;
    ExpandableListView expandListId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personDetail = findViewById(R.id.person_detail);
        expandListId = findViewById(R.id.expand_list_id);

        AssetsUtils assetsUtils = new AssetsUtils();
        String name = "all_data.json";
        String tmp = assetsUtils.readAssetsText(this, name);
        allData = new Gson().fromJson(tmp, new TypeToken<ArrayList<MainBean>>() {
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

        MainListAdapter adapter = new MainListAdapter(this, allData);
        expandListId.setAdapter(adapter);

        //默认展开第一个数组
        expandListId.expandGroup(0);

        expandListId.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                return false;
            }
        });

        expandListId.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                toDetail(allData.get(groupPosition).getData().get(childPosition).getTitle(), allData.get(groupPosition).getData().get(childPosition).getContent(), allData.get(groupPosition).getData().get(childPosition).getImage());
                return true;
            }
        });



    }
    private void toDetail(String title, String content, String image) {
        Intent intent = new Intent(MainActivity.this, QADetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("answer", content);
        intent.putExtra("image", image);
        startActivity(intent);
    }
}