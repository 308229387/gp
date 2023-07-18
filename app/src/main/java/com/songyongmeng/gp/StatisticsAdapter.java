package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.ViewHolder> {

    boolean all;
    boolean suc;
    boolean radio;
    boolean averageSuc;
    boolean averageFai;
    private Context context;
    private List<StatisticsBean> data;

    private OnItemClickListener mListener;

    private List<ShowBean> itemList = new ArrayList<>();
    List<ShowBean> originalList;

    public StatisticsAdapter(Context context, ArrayList<StatisticsBean> data) {
        this.context = context;
        this.data = data;
        modifyData();
    }

    private void modifyData() {
        int allNum = 0;
        int allNumSuc = 0;
        int allNumFai = 0;
        int allAverageSuc = 0;
        int allAverageFai = 0;

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

        int isAllTurnover = 0;
        int isAllTurnoverSuc = 0;
        int isAllTurnoverFai = 0;
        int allTurAverageSuc = 0;
        int allTurAverageFai = 0;

        int reduceAllTurnover = 0;
        int reduceAllTurnoverSuc = 0;
        int reduceAllTurnoverFai = 0;
        int reduceAllTurnoverAverageSuc = 0;
        int reduceAllTurnoverAverageFai = 0;

        int addAllTurnover = 0;
        int addAllTurnoverSuc = 0;
        int addAllTurnoverFai = 0;
        int addAllTurnoverAverageSuc = 0;
        int addAllTurnoverAverageFai = 0;

        int addAllTurnoverSellOpenHigh = 0;
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

        int twoBan = 0;
        int twoBanSuc = 0;
        int twoBanFai = 0;
        int twoBanAverageSuc = 0;
        int twoBanAverageFai = 0;

        int threeBan = 0;
        int threeBanSuc = 0;
        int threeBanFai = 0;
        int threeBanAverageSuc = 0;
        int threeBanAverageFai = 0;

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

        for (StatisticsBean tmp : data) {
            allNum++;
            if (tmp.isSuc()) {
                allNumSuc++;
                allAverageSuc = allAverageSuc + tmp.getResultPoint();
            } else {
                allNumFai++;
                allAverageFai = allAverageFai + tmp.getResultPoint();
            }

            if (isClockBefore(tmp.getBuyTime(),9,40)) {
                before10Buy++;
                if (tmp.isSuc()) {
                    before10BuySuc++;
                    before10BuyAverageSuc = before10BuyAverageSuc + tmp.getResultPoint();
                } else {
                    before10BuyFai++;
                    before10BuyAverageFai = before10BuyAverageFai + tmp.getResultPoint();
                }
            }

            if (isClockBefore(tmp.getBuyTime(),13,0)) {
                amBuy++;
                if (tmp.isSuc()) {
                    amBuySuc++;
                    amBuyAverageSuc = amBuyAverageSuc + tmp.getResultPoint();
                } else {
                    amBuyFai++;
                    amBuyAverageFai = amBuyAverageFai + tmp.getResultPoint();
                }
            }

            if (isClockAfter(tmp.getBuyTime(),11,30)) {
                pmBuy++;
                if (tmp.isSuc()) {
                    pmBuySuc++;
                    pmBuyAverageSuc = pmBuyAverageSuc + tmp.getResultPoint();
                } else {
                    pmBuyFai++;
                    pmBuyAverageFai = pmBuyAverageFai + tmp.getResultPoint();
                }
            }

            if (tmp.getEndQuantity() < 5) {
                reduceSelfGp++;
                if (tmp.isSuc()) {
                    reduceSelfGpSuc++;
                    reduceSelfGpAverageSuc = reduceSelfGpAverageSuc + tmp.getResultPoint();
                } else {
                    reduceSelfGpFai++;
                    reduceSelfGpAverageFai = reduceSelfGpAverageFai + tmp.getResultPoint();
                }
            } else {
                addSelfGp++;
                if (tmp.isSuc()) {
                    addSelfGpSuc++;
                    addSelfGpAverageSuc = addSelfGpAverageSuc + tmp.getResultPoint();
                } else {
                    addSelfGpFai++;
                    addSelfGpAverageFai = addSelfGpAverageFai + tmp.getResultPoint();
                }
            }

            if (tmp.getSellOpen() > 0) {
                sellOpenHigh++;
                if (tmp.isSuc()) {
                    sellOpenHighSuc++;
                    sellOpenHighAverageSuc = sellOpenHighAverageSuc + tmp.getResultPoint();
                } else {
                    sellOpenHighFai++;
                    sellOpenHighAverageFai = sellOpenHighAverageFai + tmp.getResultPoint();
                }
            } else {
                sellOpenLow++;
                if (tmp.isSuc()) {
                    sellOpenLowSuc++;
                    sellOpenLowAverageSuc = sellOpenLowAverageSuc + tmp.getResultPoint();
                } else {
                    sellOpenLowFai++;
                    sellOpenLowAverageFai = sellOpenLowAverageFai + tmp.getResultPoint();
                }
            }

            if (tmp.isIsPullUp()) {
                pullUpNum++;
                if (tmp.isSuc()) {
                    pullUpSucNum++;
                    pullAverageSuc = pullAverageSuc + tmp.getResultPoint();
                } else {
                    pullUpFaiNum++;
                    pullAverageFai = pullAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.isWhenBuyIsTurnedToOne()) {
                turnedToOneNum++;
                if (tmp.isSuc()) {
                    turnedToOneSucNum++;
                    turnedAverageSuc = turnedAverageSuc + tmp.getResultPoint();
                } else {
                    turnedToOneFaiNum++;
                    turnedAverageFai = turnedAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.isWhenBuyIsHot()) {
                isHot++;
                if (tmp.isSuc()) {
                    isHotSuc++;
                    hotAverageSuc = hotAverageSuc + tmp.getResultPoint();
                } else {
                    isHotFai++;
                    hotAverageFai = hotAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.isWhenBuyIsRebound()) {
                isRebound++;
                if (tmp.isSuc()) {
                    isReboundSuc++;
                    reboundAverageSuc = reboundAverageSuc + tmp.getResultPoint();
                } else {
                    isReboundFai++;
                    reboundAverageFai = reboundAverageFai + tmp.getResultPoint();
                }

                if (tmp.getReboundLine() == 5) {
                    isRebound5++;
                    if (tmp.isSuc()) {
                        isRebound5Suc++;
                        rebound5AverageSuc = rebound5AverageSuc + tmp.getResultPoint();
                    } else {
                        isRebound5Fai++;
                        rebound5AverageFai = rebound5AverageFai + tmp.getResultPoint();
                    }
                }

                if (tmp.getReboundLine() == 10) {
                    isRebound10++;
                    if (tmp.isSuc()) {
                        isRebound10Suc++;
                        rebound10AverageSuc = rebound10AverageSuc + tmp.getResultPoint();
                    } else {
                        isRebound10Fai++;
                        rebound10AverageFai = rebound10AverageFai + tmp.getResultPoint();
                    }
                }

                if (tmp.getReboundLine() == 20) {
                    isRebound20++;
                    if (tmp.isSuc()) {
                        isRebound20Suc++;
                        rebound20AverageSuc = rebound20AverageSuc + tmp.getResultPoint();
                    } else {
                        isRebound20Fai++;
                        rebound20AverageFai = rebound20AverageFai + tmp.getResultPoint();
                    }
                }

                if (tmp.getReboundLine() == 30) {
                    isRebound30++;
                    if (tmp.isSuc()) {
                        isRebound30Suc++;
                        rebound30AverageSuc = rebound30AverageSuc + tmp.getResultPoint();
                    } else {
                        isRebound30Fai++;
                        rebound30AverageFai = rebound30AverageFai + tmp.getResultPoint();
                    }
                }
            }
            if (tmp.isIsBuyBan()) {
                isBan++;
                if (tmp.isSuc()) {
                    isBanSuc++;
                    banAverageSuc = banAverageSuc + tmp.getResultPoint();
                } else {
                    isBanFai++;
                    banAverageFai = banAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getBuyPoint() < 5) {
                low5buy++;
                if (tmp.isSuc()) {
                    low5buySuc++;
                    low5buyAverageSuc = low5buyAverageSuc + tmp.getResultPoint();
                } else {
                    low5buyFai++;
                    low5buyAverageFai = low5buyAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.getAllTurnover() == 0) {
                isAllTurnover++;
                if (tmp.isSuc()) {
                    isAllTurnoverSuc++;
                    allTurAverageSuc = allTurAverageSuc + tmp.getResultPoint();
                } else {
                    isAllTurnoverFai++;
                    allTurAverageFai = allTurAverageFai + tmp.getResultPoint();
                }
                if (tmp.getSellOpen() > 0) {
                    isTurnoverSellOpenHigh++;
                }
            }
            if (tmp.getAllTurnover() == -1) {
                reduceAllTurnover++;
                if (tmp.isSuc()) {
                    reduceAllTurnoverSuc++;
                    reduceAllTurnoverAverageSuc = reduceAllTurnoverAverageSuc + tmp.getResultPoint();
                } else {
                    reduceAllTurnoverFai++;
                    reduceAllTurnoverAverageFai = reduceAllTurnoverAverageFai + tmp.getResultPoint();
                }
                if (tmp.getSellOpen() > 0) {
                    reduceTurnoverSellOpenHigh++;
                }
            }
            if (tmp.getAllTurnover() == 1) {
                addAllTurnover++;
                if (tmp.isSuc()) {
                    addAllTurnoverSuc++;
                    addAllTurnoverAverageSuc = addAllTurnoverAverageSuc + tmp.getResultPoint();
                } else {
                    addAllTurnoverFai++;
                    addAllTurnoverAverageFai = addAllTurnoverAverageFai + tmp.getResultPoint();
                }
                if (tmp.getSellOpen() > 0) {
                    addAllTurnoverSellOpenHigh++;
                }
            }

            if (tmp.isIsPullUp() && tmp.getBuyBanNum() == 2) {
                twoBan++;
                if (tmp.isSuc()) {
                    twoBanSuc++;
                    twoBanAverageSuc = twoBanAverageSuc + tmp.getResultPoint();
                } else {
                    twoBanFai++;
                    twoBanAverageFai = twoBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.isIsPullUp() && tmp.getBuyBanNum() == 3) {
                threeBan++;
                if (tmp.isSuc()) {
                    threeBanSuc++;
                    threeBanAverageSuc = threeBanAverageSuc + tmp.getResultPoint();
                } else {
                    threeBanFai++;
                    threeBanAverageFai = threeBanAverageFai + tmp.getResultPoint();
                }
            }
            if (tmp.isIsPullUp() && tmp.getBuyBanNum() > 3) {
                highBan++;
                if (tmp.isSuc()) {
                    highBanSuc++;
                    highBanAverageSuc = highBanAverageSuc + tmp.getResultPoint();
                } else {
                    highBanFai++;
                    highBanAverageFai = highBanAverageFai + tmp.getResultPoint();
                }
            }
        }

        itemList.add(new ShowBean("总计", allNum, allNumSuc, getResult(allNum, allNumSuc), allNumSuc == 0 ? 0 : allAverageSuc / allNumSuc, allNumFai == 0 ? 0 : allAverageFai / allNumFai));
        itemList.add(new ShowBean("个股缩量", reduceSelfGp, reduceSelfGpSuc, getResult(reduceSelfGp, reduceSelfGpSuc), reduceSelfGpSuc == 0 ? 0 : reduceSelfGpAverageSuc / reduceSelfGpSuc, reduceSelfGpFai == 0 ? 0 : reduceSelfGpAverageFai / reduceSelfGpFai));
        itemList.add(new ShowBean("个股平放量", addSelfGp, addSelfGpSuc, getResult(addSelfGp, addSelfGpSuc), addSelfGpSuc == 0 ? 0 : addSelfGpAverageSuc / addSelfGpSuc, addSelfGpFai == 0 ? 0 : addSelfGpAverageFai / addSelfGpFai));
        itemList.add(new ShowBean("高开1点", sellOpenHigh, sellOpenHighSuc, getResult(sellOpenHigh, sellOpenHighSuc), sellOpenHighSuc == 0 ? 0 : sellOpenHighAverageSuc / sellOpenHighSuc, sellOpenHighFai == 0 ? 0 : sellOpenHighAverageFai / sellOpenHighFai));
        itemList.add(new ShowBean("平低开", sellOpenLow, sellOpenLowSuc, getResult(sellOpenLow, sellOpenLowSuc), sellOpenLowSuc == 0 ? 0 : sellOpenLowAverageSuc / sellOpenLowSuc, sellOpenLowFai == 0 ? 0 : sellOpenLowAverageFai / sellOpenLowFai));
        itemList.add(new ShowBean("9点40前买", before10Buy, before10BuySuc, getResult(before10Buy, before10BuySuc), before10BuySuc == 0 ? 0 : before10BuyAverageSuc / before10BuySuc, before10BuyFai == 0 ? 0 : before10BuyAverageFai / before10BuyFai));
        itemList.add(new ShowBean("上午买", amBuy, amBuySuc, getResult(amBuy, amBuySuc), amBuySuc == 0 ? 0 : amBuyAverageSuc / amBuySuc, amBuyFai == 0 ? 0 : amBuyAverageFai / amBuyFai));
        itemList.add(new ShowBean("下午买", pmBuy, pmBuySuc, getResult(pmBuy, pmBuySuc), pmBuySuc == 0 ? 0 : pmBuyAverageSuc / pmBuySuc, pmBuyFai == 0 ? 0 : pmBuyAverageFai / pmBuyFai));
        itemList.add(new ShowBean("主升模式", pullUpNum, pullUpSucNum, getResult(pullUpNum, pullUpSucNum), pullUpSucNum == 0 ? 0 : pullAverageSuc / pullUpSucNum, pullUpFaiNum == 0 ? 0 : pullAverageFai / pullUpFaiNum));
        itemList.add(new ShowBean("反弹", isRebound, isReboundSuc, getResult(isRebound, isReboundSuc), isReboundSuc == 0 ? 0 : reboundAverageSuc / isReboundSuc, isReboundFai == 0 ? 0 : reboundAverageFai / isReboundFai));
        itemList.add(new ShowBean("分歧转一致", turnedToOneNum, turnedToOneSucNum, getResult(turnedToOneNum, turnedToOneSucNum), turnedToOneSucNum == 0 ? 0 : turnedAverageSuc / turnedToOneSucNum, turnedToOneFaiNum == 0 ? 0 : turnedAverageFai / turnedToOneFaiNum));
        itemList.add(new ShowBean("当日追热点", isHot, isHotSuc, getResult(isHot, isHotSuc), isHotSuc == 0 ? 0 : hotAverageSuc / isHotSuc, isHotFai == 0 ? 0 : hotAverageFai / isHotFai));
        itemList.add(new ShowBean("打板买入", isBan, isBanSuc, getResult(isBan, isBanSuc), isBanSuc == 0 ? 0 : banAverageSuc / isBanSuc, isBanFai == 0 ? 0 : banAverageFai / isBanFai));
        itemList.add(new ShowBean("5点下买", low5buy, low5buySuc, getResult(low5buy, low5buySuc), low5buySuc == 0 ? 0 : low5buyAverageSuc / low5buySuc, low5buyFai == 0 ? 0 : low5buyAverageFai / low5buyFai));
        itemList.add(new ShowBean("5日线反弹", isRebound5, isRebound5Suc, getResult(isRebound5, isRebound5Suc), isRebound5Suc == 0 ? 0 : rebound5AverageSuc / isRebound5Suc, isRebound5Fai == 0 ? 0 : rebound5AverageFai / isRebound5Fai));
        itemList.add(new ShowBean("10日线反弹", isRebound10, isRebound10Suc, getResult(isRebound10, isRebound10Suc), isRebound10Suc == 0 ? 0 : rebound10AverageSuc / isRebound10Suc, isRebound10Fai == 0 ? 0 : rebound10AverageFai / isRebound10Fai));
        itemList.add(new ShowBean("20日线反弹", isRebound20, isRebound20Suc, getResult(isRebound20, isRebound20Suc), isRebound20Suc == 0 ? 0 : rebound20AverageSuc / isRebound20Suc, isRebound20Fai == 0 ? 0 : rebound20AverageFai / isRebound20Fai));
        itemList.add(new ShowBean("30日线反弹", isRebound30, isRebound30Suc, getResult(isRebound30, isRebound30Suc), isRebound30Suc == 0 ? 0 : rebound30AverageSuc / isRebound30Suc, isRebound30Fai == 0 ? 0 : rebound30AverageFai / isRebound30Fai));
        itemList.add(new ShowBean("沪深缩量", reduceAllTurnover, reduceAllTurnoverSuc, getResult(reduceAllTurnover, reduceAllTurnoverSuc), reduceAllTurnoverSuc == 0 ? 0 : reduceAllTurnoverAverageSuc / reduceAllTurnoverSuc, reduceAllTurnoverFai == 0 ? 0 : reduceAllTurnoverAverageFai / reduceAllTurnoverFai));
        itemList.add(new ShowBean("沪深平量", isAllTurnover, isAllTurnoverSuc, getResult(isAllTurnover, isAllTurnoverSuc), isAllTurnoverSuc == 0 ? 0 : allTurAverageSuc / isAllTurnoverSuc, isAllTurnoverFai == 0 ? 0 : allTurAverageFai / isAllTurnoverFai));
        itemList.add(new ShowBean("沪深增量", addAllTurnover, addAllTurnoverSuc, getResult(addAllTurnover, addAllTurnoverSuc), addAllTurnoverSuc == 0 ? 0 : addAllTurnoverAverageSuc / addAllTurnoverSuc, addAllTurnoverFai == 0 ? 0 : addAllTurnoverAverageFai / addAllTurnoverFai));
        itemList.add(new ShowBean("全增量高开", addAllTurnover, addAllTurnoverSellOpenHigh, getResult(addAllTurnover, addAllTurnoverSellOpenHigh), 0, 0));
        itemList.add(new ShowBean("全平量高开", isAllTurnover, isTurnoverSellOpenHigh, getResult(isAllTurnover, isTurnoverSellOpenHigh), 0, 0));
        itemList.add(new ShowBean("全缩量高开", reduceAllTurnover, reduceTurnoverSellOpenHigh, getResult(reduceAllTurnover, reduceTurnoverSellOpenHigh), 0, 0));
        itemList.add(new ShowBean("二板", twoBan, twoBanSuc, getResult(twoBan, twoBanSuc), twoBanSuc == 0 ? 0 : twoBanAverageSuc / twoBanSuc, twoBanFai == 0 ? 0 : twoBanAverageFai / twoBanFai));
        itemList.add(new ShowBean("三板", threeBan, threeBanSuc, getResult(threeBan, threeBanSuc), threeBanSuc == 0 ? 0 : threeBanAverageSuc / threeBanSuc, threeBanFai == 0 ? 0 : threeBanAverageFai / threeBanFai));
        itemList.add(new ShowBean("高位板", highBan, highBanSuc, getResult(highBan, highBanSuc), highBanSuc == 0 ? 0 : highBanAverageSuc / highBanSuc, highBanFai == 0 ? 0 : highBanAverageFai / highBanFai));
        originalList = new ArrayList<>(itemList); // 备份原始列表
    }

    public int getResult(int all, int suc) {
        int dividend = suc; // 被除数
        int divisor = all; // 除数
        if(all==0){
            return 0;
        }
        int result = (dividend * 100) / divisor;
        return result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(itemList.get(position).model);
        holder.all_time.setText(itemList.get(position).allTime + "次");
        holder.suc_time.setText(itemList.get(position).sucTime + "次");
        holder.radio.setText(itemList.get(position).ratio + "%");
        holder.averageSuc.setText(itemList.get(position).averageSuc + "%");
        holder.averageFai.setText(itemList.get(position).averageFai + "%");
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

    private List<StatisticsBean> returnData(ShowBean showBean) {
        switch (showBean.model) {
            case "总计":
                return data;
            case "打板买入":
                return data.stream()
                        .filter(bean -> bean.isIsBuyBan())
                        .collect(Collectors.toList());
            case "主升模式":
                return data.stream()
                        .filter(bean -> bean.isIsPullUp())
                        .collect(Collectors.toList());
            case "分歧转一致":
                return data.stream()
                        .filter(bean -> bean.isWhenBuyIsTurnedToOne())
                        .collect(Collectors.toList());
            case "反弹":
                return data.stream()
                        .filter(bean -> bean.isWhenBuyIsRebound())
                        .collect(Collectors.toList());
            case "当日追热点":
                return data.stream()
                        .filter(bean -> bean.isWhenBuyIsHot())
                        .collect(Collectors.toList());
            case "分时低点买":
                return data.stream()
                        .filter(bean -> bean.isIsBuyTimeKBottom())
                        .collect(Collectors.toList());
            case "5日线反弹":
                return data.stream()
                        .filter(bean -> bean.getReboundLine() == 5)
                        .collect(Collectors.toList());
            case "10日线反弹":
                return data.stream()
                        .filter(bean -> bean.getReboundLine() == 10)
                        .collect(Collectors.toList());
            case "20日线反弹":
                return data.stream()
                        .filter(bean -> bean.getReboundLine() == 20)
                        .collect(Collectors.toList());
            case "30日线反弹":
                return data.stream()
                        .filter(bean -> bean.getReboundLine() == 30)
                        .collect(Collectors.toList());
            case "沪深缩量":
                return data.stream()
                        .filter(bean -> bean.getAllTurnover() == -1)
                        .collect(Collectors.toList());
            case "沪深平量":
                return data.stream()
                        .filter(bean -> bean.getAllTurnover() == 0)
                        .collect(Collectors.toList());
            case "沪深增量":
                return data.stream()
                        .filter(bean -> bean.getReboundLine() == 1)
                        .collect(Collectors.toList());
            case "二板":
                return data.stream()
                        .filter(bean -> bean.isIsPullUp() && bean.getBuyBanNum() == 2)
                        .collect(Collectors.toList());
            case "三板":
                return data.stream()
                        .filter(bean -> bean.isIsPullUp() && bean.getBuyBanNum() == 3)
                        .collect(Collectors.toList());
            case "高位板":
                return data.stream()
                        .filter(bean -> bean.isIsPullUp() && bean.getBuyBanNum() > 3)
                        .collect(Collectors.toList());


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
                    return bean2.allTime - bean1.allTime;
                } else {
                    return bean1.allTime - bean2.allTime;
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
                    return bean2.sucTime - bean1.sucTime;
                } else {
                    return bean1.sucTime - bean2.sucTime;
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
                    return bean2.ratio - bean1.ratio;
                } else {
                    return bean1.ratio - bean2.ratio;
                }
            }
        });
        radio = !radio;
        notifyDataSetChanged();
    }

    public void changeAverageSucData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if (averageSuc) {
                    return bean2.averageSuc - bean1.averageSuc;
                } else {
                    return bean1.averageSuc - bean2.averageSuc;
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
                if (averageFai) {
                    return bean2.averageFai - bean1.averageFai;
                } else {
                    return bean1.averageFai - bean2.averageFai;
                }
            }
        });
        averageFai = !averageFai;
        notifyDataSetChanged();
    }

    public boolean isClockBefore(String tmp,int targetHour,int targetMinutes) {
        String[] timeParts = tmp.split(":"); // 拆分小时和分钟部分
        int hour = Integer.parseInt(timeParts[0]); // 小时
        int minute = Integer.parseInt(timeParts[1]); // 分钟

        if (hour<targetHour||(hour == targetHour && minute < targetMinutes)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isClockAfter(String tmp,int targetHour,int targetMinutes) {
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

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView all_time;
        TextView suc_time;
        TextView radio;
        TextView averageSuc;
        TextView averageFai;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            all_time = itemView.findViewById(R.id.all_time_txt);
            suc_time = itemView.findViewById(R.id.suc_time_text);
            radio = itemView.findViewById(R.id.radio_text);
            averageSuc = itemView.findViewById(R.id.average_suc_text);
            averageFai = itemView.findViewById(R.id.average_fai_text);
        }
    }

    private class ShowBean {
        private String model;
        private int allTime;
        private int sucTime;
        private int ratio;
        private int averageSuc;
        private int averageFai;

        private ShowBean(String model, int allTime, int sucTime, int ratio, int averageSuc) {
            this.model = model;
            this.allTime = allTime;
            this.sucTime = sucTime;
            this.ratio = ratio;
            this.averageSuc = averageSuc;
            this.averageFai = 0;
        }

        private ShowBean(String model, int allTime, int sucTime, int ratio, int averageSuc, int averageFai) {
            this.model = model;
            this.allTime = allTime;
            this.sucTime = sucTime;
            this.ratio = ratio;
            this.averageSuc = averageSuc;
            this.averageFai = averageFai;
        }
    }
}
