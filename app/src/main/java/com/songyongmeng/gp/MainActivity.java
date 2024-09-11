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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:新概率总结")) {
                    toNewStatistics();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:按月份概率总结")) {
                    toMonthStatistics();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:数据分析")) {
                    toSell();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:分歧转一致")) {
                    toFenQi();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:打二板")) {
                    toFenQiEr();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:二板分歧转一至 K 线形态")) {
                    toErBanFenQiBigImage();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:二板上影线")) {
                    toShangYing();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:分歧转一致成功样例")) {
                    toFenQiSuc();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:分歧转一致 K 线集合")) {
                    toFenQiSucK();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:统计有量竞价")) {
                    toBidding();
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:高手近期学习")) {
                    toSeeImage(Constants.YESTODAY_IMG);
                }else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:北京炒家总集")) {
                    toSeeImage(Constants.BJCJ_IMG);
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:一字板")) {
                    toSeeImage(Constants.YZB_IMG);
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:竞价抢筹成功")) {
                    toBigImage("jing_jia_qiang_chou_suc.json");
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:竞价抢筹失败")) {
                    toBigImage("jing_jia_qiang_chou_fail.json");
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:竞价横盘形态")) {
                    toBigImage("jing_jia_heng_pan.json");
                } else if (allData.get(groupPosition).getData().get(childPosition).getRichText().get(0).equals("title:心得小记")) {
                    startActivity(new Intent(MainActivity.this, CasualListActivity.class));
                } else {
                    toDetail((ArrayList<String>) allData.get(groupPosition).getData().get(childPosition).getRichText());
                }
                return true;
            }
        });

    }

    private void toSeeImage(String str) {
        Intent intent = new Intent(MainActivity.this, BjcjImageActivity.class);
        if(str.equals(Constants.YESTODAY_IMG)){
            intent.putExtra("path",Constants.YESTODAY_IMG);
            intent.putExtra("random",1);
        }if(str.equals(Constants.BJCJ_IMG)){
            intent.putExtra("path",Constants.BJCJ_IMG);
            intent.putExtra("random",0);
        }else if(str.equals(Constants.YZB_IMG)){
            intent.putExtra("path",Constants.YZB_IMG);
            intent.putExtra("random",0);
        }
        startActivity(intent);
    }

    private void toBigImage(String str) {
        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, str);
        BigImageListBean bean = new Gson().fromJson(tmp1, new TypeToken<BigImageListBean>() {
        }.getType());

        List<String> list = bean.getImage_list();

        Intent intent;
        if(str.contains("bei_jing_chao_jia")){
            intent = new Intent(MainActivity.this, BjcjImageActivity.class);
        }else{
            intent = new Intent(MainActivity.this, EmptyBigImageActivity.class);
        }
        intent.putExtra("image_list", (Serializable) list);
        startActivity(intent);
    }

    private void toErBanFenQiBigImage() {
        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, "er_ban_fen_qi.json");
        BigImageListBean bean = new Gson().fromJson(tmp1, new TypeToken<BigImageListBean>() {
        }.getType());

        List<String> list = bean.getImage_list();

        Intent intent = new Intent(MainActivity.this, EmptyBigImageActivity.class);
        intent.putExtra("image_list", (Serializable) list);
        startActivity(intent);
    }

    private void toNewStatistics() {
        Intent intent = new Intent(MainActivity.this, NewStatisticsActivity.class);
        startActivity(intent);
    }

    private void toMonthStatistics() {
        Intent intent = new Intent(MainActivity.this, MonthStatisticsActivity.class);
        startActivity(intent);
    }


    private void toFenQiEr() {
        Intent intent = new Intent(MainActivity.this, FenQiActivity.class);
        intent.putExtra("from", "2");
        startActivity(intent);
    }

    private void toShangYing() {
        Intent intent = new Intent(MainActivity.this, ErBanShangYingXianActivity.class);
        startActivity(intent);
    }

    private void toFenQiSuc() {
        Intent intent = new Intent(MainActivity.this, FenQiSucActivity.class);
        startActivity(intent);
    }

    private void toFenQiSucK() {
        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, "fen_qi_suc.json");
        List<FenQiSucBean> erBanShangYingXianData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<FenQiSucBean>>() {
        }.getType());
        List<String> list = new ArrayList<>();
        for (FenQiSucBean tmp : erBanShangYingXianData) {
            list.add(tmp.getImage_list().get(0));
        }

        Intent intent = new Intent(MainActivity.this, EmptyBigImageActivity.class);
        intent.putExtra("image_list", (Serializable) list);
        startActivity(intent);
    }

    private void toBidding() {
        Intent intent = new Intent(MainActivity.this, BiddingStatisticsActivity.class);
        startActivity(intent);
    }

    private void toFenQi() {
        Intent intent = new Intent(MainActivity.this, FenQiActivity.class);
        intent.putExtra("from", "3");
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