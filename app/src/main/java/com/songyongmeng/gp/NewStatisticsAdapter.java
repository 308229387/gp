package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.OnNewItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewStatisticsAdapter extends RecyclerView.Adapter<NewStatisticsAdapter.ViewHolder> {

    boolean all;
    boolean suc;
    boolean radio;
    boolean ban;
    boolean averageSuc;
    boolean averageFai;
    private Context context;
    private List<NewStatisticsBean> dataList;

    private OnNewItemClickListener mListener;

    private List<ShowBean> itemList = new ArrayList<>();
    List<ShowBean> originalList;

    public NewStatisticsAdapter(Context context, ArrayList<NewStatisticsBean> data) {
        this.context = context;
        this.dataList = data;
        modifyData();
    }

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

        int firstBan = 0;
        int firstBanNum = 0;
        int firstBanSuc = 0;
        int firstBanFai = 0;
        double firstBanAverageSuc = 0;
        double firstBanAverageFai = 0;


        int lineBan = 0;
        int lineBanNum = 0;
        int lineBanSuc = 0;
        int lineBanFai = 0;
        double lineBanAverageSuc = 0;
        double lineBanAverageFai = 0;

        int halfBan = 0;
        int halfBanNum = 0;
        int halfBanSuc = 0;
        int halfBanFai = 0;
        double halfBanAverageSuc = 0;
        double halfBanAverageFai = 0;


        int fbBan = 0;
        int fbBanNum = 0;
        int fbBanSuc = 0;
        int fbBanFai = 0;
        double fbBanAverageSuc = 0;
        double fbBanAverageFai = 0;


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

        for (NewStatisticsBean tmp : dataList) {
            allNum++;
            if (tmp.getLastPrice() > 0) {
                allNumNum++;
            }
            if (tmp.getResultPoint() > 0) {
                allNumSuc++;
                allAverageSuc = allAverageSuc + tmp.getResultPoint();
            } else {
                allNumFai++;
                allAverageFai = allAverageFai + tmp.getResultPoint();
            }
//
//            if (isClockBefore(tmp.getBuyTime(), 9, 40)) {
//                before10Buy++;
//                if (tmp.getResultPoint()>0) {
//                    before10BuySuc++;
//                    before10BuyAverageSuc = before10BuyAverageSuc + tmp.getResultPoint();
//                } else {
//                    before10BuyFai++;
//                    before10BuyAverageFai = before10BuyAverageFai + tmp.getResultPoint();
//                }
//            }
//
//            if (isClockBefore(tmp.getBuyTime(), 13, 0)) {
//                amBuy++;
//                if (tmp.getResultPoint()>0) {
//                    amBuySuc++;
//                    amBuyAverageSuc = amBuyAverageSuc + tmp.getResultPoint();
//                } else {
//                    amBuyFai++;
//                    amBuyAverageFai = amBuyAverageFai + tmp.getResultPoint();
//                }
//            }
//
//            if (isClockAfter(tmp.getBuyTime(), 11, 30)) {
//                pmBuy++;
//                if (tmp.getResultPoint()>0) {
//                    pmBuySuc++;
//                    pmBuyAverageSuc = pmBuyAverageSuc + tmp.getResultPoint();
//                } else {
//                    pmBuyFai++;
//                    pmBuyAverageFai = pmBuyAverageFai + tmp.getResultPoint();
//                }
//            }
//
//            if (tmp.getEndQuantity() < 5) {
//                reduceSelfGp++;
//                if (tmp.getResultPoint()>0) {
//                    reduceSelfGpSuc++;
//                    reduceSelfGpAverageSuc = reduceSelfGpAverageSuc + tmp.getResultPoint();
//                } else {
//                    reduceSelfGpFai++;
//                    reduceSelfGpAverageFai = reduceSelfGpAverageFai + tmp.getResultPoint();
//                }
//            } else {
//                addSelfGp++;
//                if (tmp.getResultPoint()>0) {
//                    addSelfGpSuc++;
//                    addSelfGpAverageSuc = addSelfGpAverageSuc + tmp.getResultPoint();
//                } else {
//                    addSelfGpFai++;
//                    addSelfGpAverageFai = addSelfGpAverageFai + tmp.getResultPoint();
//                }
//            }
//
//            if (tmp.getSellOpen() > 0) {
//                sellOpenHigh++;
//                if (tmp.getResultPoint()>0) {
//                    sellOpenHighSuc++;
//                    sellOpenHighAverageSuc = sellOpenHighAverageSuc + tmp.getResultPoint();
//                } else {
//                    sellOpenHighFai++;
//                    sellOpenHighAverageFai = sellOpenHighAverageFai + tmp.getResultPoint();
//                }
//            } else {
//                sellOpenLow++;
//                if (tmp.getResultPoint()>0) {
//                    sellOpenLowSuc++;
//                    sellOpenLowAverageSuc = sellOpenLowAverageSuc + tmp.getResultPoint();
//                } else {
//                    sellOpenLowFai++;
//                    sellOpenLowAverageFai = sellOpenLowAverageFai + tmp.getResultPoint();
//                }
//            }
//
//            if (tmp.isIsPullUp()) {
//                pullUpNum++;
//                if (tmp.getResultPoint()>0) {
//                    pullUpSucNum++;
//                    pullAverageSuc = pullAverageSuc + tmp.getResultPoint();
//                } else {
//                    pullUpFaiNum++;
//                    pullAverageFai = pullAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.isWhenBuyIsTurnedToOne()) {
//                turnedToOneNum++;
//                if (tmp.getResultPoint()>0) {
//                    turnedToOneSucNum++;
//                    turnedAverageSuc = turnedAverageSuc + tmp.getResultPoint();
//                } else {
//                    turnedToOneFaiNum++;
//                    turnedAverageFai = turnedAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.isWhenBuyIsHot()) {
//                isHot++;
//                if (tmp.getResultPoint()>0) {
//                    isHotSuc++;
//                    hotAverageSuc = hotAverageSuc + tmp.getResultPoint();
//                } else {
//                    isHotFai++;
//                    hotAverageFai = hotAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.isWhenBuyIsRebound()) {
//                isRebound++;
//                if (tmp.getResultPoint()>0) {
//                    isReboundSuc++;
//                    reboundAverageSuc = reboundAverageSuc + tmp.getResultPoint();
//                } else {
//                    isReboundFai++;
//                    reboundAverageFai = reboundAverageFai + tmp.getResultPoint();
//                }
//
//                if (tmp.getReboundLine() == 5) {
//                    isRebound5++;
//                    if (tmp.getResultPoint()>0) {
//                        isRebound5Suc++;
//                        rebound5AverageSuc = rebound5AverageSuc + tmp.getResultPoint();
//                    } else {
//                        isRebound5Fai++;
//                        rebound5AverageFai = rebound5AverageFai + tmp.getResultPoint();
//                    }
//                }
//
//                if (tmp.getReboundLine() == 10) {
//                    isRebound10++;
//                    if (tmp.getResultPoint()>0) {
//                        isRebound10Suc++;
//                        rebound10AverageSuc = rebound10AverageSuc + tmp.getResultPoint();
//                    } else {
//                        isRebound10Fai++;
//                        rebound10AverageFai = rebound10AverageFai + tmp.getResultPoint();
//                    }
//                }
//
//                if (tmp.getReboundLine() == 20) {
//                    isRebound20++;
//                    if (tmp.getResultPoint()>0) {
//                        isRebound20Suc++;
//                        rebound20AverageSuc = rebound20AverageSuc + tmp.getResultPoint();
//                    } else {
//                        isRebound20Fai++;
//                        rebound20AverageFai = rebound20AverageFai + tmp.getResultPoint();
//                    }
//                }
//
//                if (tmp.getReboundLine() == 30) {
//                    isRebound30++;
//                    if (tmp.getResultPoint()>0) {
//                        isRebound30Suc++;
//                        rebound30AverageSuc = rebound30AverageSuc + tmp.getResultPoint();
//                    } else {
//                        isRebound30Fai++;
//                        rebound30AverageFai = rebound30AverageFai + tmp.getResultPoint();
//                    }
//                }
//            }
//            if (tmp.isIsBuyBan()) {
//                isBan++;
//                if (tmp.getResultPoint()>0) {
//                    isBanSuc++;
//                    banAverageSuc = banAverageSuc + tmp.getResultPoint();
//                } else {
//                    isBanFai++;
//                    banAverageFai = banAverageFai + tmp.getResultPoint();
//                }
//            }
//            if (tmp.getBuyPoint() < 5) {
//                low5buy++;
//                if (tmp.getResultPoint()>0) {
//                    low5buySuc++;
//                    low5buyAverageSuc = low5buyAverageSuc + tmp.getResultPoint();
//                } else {
//                    low5buyFai++;
//                    low5buyAverageFai = low5buyAverageFai + tmp.getResultPoint();
//                }
//            }
            if (tmp.getMode() == 99) {
                longHeader++;
                if (tmp.getLastPrice() > 0) {
                    longHeaderNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    longHeaderSuc++;
                    longHeaderAverageSuc = longHeaderAverageSuc + tmp.getResultPoint();
                } else {
                    longHeaderFai++;
                    longHeaderAverageFai = longHeaderAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getMode() == 98) {
                fbBan++;
                if (tmp.getLastPrice() > 0) {
                    fbBanNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    fbBanSuc++;
                    fbBanAverageSuc = fbBanAverageSuc + tmp.getResultPoint();
                } else {
                    fbBanFai++;
                    fbBanAverageFai = fbBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getMode() == 77) {
                lineBan++;
                if (tmp.getLastPrice() > 0) {
                    lineBanNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    lineBanSuc++;
                    lineBanAverageSuc = lineBanAverageSuc + tmp.getResultPoint();
                } else {
                    lineBanFai++;
                    lineBanAverageFai = lineBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getMode() == 15) {
                halfBan++;
                if (tmp.getLastPrice() > 0) {
                    halfBanNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    halfBanSuc++;
                    halfBanAverageSuc = halfBanAverageSuc + tmp.getResultPoint();
                } else {
                    halfBanFai++;
                    halfBanAverageFai = halfBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getMode() == 1) {
                firstBan++;
                if (tmp.getLastPrice() > 0) {
                    firstBanNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    firstBanSuc++;
                    firstBanAverageSuc = firstBanAverageSuc + tmp.getResultPoint();
                } else {
                    firstBanFai++;
                    firstBanAverageFai = firstBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getMode() == 2) {
                twoBan++;
                if (tmp.getLastPrice() > 0) {
                    twoBanNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    twoBanSuc++;
                    twoBanAverageSuc = twoBanAverageSuc + tmp.getResultPoint();
                } else {
                    twoBanFai++;
                    twoBanAverageFai = twoBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getMode() > 2 && tmp.getMode() < 99) {
                middleBan++;
                if (tmp.getLastPrice() > 0) {
                    middleBanNum++;
                }
                if (tmp.getResultPoint() > 0) {
                    middleBanSuc++;
                    middleBanAverageSuc = middleBanAverageSuc + tmp.getResultPoint();
                } else {
                    middleBanFai++;
                    middleBanAverageFai = middleBanAverageFai + tmp.getResultPoint();
                }
            }
//            if (tmp.isIsPullUp() && tmp.getBuyBanNum() > 3) {
//                highBan++;
//                if (tmp.getResultPoint()>0) {
//                    highBanSuc++;
//                    highBanAverageSuc = highBanAverageSuc + tmp.getResultPoint();
//                } else {
//                    highBanFai++;
//                    highBanAverageFai = highBanAverageFai + tmp.getResultPoint();
//                }
//            }
        }

        itemList.add(getShowBean("总计", allNum, allNumSuc, allNumFai, allNumNum, allAverageSuc, allAverageFai));
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
//        itemList.add(new ShowBean("反包", fbBan, fbBanSuc, getResult(fbBan, fbBanSuc), getResult(fbBan, fbBanNum), fbBanSuc == 0 ? 0 : fbBanAverageSuc / fbBanSuc, fbBanFai == 0 ? 0 : fbBanAverageFai / fbBanFai));
        itemList.add(getShowBean("首板半路", halfBan, halfBanSuc, halfBanFai, halfBanNum, halfBanAverageSuc, halfBanAverageFai));
        itemList.add(getShowBean("均线回踩", lineBan, lineBanSuc, lineBanFai, lineBanNum, lineBanAverageSuc, lineBanAverageFai));
        itemList.add(getShowBean("反包", fbBan, fbBanSuc, fbBanFai, fbBanNum, fbBanAverageSuc, fbBanAverageFai));
        itemList.add(getShowBean("龙头战法", longHeader, longHeaderSuc, longHeaderFai, longHeaderNum, longHeaderAverageSuc, longHeaderAverageFai));
        itemList.add(getShowBean("首板", firstBan, firstBanSuc, firstBanFai, firstBanNum, firstBanAverageSuc, firstBanAverageFai));
        itemList.add(getShowBean("二板", twoBan, twoBanSuc, twoBanFai, twoBanNum, twoBanAverageSuc, twoBanAverageFai));
        itemList.add(getShowBean("中位", middleBan, middleBanSuc, middleBanFai, middleBanNum, middleBanAverageSuc, middleBanAverageFai));
//        itemList.add(new ShowBean("高位板", highBan, highBanSuc, getResult(highBan, highBanSuc), highBanSuc == 0 ? 0 : highBanAverageSuc / highBanSuc, highBanFai == 0 ? 0 : highBanAverageFai / highBanFai));
        originalList = new ArrayList<>(itemList); // 备份原始列表
    }

    public ShowBean getShowBean(String leiXing, int zongCiShu, int chengGongCiShu, int shiBaiCiShu, int fengBanCiShu, double chengGongDianWei, double shiBaiDianWei) {
        ShowBean bean = new ShowBean();
        bean.setModel(leiXing);
        bean.setAllTime(zongCiShu);
        bean.setSucTime(chengGongCiShu);
        bean.setRatio(getResult(zongCiShu, chengGongCiShu));
        bean.setBan(getResult(zongCiShu, fengBanCiShu));
        bean.setAverageSuc(chengGongCiShu == 0 ? 0 : chengGongDianWei / chengGongCiShu);
        bean.setAverageFai(shiBaiCiShu == 0 ? 0 : shiBaiDianWei / shiBaiCiShu);
        return bean;
    }


    public int getResult(int all, int suc) {
        int dividend = suc; // 被除数
        int divisor = all; // 除数
        if (all == 0) {
            return 0;
        }
        int result = (dividend * 100) / divisor;
        return result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fen_qi_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (itemList.get(position).getRatio() > 49) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFC0CB"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        ShowBean data = itemList.get(position);

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

    private List<NewStatisticsBean> returnData(ShowBean showBean) {
        switch (showBean.getModel()) {
            case "总计":
                return dataList;
//            case "5日线反弹":
//                return data.stream()
//                        .filter(bean -> bean.getReboundLine() == 5)
//                        .collect(Collectors.toList());
//            case "10日线反弹":
//                return data.stream()
//                        .filter(bean -> bean.getReboundLine() == 10)
//                        .collect(Collectors.toList());
//            case "20日线反弹":
//                return data.stream()
//                        .filter(bean -> bean.getReboundLine() == 20)
//                        .collect(Collectors.toList());
//            case "30日线反弹":
//                return data.stream()
//                        .filter(bean -> bean.getReboundLine() == 30)
//                        .collect(Collectors.toList());
//            case "沪深缩量":
//                return data.stream()
//                        .filter(bean -> bean.getAllTurnover() == -1)
//                        .collect(Collectors.toList());
//            case "沪深平量":
//                return data.stream()
//                        .filter(bean -> bean.getAllTurnover() == 0)
//                        .collect(Collectors.toList());
            case "首板半路":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 15)
                        .collect(Collectors.toList());
            case "均线回踩":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 77)
                        .collect(Collectors.toList());
            case "反包":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 97)
                        .collect(Collectors.toList());
            case "高标":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 98)
                        .collect(Collectors.toList());
            case "龙头战法":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 99)
                        .collect(Collectors.toList());
            case "首板":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 1)
                        .collect(Collectors.toList());
            case "二板":
                return dataList.stream()
                        .filter(bean -> bean.getMode() == 2)
                        .collect(Collectors.toList());
            case "中位":
                return dataList.stream()
                        .filter(bean -> (bean.getMode() > 2 && bean.getMode() < 99))
                        .collect(Collectors.toList());
//            case "高位板":
//                return data.stream()
//                        .filter(bean -> bean.getMode() && bean.getBuyBanNum() > 3)
//                        .collect(Collectors.toList());
            default:
                return new ArrayList<>();

        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void changeAllTimeData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (all) {
                    return bean2.getAllTime() - bean1.getAllTime();
                } else {
                    return bean1.getAllTime() - bean2.getAllTime();
                }
            }
        });
        all = !all;
        notifyDataSetChanged();

    }

    public void changeSucTimeData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (suc) {
                    return bean2.getSucTime() - bean1.getSucTime();
                } else {
                    return bean1.getSucTime() - bean2.getSucTime();
                }
            }
        });
        suc = !suc;
        notifyDataSetChanged();

    }

    public void changeRadioData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (radio) {
                    return bean2.getRatio() - bean1.getRatio();
                } else {
                    return bean1.getRatio() - bean2.getRatio();
                }
            }
        });
        radio = !radio;
        notifyDataSetChanged();
    }

    public void changeBanData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (ban) {
                    return bean2.getBan() - bean1.getBan();
                } else {
                    return bean1.getBan() - bean2.getBan();
                }
            }
        });
        ban = !ban;
        notifyDataSetChanged();
    }

    public void changeAverageSucData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (averageSuc) {
                    return Double.compare(bean1.getAverageSuc(), bean2.getAverageSuc());
                } else {
                    return Double.compare(bean2.getAverageSuc(), bean1.getAverageSuc());
                }
            }
        });
        averageSuc = !averageSuc;
        notifyDataSetChanged();
    }


    public void recoverData() {
        itemList.clear();
        itemList.addAll(originalList);
        notifyDataSetChanged();
    }

    public void changeAverageFaiData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (averageSuc) {
                    return Double.compare(bean1.getAverageFai(), bean2.getAverageFai());
                } else {
                    return Double.compare(bean2.getAverageFai(), bean1.getAverageFai());
                }
            }
        });
        averageFai = !averageFai;
        notifyDataSetChanged();
    }

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

        public void bindData(ShowBean data) {
            // 清空容器中的所有子视图
            linearLayout.removeAllViews();

            // 动态添加 TextView
            for (int i = 0; i < 7; i++) {
                TextView textView = new TextView(itemView.getContext());
                if (i == 0) {
                    textView.setWidth(250); // 名称
                } else {
                    textView.setWidth(230); // 设置宽度为200像素
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
                        textView.setText(data.getModel());
                        break;
                    case 1:
                        textView.setText(data.getAllTime() + "次");
                        break;
                    case 2:
                        textView.setText(data.getSucTime() + "次");
                        break;
                    case 3:
                        textView.setText(data.getRatio() + "%");
                        break;
                    case 4:
                        textView.setText(data.getBan() + "%");
                        break;
                    case 5:
                        String formattedResult = String.format("%.2f", data.getAverageSuc()) + "%";
                        textView.setText(formattedResult);
                        break;
                    case 6:
                        String failResult = String.format("%.2f", data.getAverageFai()) + "%";
                        textView.setText(failResult);
                        break;
                }
                linearLayout.addView(textView);
            }

        }
    }

}
