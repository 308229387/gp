package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class SellActivity extends AppCompatActivity {
    TextView textView;
    List<FenQiBean> fenQiData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);
        textView = findViewById(R.id.ji_sun_result);

        AssetsUtils assetsUtils = new AssetsUtils();
        String statisticsName = "fen_qi.json";
        String tmp1 = assetsUtils.readAssetsText(this, statisticsName);
        fenQiData = new Gson().fromJson(tmp1, new TypeToken<ArrayList<FenQiBean>>() {
        }.getType());
        calculateSelfTurnover();
    }


    private void calculateSelfTurnover() {
        String result = "";
        long selfTurnover = fenQiData.stream()
                .filter(bean -> {
                    return bean.getSelfTurnover() < 70;
                })
                .count();

        long selfTurnoverSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getSelfTurnover() < 70 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();

        long selfOtherTurnoverSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getSelfTurnover() > 70 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp = (selfTurnoverSuc * 100) / selfTurnover;

        long tmp1 = (selfOtherTurnoverSuc * 100) / (fenQiData.size() - selfTurnover);

        String text1 = "从23年6月起统计，所有二三板分歧转一致交易共" + fenQiData.size() + "条<br><br>";
        String text2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分歧转一致的核心就是持股人不愿意卖，而买方强劲，从而出现股价上升过程中缩量，<b><font color='red'>" + "所以当天的量能一定要小于昨日，边界值为70%。" + "</font></b>";
        String text3 = "其中个股当天量对比昨天小于70%的共" + selfTurnover + "支，当天封板且次日均线点位大于0%的有" + selfTurnoverSuc + "支，概率为 <b><font color='black'>" + tmp + "%</font></b>" + "，";
        String text4 = "大于70%的共" + (fenQiData.size() - selfTurnover) + "支，当天封板且次日均线点位大于0%的有" + selfOtherTurnoverSuc + "支，概率为<b><font color='black'>" + tmp1 + "%" + "</font></b><br><br>";

        long groupPoint = fenQiData.stream()
                .filter(bean -> {
                    return bean.getFormerGroupPoint() > 1;
                })
                .count();
        long groupPointSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getFormerGroupPoint() > 1 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp2 = (groupPointSuc * 100) / groupPoint;


        String text5 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版块的大涨会形成团体效应，给投资者带来更强的信心，所以<b><font color='red'>" + "当天版块大涨超过1%，会极大增加成功率。" + "</font></b>";
        String text6 = "当天版块大于1%的共有" + groupPoint + "个，当天封板且次日均线点位大于0%的有" + groupPointSuc + "个，概率为" + "<b><font color='black'>" + tmp2 + "%</font></b>，";

        long groupPointOther = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getFormerGroupPoint() > 1);
                })
                .count();

        long groupPointOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getFormerGroupPoint() > 1) && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp3 = (groupPointOtherSuc * 100) / groupPointOther;
        String text7 = "当天版块小于等于1%的共有" + groupPointOther + "个，当天封板且次日均线点位大于0%的有" + groupPointOtherSuc + "个，概率为" + "<b><font color='black'>" + tmp3 + "%</font></b><br><br>";

        long lastPrice = fenQiData.stream()
                .filter(bean -> {
                    return (bean.getLastPrice() > 0.5);
                })
                .count();
        long lastPriceSuc = fenQiData.stream()
                .filter(bean -> {
                    return (bean.getLastPrice() > 0.5 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0);
                })
                .count();
        long tmp4 = (lastPriceSuc * 100) / lastPrice;
        String text8 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当日封单代表资金做票的决心强弱，所以<b><font color='red'>" + "当天封单超过五千万，第二天赢面很大。" + "</font></b>";
        String text9 = "个股当天封单大于5000万的共" + lastPrice + "支，当天封板且次日均线点位大于0%的有" + lastPriceSuc + "支，概率为 <b><font color='black'>" + tmp4 + "%</font></b>" + "，";


        long lastPriceOther = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getLastPrice() > 0.5);
                })
                .count();
        long lastPriceOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getLastPrice() > 0.5) && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp5 = (lastPriceOtherSuc * 100) / lastPriceOther;
        String text10 = "个股当天封单小于等于5000万的共" + lastPriceOther + "支，当天封板且次日均线点位大于0%的有" + lastPriceOtherSuc + "支，概率为 <b><font color='black'>" + tmp5 + "%</font></b>" ;


        result = text1 + text2 + text3 + text4 + text5 + text6 + text7 + text8 + text9 + text10;
        textView.setText(Html.fromHtml(result));
    }
}
