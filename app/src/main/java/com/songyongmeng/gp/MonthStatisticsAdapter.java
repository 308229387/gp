package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.OnNewItemClickListener;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

public class MonthStatisticsAdapter extends RecyclerView.Adapter<MonthStatisticsAdapter.ViewHolder> {

    boolean all;
    boolean suc;
    boolean radio;
    boolean ban;
    boolean averageSuc;
    boolean averageFai;
    private Context context;
    private Map<String, List<NewStatisticsBean>> dataMap;

    private OnNewItemClickListener mListener;

    private List<MonthShowBean> itemList = new ArrayList<>();
    List<MonthShowBean> originalList;

    public MonthStatisticsAdapter(Context context, Map<String, List<NewStatisticsBean>> data) {
        this.context = context;
        this.dataMap = data;
        modifyData();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void modifyData() {
        int allNum = 0;
        int allNumNum = 0;
        int allNumSuc = 0;
        int allNumFai = 0;
        double allAverageSuc = 0;
        double allAverageFai = 0;

        int pullUpNum = 0;
        int pullUpSucNum = 0;
        int pullUpFaiNum = 0;
        int pullAverageSuc = 0;
        int pullAverageFai = 0;


        int turnedToOneNum = 0;
        int turnedToOneSucNum = 0;
        int turnedToOneFaiNum = 0;
        int turnedAverageSuc = 0;
        int turnedAverageFai = 0;

        int isRebound = 0;
        int isReboundSuc = 0;
        int isReboundFai = 0;
        int reboundAverageSuc = 0;
        int reboundAverageFai = 0;

        int isRebound5 = 0;
        int isRebound5Suc = 0;
        int isRebound5Fai = 0;
        int rebound5AverageSuc = 0;
        int rebound5AverageFai = 0;

        int isRebound10 = 0;
        int isRebound10Suc = 0;
        int isRebound10Fai = 0;
        int rebound10AverageSuc = 0;
        int rebound10AverageFai = 0;

        int isRebound20 = 0;
        int isRebound20Suc = 0;
        int isRebound20Fai = 0;
        int rebound20AverageSuc = 0;
        int rebound20AverageFai = 0;

        int isRebound30 = 0;
        int isRebound30Suc = 0;
        int isRebound30Fai = 0;
        int rebound30AverageSuc = 0;
        int rebound30AverageFai = 0;

        int isHot = 0;
        int isHotSuc = 0;
        int isHotFai = 0;
        int hotAverageSuc = 0;
        int hotAverageFai = 0;

        int isBan = 0;
        int isBanSuc = 0;
        int isBanFai = 0;
        int banAverageSuc = 0;
        int banAverageFai = 0;

        int low5buy = 0;
        int low5buySuc = 0;
        int low5buyFai = 0;
        int low5buyAverageSuc = 0;
        int low5buyAverageFai = 0;

        int sellOpenHigh = 0;
        int sellOpenHighSuc = 0;
        int sellOpenHighFai = 0;
        int sellOpenHighAverageSuc = 0;
        int sellOpenHighAverageFai = 0;

        int sellOpenLow = 0;
        int sellOpenLowSuc = 0;
        int sellOpenLowFai = 0;
        int sellOpenLowAverageSuc = 0;
        int sellOpenLowAverageFai = 0;

        int allTurAverageSuc = 0;
        int allTurAverageFai = 0;

        int isTurnoverSellOpenHigh = 0;
        int reduceTurnoverSellOpenHigh = 0;

        int reduceSelfGp = 0;
        int reduceSelfGpSuc = 0;
        int reduceSelfGpFai = 0;
        int reduceSelfGpAverageSuc = 0;
        int reduceSelfGpAverageFai = 0;

        int addSelfGp = 0;
        int addSelfGpSuc = 0;
        int addSelfGpFai = 0;
        int addSelfGpAverageSuc = 0;
        int addSelfGpAverageFai = 0;

        int longHeader = 0;
        int longHeaderNum = 0;
        int longHeaderSuc = 0;
        int longHeaderFai = 0;
        double longHeaderAverageSuc = 0;
        double longHeaderAverageFai = 0;


        int highBan = 0;
        int highBanSuc = 0;
        int highBanFai = 0;
        int highBanAverageSuc = 0;
        int highBanAverageFai = 0;

        int before10Buy = 0;
        int before10BuySuc = 0;
        int before10BuyFai = 0;
        int before10BuyAverageSuc = 0;
        int before10BuyAverageFai = 0;

        int amBuy = 0;
        int amBuySuc = 0;
        int amBuyFai = 0;
        int amBuyAverageSuc = 0;
        int amBuyAverageFai = 0;

        int pmBuy = 0;
        int pmBuySuc = 0;
        int pmBuyFai = 0;
        int pmBuyAverageSuc = 0;
        int pmBuyAverageFai = 0;

//        for (NewStatisticsBean tmp : dataList) {
//            allNum++;
//            if(tmp.getLastPrice()>0){
//                allNumNum++;
//            }
//            if (tmp.getResultPoint() > 0) {
//                allNumSuc++;
//                allAverageSuc = allAverageSuc + tmp.getResultPoint();
//            } else {
//                allNumFai++;
//                allAverageFai = allAverageFai + tmp.getResultPoint();
//            }
////
////            if (isClockBefore(tmp.getBuyTime(), 9, 40)) {
////                before10Buy++;
////                if (tmp.getResultPoint()>0) {
////                    before10BuySuc++;
////                    before10BuyAverageSuc = before10BuyAverageSuc + tmp.getResultPoint();
////                } else {
////                    before10BuyFai++;
////                    before10BuyAverageFai = before10BuyAverageFai + tmp.getResultPoint();
////                }
////            }
////
////            if (isClockBefore(tmp.getBuyTime(), 13, 0)) {
////                amBuy++;
////                if (tmp.getResultPoint()>0) {
////                    amBuySuc++;
////                    amBuyAverageSuc = amBuyAverageSuc + tmp.getResultPoint();
////                } else {
////                    amBuyFai++;
////                    amBuyAverageFai = amBuyAverageFai + tmp.getResultPoint();
////                }
////            }
////
////            if (isClockAfter(tmp.getBuyTime(), 11, 30)) {
////                pmBuy++;
////                if (tmp.getResultPoint()>0) {
////                    pmBuySuc++;
////                    pmBuyAverageSuc = pmBuyAverageSuc + tmp.getResultPoint();
////                } else {
////                    pmBuyFai++;
////                    pmBuyAverageFai = pmBuyAverageFai + tmp.getResultPoint();
////                }
////            }
////
////            if (tmp.getEndQuantity() < 5) {
////                reduceSelfGp++;
////                if (tmp.getResultPoint()>0) {
////                    reduceSelfGpSuc++;
////                    reduceSelfGpAverageSuc = reduceSelfGpAverageSuc + tmp.getResultPoint();
////                } else {
////                    reduceSelfGpFai++;
////                    reduceSelfGpAverageFai = reduceSelfGpAverageFai + tmp.getResultPoint();
////                }
////            } else {
////                addSelfGp++;
////                if (tmp.getResultPoint()>0) {
////                    addSelfGpSuc++;
////                    addSelfGpAverageSuc = addSelfGpAverageSuc + tmp.getResultPoint();
////                } else {
////                    addSelfGpFai++;
////                    addSelfGpAverageFai = addSelfGpAverageFai + tmp.getResultPoint();
////                }
////            }
////
////            if (tmp.getSellOpen() > 0) {
////                sellOpenHigh++;
////                if (tmp.getResultPoint()>0) {
////                    sellOpenHighSuc++;
////                    sellOpenHighAverageSuc = sellOpenHighAverageSuc + tmp.getResultPoint();
////                } else {
////                    sellOpenHighFai++;
////                    sellOpenHighAverageFai = sellOpenHighAverageFai + tmp.getResultPoint();
////                }
////            } else {
////                sellOpenLow++;
////                if (tmp.getResultPoint()>0) {
////                    sellOpenLowSuc++;
////                    sellOpenLowAverageSuc = sellOpenLowAverageSuc + tmp.getResultPoint();
////                } else {
////                    sellOpenLowFai++;
////                    sellOpenLowAverageFai = sellOpenLowAverageFai + tmp.getResultPoint();
////                }
////            }
////
////            if (tmp.isIsPullUp()) {
////                pullUpNum++;
////                if (tmp.getResultPoint()>0) {
////                    pullUpSucNum++;
////                    pullAverageSuc = pullAverageSuc + tmp.getResultPoint();
////                } else {
////                    pullUpFaiNum++;
////                    pullAverageFai = pullAverageFai + tmp.getResultPoint();
////                }
////            }
////            if (tmp.isWhenBuyIsTurnedToOne()) {
////                turnedToOneNum++;
////                if (tmp.getResultPoint()>0) {
////                    turnedToOneSucNum++;
////                    turnedAverageSuc = turnedAverageSuc + tmp.getResultPoint();
////                } else {
////                    turnedToOneFaiNum++;
////                    turnedAverageFai = turnedAverageFai + tmp.getResultPoint();
////                }
////            }
////            if (tmp.isWhenBuyIsHot()) {
////                isHot++;
////                if (tmp.getResultPoint()>0) {
////                    isHotSuc++;
////                    hotAverageSuc = hotAverageSuc + tmp.getResultPoint();
////                } else {
////                    isHotFai++;
////                    hotAverageFai = hotAverageFai + tmp.getResultPoint();
////                }
////            }
////            if (tmp.isWhenBuyIsRebound()) {
////                isRebound++;
////                if (tmp.getResultPoint()>0) {
////                    isReboundSuc++;
////                    reboundAverageSuc = reboundAverageSuc + tmp.getResultPoint();
////                } else {
////                    isReboundFai++;
////                    reboundAverageFai = reboundAverageFai + tmp.getResultPoint();
////                }
////
////                if (tmp.getReboundLine() == 5) {
////                    isRebound5++;
////                    if (tmp.getResultPoint()>0) {
////                        isRebound5Suc++;
////                        rebound5AverageSuc = rebound5AverageSuc + tmp.getResultPoint();
////                    } else {
////                        isRebound5Fai++;
////                        rebound5AverageFai = rebound5AverageFai + tmp.getResultPoint();
////                    }
////                }
////
////                if (tmp.getReboundLine() == 10) {
////                    isRebound10++;
////                    if (tmp.getResultPoint()>0) {
////                        isRebound10Suc++;
////                        rebound10AverageSuc = rebound10AverageSuc + tmp.getResultPoint();
////                    } else {
////                        isRebound10Fai++;
////                        rebound10AverageFai = rebound10AverageFai + tmp.getResultPoint();
////                    }
////                }
////
////                if (tmp.getReboundLine() == 20) {
////                    isRebound20++;
////                    if (tmp.getResultPoint()>0) {
////                        isRebound20Suc++;
////                        rebound20AverageSuc = rebound20AverageSuc + tmp.getResultPoint();
////                    } else {
////                        isRebound20Fai++;
////                        rebound20AverageFai = rebound20AverageFai + tmp.getResultPoint();
////                    }
////                }
////
////                if (tmp.getReboundLine() == 30) {
////                    isRebound30++;
////                    if (tmp.getResultPoint()>0) {
////                        isRebound30Suc++;
////                        rebound30AverageSuc = rebound30AverageSuc + tmp.getResultPoint();
////                    } else {
////                        isRebound30Fai++;
////                        rebound30AverageFai = rebound30AverageFai + tmp.getResultPoint();
////                    }
////                }
////            }
////            if (tmp.isIsBuyBan()) {
////                isBan++;
////                if (tmp.getResultPoint()>0) {
////                    isBanSuc++;
////                    banAverageSuc = banAverageSuc + tmp.getResultPoint();
////                } else {
////                    isBanFai++;
////                    banAverageFai = banAverageFai + tmp.getResultPoint();
////                }
////            }
////            if (tmp.getBuyPoint() < 5) {
////                low5buy++;
////                if (tmp.getResultPoint()>0) {
////                    low5buySuc++;
////                    low5buyAverageSuc = low5buyAverageSuc + tmp.getResultPoint();
////                } else {
////                    low5buyFai++;
////                    low5buyAverageFai = low5buyAverageFai + tmp.getResultPoint();
////                }
////            }
//            if (tmp.getMode() == 0) {
//                longHeader++;
//                if(tmp.getLastPrice()>0){
//                    longHeaderNum++;
//                }
//                if (tmp.getResultPoint() > 0) {
//                    longHeaderSuc++;
//                    longHeaderAverageSuc = longHeaderAverageSuc + tmp.getResultPoint();
//                } else {
//                    longHeaderFai++;
//                    longHeaderAverageFai = longHeaderAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.getMode() == 1) {
//                firstBan++;
//                if(tmp.getLastPrice()>0){
//                    firstBanNum++;
//                }
//                if (tmp.getResultPoint() > 0) {
//                    firstBanSuc++;
//                    firstBanAverageSuc = firstBanAverageSuc + tmp.getResultPoint();
//                } else {
//                    firstBanFai++;
//                    firstBanAverageFai = firstBanAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.getMode() == 2) {
//                twoBan++;
//                if(tmp.getLastPrice()>0){
//                    twoBanNum++;
//                }
//                if (tmp.getResultPoint() > 0) {
//                    twoBanSuc++;
//                    twoBanAverageSuc = twoBanAverageSuc + tmp.getResultPoint();
//                } else {
//                    twoBanFai++;
//                    twoBanAverageFai = twoBanAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.getMode() == 3) {
//                middleBan++;
//                if(tmp.getLastPrice()>0){
//                    middleBanNum++;
//                }
//                if (tmp.getResultPoint() > 0) {
//                    middleBanSuc++;
//                    middleBanAverageSuc = middleBanAverageSuc + tmp.getResultPoint();
//                } else {
//                    middleBanFai++;
//                    middleBanAverageFai = middleBanAverageFai + tmp.getResultPoint();
//                }
//            }
////            if (tmp.isIsPullUp() && tmp.getBuyBanNum() > 3) {
////                highBan++;
////                if (tmp.getResultPoint()>0) {
////                    highBanSuc++;
////                    highBanAverageSuc = highBanAverageSuc + tmp.getResultPoint();
////                } else {
////                    highBanFai++;
////                    highBanAverageFai = highBanAverageFai + tmp.getResultPoint();
////                }
////            }
//        }
        List<String> keyList = new ArrayList<>(dataMap.keySet());
        Comparator<String> dateComparator = new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

            @Override
            public int compare(String date1, String date2) {
                try {
                    return sdf.parse(date2).compareTo(sdf.parse(date1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        };

        // 使用自定义比较器进行时间倒序排序
        Collections.sort(keyList, dateComparator);

        for (String month : keyList) {

            int allMonth = 0;
            int allMonthNum = 0;
            int allMonthSuc = 0;
            int allMonthFai = 0;
            double allMonthAverageSuc = 0;
            double allMonthAverageFai = 0;

            int fbTime = 0;//次数
            int fbNum = 0;//上板次数
            int fbSuc = 0;//成功次数
            int fbFai = 0;//失败次数
            double fbAverageSuc = 0;//盈利点总计
            double fbAverageFai = 0;//亏损点总计

            int firstBan = 0;
            int firstBanNum = 0;
            int firstBanSuc = 0;
            int firstBanFai = 0;
            double firstBanAverageSuc = 0;
            double firstBanAverageFai = 0;

            int twoBan = 0;
            int twoBanNum = 0;
            int twoBanSuc = 0;
            int twoBanFai = 0;
            double twoBanAverageSuc = 0;
            double twoBanAverageFai = 0;

            int middleBan = 0;
            int middleBanNum = 0;
            int middleBanSuc = 0;
            int middleBanFai = 0;
            double middleBanAverageSuc = 0;
            double middleBanAverageFai = 0;

            int monthAllNum = 0;

            List<NewStatisticsBean> monthItems = dataMap.get(month);

            List<Integer> failureReasonList = new ArrayList<>();

            for (NewStatisticsBean item : monthItems) {

                if (item.getResultPoint() > 0) {
                    allMonthSuc++;//盈利点位
                    allMonthAverageSuc = allMonthAverageSuc + item.getResultPoint();
                } else {
                    allMonthFai++;
                    allMonthAverageFai = allMonthAverageFai + item.getResultPoint();
                }

                if (item.getMode() == 1) {
                    firstBan++;
                    if (item.getLastPrice() > 0) {
                        firstBanNum++;
                    }
                    if (item.getResultPoint() > 0) {
                        firstBanSuc++;
                        firstBanAverageSuc = firstBanAverageSuc + item.getResultPoint();
                    } else {
                        firstBanFai++;
                        firstBanAverageFai = firstBanAverageFai + item.getResultPoint();
                    }
                }

                if (item.getMode() == 98) {
                    fbTime++;
                    if (item.getLastPrice() > 0) {
                        fbNum++;
                    }
                    if (item.getResultPoint() > 0) {
                        fbSuc++;
                        fbAverageSuc = fbAverageSuc + item.getResultPoint();
                    } else {
                        fbFai++;
                        fbAverageFai = fbAverageFai + item.getResultPoint();
                    }
                }

                if (item.getMode() == 2) {
                    twoBan++;
                    if (item.getLastPrice() > 0) {
                        twoBanNum++;
                    }
                    if (item.getResultPoint() > 0) {
                        twoBanSuc++;
                        twoBanAverageSuc = twoBanAverageSuc + item.getResultPoint();
                    } else {
                        twoBanFai++;
                        twoBanAverageFai = twoBanAverageFai + item.getResultPoint();
                    }
                }

                if (item.getMode() > 2 && item.getMode() < 97) {
                    middleBan++;
                    if (item.getLastPrice() > 0) {
                        middleBanNum++;
                    }
                    if (item.getResultPoint() > 0) {
                        middleBanSuc++;
                        middleBanAverageSuc = middleBanAverageSuc + item.getResultPoint();
                    } else {
                        middleBanFai++;
                        middleBanAverageFai = middleBanAverageFai + item.getResultPoint();
                    }
                }

                if (item.getFailureReason() != null) {
                    failureReasonList.addAll(item.getFailureReason());
                }
                monthAllNum++;
            }
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            // 计算数字出现次数
            for (int num : failureReasonList) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            // 对出现次数进行降序排序
            List<Map.Entry<Integer, Integer>> sortedList = frequencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .collect(Collectors.toList());

            StringBuilder reason = new StringBuilder("");
            StringBuilder reasonAll = new StringBuilder("");
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : sortedList) {
                reasonAll.append(getCode(entry.getKey()) + " " + entry.getValue() + "次 \n\n");
                if (count < 2) {
                    reason.append(getCode(entry.getKey()) + " " + entry.getValue() + "次   ");
                    count++;
                }
            }

            Log.d("song_test", "结果reason = " + reason);
            Log.d("song_test", "reasonAll = " + reasonAll);
//            Log.d("song_test","结果胜率  = "+getResult(monthAllNum, allMonthSuc)+"monthAllNum = "+monthAllNum+" allMonthSuc = "+allMonthSuc);
//            Log.d("song_test","结果均盈利点位 = "+twoPoint(allMonthSuc == 0 ? 0 : allMonthAverageSuc / allMonthSuc) + "allMonthSuc = "+allMonthSuc+ " allMonthAverageSuc = "+allMonthAverageSuc);
//            Log.d("song_test","结果均亏损点位 = "+twoPoint(allMonthFai == 0 ? 0 : allMonthAverageFai / allMonthFai)+" allMonthFai = "+allMonthFai+" allMonthAverageFai = "+allMonthAverageFai);


            itemList.add(new MonthShowBean(month, monthAllNum, getResult(monthAllNum, allMonthSuc), twoPoint(allMonthSuc == 0 ? 0 : allMonthAverageSuc / allMonthSuc), twoPoint(allMonthFai == 0 ? 0 : allMonthAverageFai / allMonthFai), fbTime, getResult(fbTime, fbNum), getResult(fbTime, fbSuc), twoPoint(fbSuc == 0 ? 0 : fbAverageSuc / fbSuc), twoPoint(fbFai == 0 ? 0 : fbAverageFai / fbFai), firstBan, getResult(firstBan, firstBanNum), getResult(firstBan, firstBanSuc), twoPoint(firstBanSuc == 0 ? 0 : firstBanAverageSuc / firstBanSuc), twoPoint(firstBanFai == 0 ? 0 : firstBanAverageFai / firstBanFai), twoBan, getResult(twoBan, twoBanNum), getResult(twoBan, twoBanSuc), twoPoint(twoBanSuc == 0 ? 0 : twoBanAverageSuc / twoBanSuc), twoPoint(twoBanFai == 0 ? 0 : twoBanAverageFai / twoBanFai), middleBan, getResult(middleBan, middleBanSuc), monthAllNum, reason.toString(), reasonAll.toString()));

        }

//        itemList.add(new ShowBean("总计", allNum, allNumSuc, getResult(allNum, allNumSuc), getResult(allNum, allNumNum), allNumSuc == 0 ? 0 : allAverageSuc / allNumSuc, allNumFai == 0 ? 0 : allAverageFai / allNumFai));
//        itemList.add(new ShowBean("个股缩量", reduceSelfGp, reduceSelfGpSuc, getResult(reduceSelfGp, reduceSelfGpSuc), reduceSelfGpSuc == 0 ? 0 : reduceSelfGpAverageSuc / reduceSelfGpSuc, reduceSelfGpFai == 0 ? 0 : reduceSelfGpAverageFai / reduceSelfGpFai));
//        itemList.add(new ShowBean("个股平放量", addSelfGp, addSelfGpSuc, getResult(addSelfGp, addSelfGpSuc), addSelfGpSuc == 0 ? 0 : addSelfGpAverageSuc / addSelfGpSuc, addSelfGpFai == 0 ? 0 : addSelfGpAverageFai / addSelfGpFai));
//        itemList.add(new ShowBean("高开1点", sellOpenHigh, sellOpenHighSuc, getResult(sellOpenHigh, sellOpenHighSuc), sellOpenHighSuc == 0 ? 0 : sellOpenHighAverageSuc / sellOpenHighSuc, sellOpenHighFai == 0 ? 0 : sellOpenHighAverageFai / sellOpenHighFai));
//        itemList.add(new ShowBean("平低开", sellOpenLow, sellOpenLowSuc, getResult(sellOpenLow, sellOpenLowSuc), sellOpenLowSuc == 0 ? 0 : sellOpenLowAverageSuc / sellOpenLowSuc, sellOpenLowFai == 0 ? 0 : sellOpenLowAverageFai / sellOpenLowFai));
//        itemList.add(new ShowBean("9点40前买", before10Buy, before10BuySuc, getResult(before10Buy, before10BuySuc), before10BuySuc == 0 ? 0 : before10BuyAverageSuc / before10BuySuc, before10BuyFai == 0 ? 0 : before10BuyAverageFai / before10BuyFai));
//        itemList.add(new ShowBean("上午买", amBuy, amBuySuc, getResult(amBuy, amBuySuc), amBuySuc == 0 ? 0 : amBuyAverageSuc / amBuySuc, amBuyFai == 0 ? 0 : amBuyAverageFai / amBuyFai));
//        itemList.add(new ShowBean("下午买", pmBuy, pmBuySuc, getResult(pmBuy, pmBuySuc), pmBuySuc == 0 ? 0 : pmBuyAverageSuc / pmBuySuc, pmBuyFai == 0 ? 0 : pmBuyAverageFai / pmBuyFai));
//        itemList.add(new ShowBean("主升模式", pullUpNum, pullUpSucNum, getResult(pullUpNum, pullUpSucNum), pullUpSucNum == 0 ? 0 : pullAverageSuc / pullUpSucNum, pullUpFaiNum == 0 ? 0 : pullAverageFai / pullUpFaiNum));
//        itemList.add(new ShowBean("反弹", isRebound, isReboundSuc, getResult(isRebound, isReboundSuc), isReboundSuc == 0 ? 0 : reboundAverageSuc / isReboundSuc, isReboundFai == 0 ? 0 : reboundAverageFai / isReboundFai));
//        itemList.add(new ShowBean("分歧转一致", turnedToOneNum, turnedToOneSucNum, getResult(turnedToOneNum, turnedToOneSucNum), turnedToOneSucNum == 0 ? 0 : turnedAverageSuc / turnedToOneSucNum, turnedToOneFaiNum == 0 ? 0 : turnedAverageFai / turnedToOneFaiNum));
//        itemList.add(new ShowBean("当日追热点", isHot, isHotSuc, getResult(isHot, isHotSuc), isHotSuc == 0 ? 0 : hotAverageSuc / isHotSuc, isHotFai == 0 ? 0 : hotAverageFai / isHotFai));
//        itemList.add(new ShowBean("打板买入", isBan, isBanSuc, getResult(isBan, isBanSuc), isBanSuc == 0 ? 0 : banAverageSuc / isBanSuc, isBanFai == 0 ? 0 : banAverageFai / isBanFai));
//        itemList.add(new ShowBean("5点下买", low5buy, low5buySuc, getResult(low5buy, low5buySuc), low5buySuc == 0 ? 0 : low5buyAverageSuc / low5buySuc, low5buyFai == 0 ? 0 : low5buyAverageFai / low5buyFai));
//        itemList.add(new ShowBean("5日线反弹", isRebound5, isRebound5Suc, getResult(isRebound5, isRebound5Suc), isRebound5Suc == 0 ? 0 : rebound5AverageSuc / isRebound5Suc, isRebound5Fai == 0 ? 0 : rebound5AverageFai / isRebound5Fai));
//        itemList.add(new ShowBean("10日线反弹", isRebound10, isRebound10Suc, getResult(isRebound10, isRebound10Suc), isRebound10Suc == 0 ? 0 : rebound10AverageSuc / isRebound10Suc, isRebound10Fai == 0 ? 0 : rebound10AverageFai / isRebound10Fai));
//        itemList.add(new ShowBean("20日线反弹", isRebound20, isRebound20Suc, getResult(isRebound20, isRebound20Suc), isRebound20Suc == 0 ? 0 : rebound20AverageSuc / isRebound20Suc, isRebound20Fai == 0 ? 0 : rebound20AverageFai / isRebound20Fai));
//        itemList.add(new ShowBean("龙头战法", longHeader, longHeaderSuc, getResult(longHeader, longHeaderSuc), longHeaderSuc == 0 ? 0 : rebound30AverageSuc / longHeaderSuc, longHeaderFai == 0 ? 0 : longHeaderAverageFai / longHeaderFai));
//        itemList.add(new ShowBean("首板", firstBan, firstBanSuc, getResult(firstBan, firstBanSuc), getResult(firstBan, firstBanNum), firstBanSuc == 0 ? 0 : firstBanAverageSuc / firstBanSuc, firstBanFai == 0 ? 0 : firstBanAverageFai / firstBanFai));
//        itemList.add(new ShowBean("二板", twoBan, twoBanSuc, getResult(twoBan, twoBanSuc), getResult(twoBan, twoBanNum), twoBanSuc == 0 ? 0 : twoBanAverageSuc / twoBanSuc, twoBanFai == 0 ? 0 : twoBanAverageFai / twoBanFai));
//        itemList.add(new ShowBean("三板", middleBan, middleBanSuc, getResult(middleBan, middleBanSuc), getResult(middleBan, middleBanNum), middleBanSuc == 0 ? 0 : middleBanAverageSuc / middleBanSuc, middleBanFai == 0 ? 0 : middleBanAverageFai / middleBanFai));
//        itemList.add(new ShowBean("高位板", highBan, highBanSuc, getResult(highBan, highBanSuc), highBanSuc == 0 ? 0 : highBanAverageSuc / highBanSuc, highBanFai == 0 ? 0 : highBanAverageFai / highBanFai));
        originalList = new ArrayList<>(itemList); // 备份原始列表
    }

    private String getCode(Integer key) {
        String tmp = "";
        switch (key) {
            case 0:
                tmp = ReasonForFailure.REASON_0;
                break;
            case 1:
                tmp = ReasonForFailure.REASON_1;
                break;
            case 2:
                tmp = ReasonForFailure.REASON_2;
                break;
            case 3:
                tmp = ReasonForFailure.REASON_3;
                break;
            case 4:
                tmp = ReasonForFailure.REASON_4;
                break;
            case 5:
                tmp = ReasonForFailure.REASON_5;
                break;
            case 6:
                tmp = ReasonForFailure.REASON_6;
                break;
            case 7:
                tmp = ReasonForFailure.REASON_7;
                break;
            case 8:
                tmp = ReasonForFailure.REASON_8;
                break;
            case 9:
                tmp = ReasonForFailure.REASON_9;
                break;
            case 10:
                tmp = ReasonForFailure.REASON_10;
                break;
            case 11:
                tmp = ReasonForFailure.REASON_11;
                break;
            case 12:
                tmp = ReasonForFailure.REASON_12;
                break;
            case 13:
                tmp = ReasonForFailure.REASON_13;
                break;
            case 14:
                tmp = ReasonForFailure.REASON_14;
                break;
            case 15:
                tmp = ReasonForFailure.REASON_15;
                break;
            case 16:
                tmp = ReasonForFailure.REASON_16;
                break;
            case 17:
                tmp = ReasonForFailure.REASON_17;
                break;
            case 18:
                tmp = ReasonForFailure.REASON_18;
                break;
            case 19:
                tmp = ReasonForFailure.REASON_19;
                break;
            case 20:
                tmp = ReasonForFailure.REASON_20;
                break;
            case 21:
                tmp = ReasonForFailure.REASON_21;
                break;
            case 22:
                tmp = ReasonForFailure.REASON_22;
                break;
            case 23:
                tmp = ReasonForFailure.REASON_23;
                break;
            case 24:
                tmp = ReasonForFailure.REASON_24;
                break;
            case 25:
                tmp = ReasonForFailure.REASON_25;
                break;
            case 26:
                tmp = ReasonForFailure.REASON_26;
                break;
            case 27:
                tmp = ReasonForFailure.REASON_27;
                break;
            case 28:
                tmp = ReasonForFailure.REASON_28;
                break;
            case 29:
                tmp = ReasonForFailure.REASON_29;
                break;
            case 30:
                tmp = ReasonForFailure.REASON_30;
                break;
            case 31:
                tmp = ReasonForFailure.REASON_31;
                break;
            default:
                break;
        }
        return tmp;
    }

    public int getResult(int all, int suc) {
        int dividend = suc; // 被除数
        int divisor = all; // 除数
        if (all == 0) {
            return 0;
        }
        float result = (float) dividend / divisor;   // 进行浮点数除法运算

        float roundedResult = Math.round(result * 100) / 100f;   // 保留两位小数
        return (int) (roundedResult * 100);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fen_qi_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        if (itemList.get(position).ratio > 49) {
        holder.itemView.setBackgroundColor(Color.parseColor("#FFC0CB"));
//        } else {
//            holder.itemView.setBackgroundColor(Color.parseColor("#90EE90"));
//        }
        MonthShowBean data = itemList.get(position);

        holder.bindData(data);

        // 为 item 设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(returnData(itemList.get(position)));

                }
            }
        });
    }

    private List<NewStatisticsBean> returnData(MonthShowBean showBean) {
        return dataMap.get(showBean.month);
    }


//    private List<NewStatisticsBean> returnData(ShowBean showBean) {
//        switch (showBean.model) {
//            case "总计":
//                return dataList;
////            case "5日线反弹":
////                return data.stream()
////                        .filter(bean -> bean.getReboundLine() == 5)
////                        .collect(Collectors.toList());
////            case "10日线反弹":
////                return data.stream()
////                        .filter(bean -> bean.getReboundLine() == 10)
////                        .collect(Collectors.toList());
////            case "20日线反弹":
////                return data.stream()
////                        .filter(bean -> bean.getReboundLine() == 20)
////                        .collect(Collectors.toList());
////            case "30日线反弹":
////                return data.stream()
////                        .filter(bean -> bean.getReboundLine() == 30)
////                        .collect(Collectors.toList());
////            case "沪深缩量":
////                return data.stream()
////                        .filter(bean -> bean.getAllTurnover() == -1)
////                        .collect(Collectors.toList());
////            case "沪深平量":
////                return data.stream()
////                        .filter(bean -> bean.getAllTurnover() == 0)
////                        .collect(Collectors.toList());
//            case "龙头战法":
//                return dataList.stream()
//                        .filter(bean -> bean.getMode() == 0)
//                        .collect(Collectors.toList());
//            case "首板":
//                return dataList.stream()
//                        .filter(bean -> bean.getMode() == 1)
//                        .collect(Collectors.toList());
//            case "二板":
//                return dataList.stream()
//                        .filter(bean -> bean.getMode() == 2)
//                        .collect(Collectors.toList());
//            case "三板":
//                return dataList.stream()
//                        .filter(bean -> bean.getMode() == 3)
//                        .collect(Collectors.toList());
////            case "高位板":
////                return data.stream()
////                        .filter(bean -> bean.getMode() && bean.getBuyBanNum() > 3)
////                        .collect(Collectors.toList());
//            default:
//                return new ArrayList<>();
//
//        }
//    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

//    public void changeAllTimeData() {
//        Collections.sort(itemList, new Comparator<ShowBean>() {
//            @Override
//            public int compare(ShowBean bean1, ShowBean bean2) {
//                if (all) {
//                    return bean2.allTime - bean1.allTime;
//                } else {
//                    return bean1.allTime - bean2.allTime;
//                }
//            }
//        });
//        all = !all;
//        notifyDataSetChanged();
//
//    }

//    public void changeSucTimeData() {
//        Collections.sort(itemList, new Comparator<ShowBean>() {
//            @Override
//            public int compare(ShowBean bean1, ShowBean bean2) {
//                if (suc) {
//                    return bean2.sucTime - bean1.sucTime;
//                } else {
//                    return bean1.sucTime - bean2.sucTime;
//                }
//            }
//        });
//        suc = !suc;
//        notifyDataSetChanged();
//
//    }

//    public void changeRadioData() {
//        Collections.sort(itemList, new Comparator<ShowBean>() {
//            @Override
//            public int compare(ShowBean bean1, ShowBean bean2) {
//                if (radio) {
//                    return bean2.ratio - bean1.ratio;
//                } else {
//                    return bean1.ratio - bean2.ratio;
//                }
//            }
//        });
//        radio = !radio;
//        notifyDataSetChanged();
//    }

//    public void changeBanData() {
//        Collections.sort(itemList, new Comparator<ShowBean>() {
//            @Override
//            public int compare(ShowBean bean1, ShowBean bean2) {
//                if (ban) {
//                    return bean2.ban - bean1.ban;
//                } else {
//                    return bean1.ban - bean2.ban;
//                }
//            }
//        });
//        ban = !ban;
//        notifyDataSetChanged();
//    }

//    public void changeAverageSucData() {
//        Collections.sort(itemList, new Comparator<ShowBean>() {
//            @Override
//            public int compare(ShowBean bean1, ShowBean bean2) {
//                if (averageSuc) {
//                    return Double.compare(bean1.averageSuc, bean2.averageSuc);
//                } else {
//                    return Double.compare(bean2.averageSuc, bean1.averageSuc);
//                }
//            }
//        });
//        averageSuc = !averageSuc;
//        notifyDataSetChanged();
//    }


    public void recoverData() {
        itemList.clear();
        itemList.addAll(originalList);
        notifyDataSetChanged();
    }

//    public void changeAverageFaiData() {
//        Collections.sort(itemList, new Comparator<ShowBean>() {
//            @Override
//            public int compare(ShowBean bean1, ShowBean bean2) {
//                if (averageSuc) {
//                    return Double.compare(bean1.averageFai, bean2.averageFai);
//                } else {
//                    return Double.compare(bean2.averageFai, bean1.averageFai);
//                }
//            }
//        });
//        averageFai = !averageFai;
//        notifyDataSetChanged();
//    }

    public boolean isClockBefore(String tmp, int targetHour, int targetMinutes) {
        String[] timeParts = tmp.split(":"); // 拆分小时和分钟部分
        int hour = Integer.parseInt(timeParts[0]); // 小时
        int minute = Integer.parseInt(timeParts[1]); // 分钟

        if (hour < targetHour || (hour == targetHour && minute < targetMinutes)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isClockAfter(String tmp, int targetHour, int targetMinutes) {
        String[] timeParts = tmp.split(":");
        String hourString = timeParts[0]; // 小时部分
        String minuteString = timeParts[1]; // 分钟部分

        int hour = Integer.parseInt(hourString);
        int minute = Integer.parseInt(minuteString);

        if (hour > targetHour || (hour == targetHour && minute >= targetMinutes)) {
            return true;
        } else {
            return false;
        }

    }

    public void setOnItemClickListener(OnNewItemClickListener listener) {
        mListener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

        public void bindData(MonthShowBean data) {
            // 清空容器中的所有子视图
            linearLayout.removeAllViews();

            // 动态添加 TextView
            for (int i = 0; i < 23; i++) {
                TextView textView = new TextView(itemView.getContext());
                if (i == 0) {
                    textView.setWidth(250); // 日期
                } else if (i == 22) {
                    textView.setWidth(1000); // 设置宽度为200像素
                } else {
                    textView.setWidth(200); // 设置宽度为200像素
                }
                textView.setHeight(100);
                textView.setTextColor(Color.parseColor("#ff000000"));
                textView.setGravity(Gravity.CENTER);
//                if (data.getResultPoint() > 0) {
//                    textView.setBackgroundColor(Color.parseColor("#FFC0CB"));
//                } else {
//                    textView.setBackgroundColor(Color.parseColor("#90EE90"));
//                }
                switch (i) {
                    case 0:
                        textView.setText(data.month);
                        break;
                    case 1:
                        textView.setText(data.allTime == 0 ? "-" : data.allTime + "次");
                        break;
                    case 2:
                        textView.setText((data.allTime == 0 && data.allRate == 0) ? "-" : data.allRate + "%");
                        break;
                    case 3:
                        textView.setText(data.allTime == 0 ? "-" : data.allAverageSuc + "%");
                        break;
                    case 4:
                        textView.setText(data.allTime == 0 ? "-" : data.allAverageFai + "%");
                        break;
                    case 5:
                        textView.setText(data.fbTime == 0 ? "-" : data.fbTime + "次");
                        break;
                    case 6:
                        textView.setText((data.fbTime == 0 && data.fbRate == 0) ? "-" : data.fbRate + "%");
                        break;
                    case 7:
                        textView.setText(data.fbTime == 0 ? "-" : data.fbNum + "%");
                        break;
                    case 8:
                        textView.setText(data.fbTime == 0 ? "-" : data.fbAverageSuc + "%");
                        break;
                    case 9:
                        textView.setText(data.fbTime == 0 ? "-" : data.fbAverageFai + "%");
                        break;
                    case 10:
                        textView.setText(data.shouBanTime == 0 ? "-" : data.shouBanTime + "次");
                        break;
                    case 11:
                        textView.setText((data.shouBanTime == 0 && data.shouBanRate == 0) ? "-" : data.shouBanRate + "%");
                        break;
                    case 12:
                        textView.setText(data.shouBanTime == 0 ? "-" : data.shouBanNum + "%");
                        break;
                    case 13:
                        textView.setText(data.shouBanTime == 0 ? "-" : data.shouBanAverageSuc + "%");
                        break;
                    case 14:
                        textView.setText(data.shouBanTime == 0 ? "-" : data.shouBanAverageFai + "%");
                        break;
                    case 15:
                        textView.setText(data.erBanTime == 0 ? "-" : data.erBanTime + "次");
                        break;
                    case 16:
                        textView.setText((data.erBanTime == 0 && data.erBanRate == 0) ? "-" : data.erBanRate + "%");
                        break;
                    case 17:
                        textView.setText(data.erBanTime == 0 ? "-" : data.erBanNum + "%");
                        break;
                    case 18:
                        textView.setText((data.erBanTime == 0) ? "-" : data.erBanAverageSuc + "%");
                        break;
                    case 19:
                        textView.setText((data.erBanTime == 0) ? "-" : data.erBanAverageFai + "%");
                        break;
                    case 20:
                        textView.setText(data.sanBanTime == 0 ? "-" : data.sanBanTime + "次");
                        break;
                    case 21:
                        textView.setText((data.sanBanTime == 0 && data.sanBanRate == 0) ? "-" : data.sanBanRate + "%");
                        break;
                    case 22:
                        textView.setText(data.reasonStr);
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // 创建一个TextView控件
                                TextView textView = new TextView(context);
                                textView.setText(data.reasonAllStr);
                                textView.setTextColor(Color.BLACK);
                                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                                textView.setPadding(20, 20, 20, 20);

                                PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.CYAN));
                                popupWindow.setOutsideTouchable(true);

                                popupWindow.showAtLocation(((Activity) context).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
                            }
                        });
                        break;
                }
                linearLayout.addView(textView);
            }

        }
    }

    public String twoPoint(double num) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(num);
    }

    @Data
    private class MonthShowBean {
        private String month;
        private String reasonStr;
        private String reasonAllStr;
        private int allTime;
        private int shouBanTime;
        private int allRate;
        private int shouBanRate;
        private int erBanTime;
        private int erBanRate;
        private int sanBanTime;
        private int sanBanRate;
        private int shouBanNum;
        private int erBanNum;
        private int monthAllNum;
        int fbTime;
        int fbNum;
        int fbRate;
        String fbAverageSuc;
        String fbAverageFai;
        private String allAverageSuc;
        private String shouBanAverageSuc;
        private String erBanAverageSuc;
        private String allAverageFai;
        private String shouBanAverageFai;

        private String erBanAverageFai;

        public MonthShowBean(String month, int allTime, int allRate, String allAverageSuc, String allAverageFai, int fbTime, int fbNum, int fbRate, String fbAverageSuc, String fbAverageFai, int shouBanTime, int shouBanNum, int shouBanRate, String shouBanAverageSuc, String shouBanAverageFai, int erBanTime, int erBanNum, int erBanRate, String erBanAverageSuc, String erBanAverageFai, int sanBanTime, int sanBanRate, int monthAllNum, String reasonStr, String reasonAllStr) {
            this.fbTime = fbTime;
            this.fbNum = fbNum;
            this.fbRate = fbRate;
            this.fbAverageSuc = fbAverageSuc;
            this.fbAverageFai = fbAverageFai;
            this.month = month;
            this.reasonStr = reasonStr;
            this.allTime = allTime;
            this.allRate = allRate;
            this.reasonAllStr = reasonAllStr;
            this.shouBanTime = shouBanTime;
            this.shouBanRate = shouBanRate;
            this.allAverageSuc = allAverageSuc;
            this.allAverageFai = allAverageFai;
            this.shouBanAverageSuc = shouBanAverageSuc;
            this.shouBanAverageFai = shouBanAverageFai;
            this.erBanAverageSuc = erBanAverageSuc;
            this.erBanAverageFai = erBanAverageFai;
            this.erBanTime = erBanTime;
            this.erBanRate = erBanRate;
            this.sanBanTime = sanBanTime;
            this.sanBanRate = sanBanRate;
            this.shouBanNum = shouBanNum;
            this.erBanNum = erBanNum;
            this.monthAllNum = monthAllNum;
        }
    }
}
