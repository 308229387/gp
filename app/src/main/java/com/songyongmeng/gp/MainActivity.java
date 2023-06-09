package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.Hawk;
import com.songyongmeng.gp.dialog.RememberDialog;
import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainBean> allData;
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
                toDetail((ArrayList<String>) allData.get(groupPosition).getData().get(childPosition).getRichText());
                return true;
            }
        });


    }

    private void toDetail( ArrayList<String> imageList) {
        Intent intent = new Intent(MainActivity.this, QADetailActivity.class);
        intent.putStringArrayListExtra("imageList", imageList);
        startActivity(intent);
    }
}