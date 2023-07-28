package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.SPManager;
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
        textView =findViewById(R.id.ji_sun_result);

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
        double tmp = (double) (selfTurnoverSuc / selfTurnover * 100);
        double tmp1 = (double) (selfOtherTurnoverSuc / (double) (fenQiData.size()-selfTurnover) * 100);

        String text1 = "从23年6月起统计，所有二三板分歧转一致交易共"+fenQiData.size()+"条<br><br>";
        String text2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color='red'>"  +"分歧转一致的核心就是上升过程中缩量，所以当天的量能一定要小于昨日。"+ "</font></b>";
        String text3 = "其中个股当天量对比昨天小于70%的共"+selfTurnover+"支，当天封板且次日均线点位大于0%的有"+selfTurnoverSuc+"支，概率为 <font color='black'>" + tmp +"%"+ "</font>"+"，";
        String text4 = "大于70%的共"+(fenQiData.size()-selfTurnover)+"支，当天封板且次日均线点位大于0%的有"+selfOtherTurnoverSuc+"支，概率为<font color='black'>" + tmp1 +"%"+ "</font>";
        result = text1+text2+text3+text4;
        textView.setText(Html.fromHtml(result));
    }
}
