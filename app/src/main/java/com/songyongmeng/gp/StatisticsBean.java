package com.songyongmeng.gp;

import java.io.Serializable;

public class StatisticsBean implements Serializable {
    /**
     * gpName : 睿能科技                 股票名称
     * suc : false                      是否盈利
     * resultPoint : 5                  最终点位
     * autoStopSuc:false,               是不是自动止盈
     * autoStopLoss:false,              是不是自动止损
     * buyPoint : 7                     买点
     * sellPoint : -8                   卖点
     * holdDays : 1                     持有天数
     * buyDate : 2022-07-13             买入日期
     * buyTime : 10:02                  买入时间点
     * sellTime : 13:35                 卖出时间点
     * isPullUp : true                  是否是主升
     * whenBuyIsTurnedToOne : false     买入逻辑是不是分歧转一至
     * whenBuyIsRebound : false         买入逻辑是不是反弹
     * whenBuyIsHot : false             当天是不是追的热点
     * isBuyBan : false                 是不是打板买的
     * isBuyTimeKBottom : false         是不是想分时内低点
     * reboundLine : 0                  反弹均线数
     * buyBanNum : 3                    购买当天是几板
     * buyKTop : true                   是不是买在了k线顶部
     * sellAfterMiss : false            卖后大涨，卖飞
     * hasTopButMiss : false            有高点没卖错过了
     * beforeThought : 版块涨的好         买前怎么想的
     * afterThought : 弱并未转强          卖后怎么想的
     * buyQuantity : 6                  买时成交量0-10，无量到爆量
     * endQuantity : 9                  当天成交量0-10，无量到爆量
     * environment : 7                  给环境打分0-10，差到很强
     * image : fail_38                  交易图
     */



    private String gpName;
    private boolean suc;
    private int resultPoint;
    private boolean autoStopSuc;
    private boolean autoStopLoss;
    private int buyPoint;
    private int sellPoint;
    private int holdDays;
    private String buyDate;
    private String buyTime;
    private String sellTime;
    private boolean isPullUp;
    private boolean whenBuyIsTurnedToOne;
    private boolean whenBuyIsRebound;
    private boolean whenBuyIsHot;
    private boolean isBuyBan;
    private boolean isBuyTimeKBottom;
    private int reboundLine;
    private int buyBanNum;
    private boolean buyKTop;
    private boolean sellAfterMiss;
    private boolean hasTopButMiss;
    private String beforeThought;
    private String afterThought;
    private int buyQuantity;
    private int endQuantity;
    private int environment;
    private String image;

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public int getResultPoint() {
        return resultPoint;
    }

    public void setResultPoint(int resultPoint) {
        this.resultPoint = resultPoint;
    }

    public boolean isAutoStopSuc() {
        return autoStopSuc;
    }

    public void setAutoStopSuc(boolean autoStopSuc) {
        this.autoStopSuc = autoStopSuc;
    }

    public boolean isAutoStopLoss() {
        return autoStopLoss;
    }

    public void setAutoStopLoss(boolean autoStopLoss) {
        this.autoStopLoss = autoStopLoss;
    }

    public int getBuyPoint() {
        return buyPoint;
    }

    public void setBuyPoint(int buyPoint) {
        this.buyPoint = buyPoint;
    }

    public int getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(int sellPoint) {
        this.sellPoint = sellPoint;
    }

    public int getHoldDays() {
        return holdDays;
    }

    public void setHoldDays(int holdDays) {
        this.holdDays = holdDays;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }

    public boolean isIsPullUp() {
        return isPullUp;
    }

    public void setIsPullUp(boolean isPullUp) {
        this.isPullUp = isPullUp;
    }

    public boolean isWhenBuyIsTurnedToOne() {
        return whenBuyIsTurnedToOne;
    }

    public void setWhenBuyIsTurnedToOne(boolean whenBuyIsTurnedToOne) {
        this.whenBuyIsTurnedToOne = whenBuyIsTurnedToOne;
    }

    public boolean isWhenBuyIsRebound() {
        return whenBuyIsRebound;
    }

    public void setWhenBuyIsRebound(boolean whenBuyIsRebound) {
        this.whenBuyIsRebound = whenBuyIsRebound;
    }

    public boolean isWhenBuyIsHot() {
        return whenBuyIsHot;
    }

    public void setWhenBuyIsHot(boolean whenBuyIsHot) {
        this.whenBuyIsHot = whenBuyIsHot;
    }

    public boolean isIsBuyBan() {
        return isBuyBan;
    }

    public void setIsBuyBan(boolean isBuyBan) {
        this.isBuyBan = isBuyBan;
    }

    public boolean isIsBuyTimeKBottom() {
        return isBuyTimeKBottom;
    }

    public void setIsBuyTimeKBottom(boolean isBuyTimeKBottom) {
        this.isBuyTimeKBottom = isBuyTimeKBottom;
    }

    public int getReboundLine() {
        return reboundLine;
    }

    public void setReboundLine(int reboundLine) {
        this.reboundLine = reboundLine;
    }

    public int getBuyBanNum() {
        return buyBanNum;
    }

    public void setBuyBanNum(int buyBanNum) {
        this.buyBanNum = buyBanNum;
    }

    public boolean isBuyKTop() {
        return buyKTop;
    }

    public void setBuyKTop(boolean buyKTop) {
        this.buyKTop = buyKTop;
    }

    public boolean isSellAfterMiss() {
        return sellAfterMiss;
    }

    public void setSellAfterMiss(boolean sellAfterMiss) {
        this.sellAfterMiss = sellAfterMiss;
    }

    public boolean isHasTopButMiss() {
        return hasTopButMiss;
    }

    public void setHasTopButMiss(boolean hasTopButMiss) {
        this.hasTopButMiss = hasTopButMiss;
    }

    public String getBeforeThought() {
        return beforeThought;
    }

    public void setBeforeThought(String beforeThought) {
        this.beforeThought = beforeThought;
    }

    public String getAfterThought() {
        return afterThought;
    }

    public void setAfterThought(String afterThought) {
        this.afterThought = afterThought;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public int getEndQuantity() {
        return endQuantity;
    }

    public void setEndQuantity(int endQuantity) {
        this.endQuantity = endQuantity;
    }

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
