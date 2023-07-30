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

        String text1 = "最近统计二三板分歧转一致交易共" + fenQiData.size() + "条<br><br>";
        String text2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分歧转一致的核心就是持股人不愿意卖，而买方不断想买，从而出现股价上升过程中缩量，<b><font color='red'>" + "所以当天的量能一定要小于昨日，边界值为70%。" + "</font></b>";
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
                    return (bean.getLastPrice() > 0.4);
                })
                .count();
        long lastPriceSuc = fenQiData.stream()
                .filter(bean -> {
                    return (bean.getLastPrice() > 0.4 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0);
                })
                .count();
        long tmp4 = (lastPriceSuc * 100) / lastPrice;
        String text8 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当日封单代表资金对次日预期的强弱，所以<b><font color='red'>" + "当天封单超过四千万，第二天赢面很大。" + "</font></b>";
        String text9 = "个股当天封单大于5000万的共" + lastPrice + "支，当天封板且次日均线点位大于0%的有" + lastPriceSuc + "支，概率为 <b><font color='black'>" + tmp4 + "%</font></b>" + "，";

        long lastPriceOther = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getLastPrice() > 0.4);
                })
                .count();
        long lastPriceOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getLastPrice() > 0.4) && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp5 = (lastPriceOtherSuc * 100) / lastPriceOther;
        String text10 = "个股当天封单小于等于5000万的共" + lastPriceOther + "支，当天封板且次日均线点位大于0%的有" + lastPriceOtherSuc + "支，概率为 <b><font color='black'>" + tmp5 + "%</font></b><br><br>";

        String tex11 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当日开盘点位的高低，表明对股票今天的预期，所以<b><font color='red'>" + "当天开盘点位大于4点，需要重点关注。" + "</font></b>极有可能出现分歧转一致。";
        long openPoint = fenQiData.stream()
                .filter(bean -> {
                    return bean.getFormerStartPoint() > 4;
                })
                .count();
        long openPointSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getFormerStartPoint() > 4 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp6 = (openPointSuc * 100) / openPoint;
        String text12 = "个股当天开盘点位大于4个点的共" + openPoint + "支，当天封板且次日均线点位大于0%的有" + openPointSuc + "支，概率为 <b><font color='black'>" + tmp6 + "%</font></b>" + "，";

        long openPointOther = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getFormerStartPoint() > 4);
                })
                .count();
        long openPointOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getFormerStartPoint() > 4) && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp7 = (openPointOtherSuc * 100) / openPointOther;
        String text13 = "个股当天开盘点位不大于4个点的共" + openPointOther + "支，当天封板且次日均线点位大于0%的有" + openPointOtherSuc + "支，概率为 <b><font color='black'>" + tmp7 + "%</font></b><br><br>";


        String tex14 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当日均线点位的高低，反应了多头的成本，如果太低，则会出现很多套利盘，所以<b><font color='red'>" + "当天均线点位高于6.5%，第二天盘面明显会好很多。" + "</font></b>";
        long averagePoint = fenQiData.stream()
                .filter(bean -> {
                    return bean.getFormerAveragePoint() > 6.5;
                })
                .count();
        long averagePointSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getFormerAveragePoint() > 6.5 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp8 = (averagePointSuc * 100) / averagePoint;
        String text15 = "当天均线点位大于6.5个点的共" + averagePoint + "支，当天封板且次日均线点位大于0%的有" + averagePointSuc + "支，概率为 <b><font color='black'>" + tmp8 + "%</font></b>。";

        long averagePointOther = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getFormerAveragePoint() > 6.5);
                })
                .count();
        long averagePointOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return !(bean.getFormerAveragePoint() > 6.5) && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp9 = (averagePointOtherSuc * 100) / averagePointOther;
        String text16 = "当天均线点位小于等于6.5个点的共" + averagePointOther + "支，当天封板且次日均线点位大于0%的有" + averagePointOtherSuc + "支，概率为 <b><font color='black'>" + tmp9 + "%</font></b><br><br>";

        String text17 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否有前高，反应了上方抛压的大小，如果有，继续拉升势必会比较困难，所以<b><font color='red'>" + "没有前高的票，后面的走势才更容易达成一致" + "</font></b>";
        long hasBefore = fenQiData.stream()
                .filter(bean -> {
                    return !bean.isHasBeforeTop();
                })
                .count();
        long hasBeforeSuc = fenQiData.stream()
                .filter(bean -> {
                    return !bean.isHasBeforeTop() && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp10 = (hasBeforeSuc * 100) / hasBefore;
        String text18 = "没有前高的的共" + hasBefore + "支，当天封板且次日均线点位大于0%的有" + hasBeforeSuc + "支，概率为 <b><font color='black'>" + tmp10 + "%</font></b>。";

        long hasBeforeOther = fenQiData.stream()
                .filter(bean -> {
                    return bean.isHasBeforeTop();
                })
                .count();
        long hasBeforeOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.isHasBeforeTop() && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp11 = (hasBeforeOtherSuc * 100) / hasBeforeOther;
        String text19 = "有前高的的共" + hasBeforeOther + "支，当天封板且次日均线点位大于0%的有" + hasBeforeOtherSuc + "支，概率为 <b><font color='black'>" + tmp11 + "%</font></b><br><br>";


        String text20 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;前一天与大前天的量能比如果太大，分歧会过大，太小又无法形成分歧转一致的走势，所以<b><font color='red'>" + "前一天量能要比大前天高140%~230%，形成分歧转一致成功率最高" + "</font></b>";
        long yesterdaySelfTurnover = fenQiData.stream()
                .filter(bean -> {
                    return bean.getYesterdaySelfTurnover() > 140 && bean.getYesterdaySelfTurnover() < 230;
                })
                .count();
        long yesterdaySelfTurnoverSuc = fenQiData.stream()
                .filter(bean -> {
                    return bean.getYesterdaySelfTurnover() > 140 && bean.getYesterdaySelfTurnover() < 230 && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp12 = (yesterdaySelfTurnoverSuc * 100) / yesterdaySelfTurnover;
        String text21 = "成交量比在此区间的票有" + yesterdaySelfTurnover + "支，当天封板且次日均线点位大于0%的有" + yesterdaySelfTurnoverSuc + "支，概率为 <b><font color='black'>" + tmp12 + "%</font></b>";
        long yesterdaySelfTurnoverOther = fenQiData.stream()
                .filter(bean -> {
                    return bean.getYesterdaySelfTurnover() < 140 || bean.getYesterdaySelfTurnover() > 230;
                })
                .count();
        long yesterdaySelfTurnoverOtherSuc = fenQiData.stream()
                .filter(bean -> {
                    return (bean.getYesterdaySelfTurnover() < 140 || bean.getYesterdaySelfTurnover() > 230) && bean.getLatterAveragePoint() > 0 && bean.getLastPrice() > 0;
                })
                .count();
        long tmp13 = (yesterdaySelfTurnoverOtherSuc * 100) / yesterdaySelfTurnoverOther;
        String text22 = "成交量比不在此区间的票有" + yesterdaySelfTurnoverOther + "支，当天封板且次日均线点位大于0%的有" + yesterdaySelfTurnoverOtherSuc + "支，概率为 <b><font color='black'>" + tmp13 + "%</font></b><br><br>";
        result = text1 + text2 + text3 + text4 + text8 + text9 + text10 + text5 + text6 + text7 + tex11 + text12 + text13 + tex14 + text15 + text16 + text17 + text18 + text19 + text20 + text21 + text22;
        textView.setText(Html.fromHtml(result));
    }
}
