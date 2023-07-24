package com.songyongmeng.gp;

import java.io.Serializable;

public class FenQiBean implements Serializable {
    /**
     * gpName : 荣盛发展                     股票名称
     * formerBanTime : 10:01                当天上板时间
     * lastPrice : 11.6                     当天最终封单(亿)
     * banHasOpen : false                   是否开板过
     * formerOpenPoint : -1.85              当天开盘点位
     * latterOpenPoint : 0.0                次日开盘点位
     * latterStartPullUp : false            开盘就拉升
     * latterTopPoint : 0.0                 次日最高点位
     * latterTopPointTime : 10:01           最高点出现时间
     * latterAveragePoint : 0.0             次日平均点位
     * latterLowPoint : 0.0                 次日最低点位
     * latterLowPointTime : 10:01           次日最低点位出现时间
     * afterHigh : 0                        后期空间
     * formerGroupPoint : 2.52              当天版块点位
     * formerGroupTurnover : 1.25           当天版块量与前天对比
     * hasBeforeTop : false                 是否有前高
     * hasHighLevelLinePin : false          是否有高级别均线压制
     * selfTurnover : 68                    股票当天量与前一天对比
     * yesterdaySelfTurnover : 217          前一天量与大前天对比
     * yesterdayAllTurnover : 112          前一天市场量与大前天对比
     * yesterdaySelfBanNum : 2              前一天股票几板
     * yesterdayAllBanNum : 29              前一天市场有几个涨停
     * yesterdayAllTopBanNum : 5            前一天最高板
     * formerAllTurnover : 1.12             当天市场量能与前一天对比
     * formerDate : 2023-07-21              当天日期
     * formerAllValue : 92.74               触发当天总流通市场
     * formerImage : fail_38                当天图
     * latterImage : fail_38                次日图
     */
    private String gpName;
    private double formerAllValue;
    private String formerDate;
    private double afterHigh;
    private String formerBanTime;
    private double lastPrice;
    private boolean banHasOpen;
    private double formerOpenPoint;
    private double latterOpenPoint;
    private double latterTopPoint;
    private String latterTopPointTime;
    private double latterAveragePoint;
    private double latterLowPoint;
    private String latterLowPointTime;
    private double formerGroupPoint;
    private double formerGroupTurnover;
    private boolean latterStartPullUp;
    private boolean hasBeforeTop;
    private boolean hasHighLevelLinePin;
    private double selfTurnover;
    private double yesterdaySelfTurnover;
    private double yesterdayAllTurnover;
    private int yesterdaySelfBanNum;
    private int yesterdayAllBanNum;
    private int yesterdayAllTopBanNum;
    private double formerAllTurnover;
    private String formerImage;
    private String latterImage;

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public double getFormerAllValue() {
        return formerAllValue;
    }

    public void setFormerAllValue(double formerAllValue) {
        this.formerAllValue = formerAllValue;
    }

    public String getFormerDate() {
        return formerDate;
    }

    public void setFormerDate(String formerDate) {
        this.formerDate = formerDate;
    }

    public double getAfterHigh() {
        return afterHigh;
    }

    public void setAfterHigh(double afterHigh) {
        this.afterHigh = afterHigh;
    }

    public String getFormerBanTime() {
        return formerBanTime;
    }

    public void setFormerBanTime(String formerBanTime) {
        this.formerBanTime = formerBanTime;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public boolean isBanHasOpen() {
        return banHasOpen;
    }

    public void setBanHasOpen(boolean banHasOpen) {
        this.banHasOpen = banHasOpen;
    }

    public double getFormerOpenPoint() {
        return formerOpenPoint;
    }

    public void setFormerOpenPoint(double formerOpenPoint) {
        this.formerOpenPoint = formerOpenPoint;
    }

    public double getLatterOpenPoint() {
        return latterOpenPoint;
    }

    public void setLatterOpenPoint(double latterOpenPoint) {
        this.latterOpenPoint = latterOpenPoint;
    }

    public double getLatterTopPoint() {
        return latterTopPoint;
    }

    public void setLatterTopPoint(double latterTopPoint) {
        this.latterTopPoint = latterTopPoint;
    }

    public String getLatterTopPointTime() {
        return latterTopPointTime;
    }

    public void setLatterTopPointTime(String latterTopPointTime) {
        this.latterTopPointTime = latterTopPointTime;
    }

    public double getLatterAveragePoint() {
        return latterAveragePoint;
    }

    public void setLatterAveragePoint(double latterAveragePoint) {
        this.latterAveragePoint = latterAveragePoint;
    }

    public double getLatterLowPoint() {
        return latterLowPoint;
    }

    public void setLatterLowPoint(double latterLowPoint) {
        this.latterLowPoint = latterLowPoint;
    }

    public String getLatterLowPointTime() {
        return latterLowPointTime;
    }

    public void setLatterLowPointTime(String latterLowPointTime) {
        this.latterLowPointTime = latterLowPointTime;
    }

    public double getFormerGroupPoint() {
        return formerGroupPoint;
    }

    public void setFormerGroupPoint(double formerGroupPoint) {
        this.formerGroupPoint = formerGroupPoint;
    }

    public double getFormerGroupTurnover() {
        return formerGroupTurnover;
    }

    public void setFormerGroupTurnover(double formerGroupTurnover) {
        this.formerGroupTurnover = formerGroupTurnover;
    }

    public boolean isLatterStartPullUp() {
        return latterStartPullUp;
    }

    public void setLatterStartPullUp(boolean latterStartPullUp) {
        this.latterStartPullUp = latterStartPullUp;
    }

    public boolean isHasBeforeTop() {
        return hasBeforeTop;
    }

    public void setHasBeforeTop(boolean hasBeforeTop) {
        this.hasBeforeTop = hasBeforeTop;
    }

    public boolean isHasHighLevelLinePin() {
        return hasHighLevelLinePin;
    }

    public void setHasHighLevelLinePin(boolean hasHighLevelLinePin) {
        this.hasHighLevelLinePin = hasHighLevelLinePin;
    }

    public double getSelfTurnover() {
        return selfTurnover;
    }

    public void setSelfTurnover(double selfTurnover) {
        this.selfTurnover = selfTurnover;
    }

    public double getYesterdaySelfTurnover() {
        return yesterdaySelfTurnover;
    }

    public void setYesterdaySelfTurnover(double yesterdaySelfTurnover) {
        this.yesterdaySelfTurnover = yesterdaySelfTurnover;
    }

    public double getYesterdayAllTurnover() {
        return yesterdayAllTurnover;
    }

    public void setYesterdayAllTurnover(double yesterdayAllTurnover) {
        this.yesterdayAllTurnover = yesterdayAllTurnover;
    }

    public int getYesterdaySelfBanNum() {
        return yesterdaySelfBanNum;
    }

    public void setYesterdaySelfBanNum(int yesterdaySelfBanNum) {
        this.yesterdaySelfBanNum = yesterdaySelfBanNum;
    }

    public int getYesterdayAllBanNum() {
        return yesterdayAllBanNum;
    }

    public void setYesterdayAllBanNum(int yesterdayAllBanNum) {
        this.yesterdayAllBanNum = yesterdayAllBanNum;
    }

    public int getYesterdayAllTopBanNum() {
        return yesterdayAllTopBanNum;
    }

    public void setYesterdayAllTopBanNum(int yesterdayAllTopBanNum) {
        this.yesterdayAllTopBanNum = yesterdayAllTopBanNum;
    }

    public double getFormerAllTurnover() {
        return formerAllTurnover;
    }

    public void setFormerAllTurnover(double formerAllTurnover) {
        this.formerAllTurnover = formerAllTurnover;
    }

    public String getFormerImage() {
        return formerImage;
    }

    public void setFormerImage(String formerImage) {
        this.formerImage = formerImage;
    }

    public String getLatterImage() {
        return latterImage;
    }

    public void setLatterImage(String latterImage) {
        this.latterImage = latterImage;
    }



}
