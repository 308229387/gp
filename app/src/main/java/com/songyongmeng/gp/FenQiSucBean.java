package com.songyongmeng.gp;

import java.io.Serializable;

public class FenQiSucBean implements Serializable {


    /**
     * gpName : 启迪环境
     * formerDate : 2023-08-21
     * formerAllValue : 59.71
     * yesterdaySelfTurnover : 265.13
     * selfTurnover : 37.97
     * yesterdayStartPoint : 3.94
     * yesterdayAveragePoint : 9.19
     * formerStartPoint : 6.21
     * formerAveragePoint : 8.35
     * compareHigh : 2.27
     * afterHigh : 10.01
     * yesterdayLastPrice : 0.4
     * lastPrice : 0.76
     * bidStrong : 1
     * bidBreakTime : 09:24
     * formerBanTime : 09:31
     * lastHasBuy : false
     * image : qdhj_3_bid
     */

    private String gpName;
    private String formerDate;
    private double formerAllValue;
    private double yesterdaySelfTurnover;
    private double selfTurnover;
    private double yesterdayStartPoint;
    private double yesterdayAveragePoint;
    private double formerStartPoint;
    private double formerAveragePoint;
    private double compareHigh;
    private double afterHigh;
    private double yesterdayLastPrice;
    private double lastPrice;
    private int bidStrong;
    private String bidBreakTime;
    private String formerBanTime;
    private boolean lastHasBuy;
    private String image;

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public String getFormerDate() {
        return formerDate;
    }

    public void setFormerDate(String formerDate) {
        this.formerDate = formerDate;
    }

    public double getFormerAllValue() {
        return formerAllValue;
    }

    public void setFormerAllValue(double formerAllValue) {
        this.formerAllValue = formerAllValue;
    }

    public double getYesterdaySelfTurnover() {
        return yesterdaySelfTurnover;
    }

    public void setYesterdaySelfTurnover(double yesterdaySelfTurnover) {
        this.yesterdaySelfTurnover = yesterdaySelfTurnover;
    }

    public double getSelfTurnover() {
        return selfTurnover;
    }

    public void setSelfTurnover(double selfTurnover) {
        this.selfTurnover = selfTurnover;
    }

    public double getYesterdayStartPoint() {
        return yesterdayStartPoint;
    }

    public void setYesterdayStartPoint(double yesterdayStartPoint) {
        this.yesterdayStartPoint = yesterdayStartPoint;
    }

    public double getYesterdayAveragePoint() {
        return yesterdayAveragePoint;
    }

    public void setYesterdayAveragePoint(double yesterdayAveragePoint) {
        this.yesterdayAveragePoint = yesterdayAveragePoint;
    }

    public double getFormerStartPoint() {
        return formerStartPoint;
    }

    public void setFormerStartPoint(double formerStartPoint) {
        this.formerStartPoint = formerStartPoint;
    }

    public double getFormerAveragePoint() {
        return formerAveragePoint;
    }

    public void setFormerAveragePoint(double formerAveragePoint) {
        this.formerAveragePoint = formerAveragePoint;
    }

    public double getCompareHigh() {
        return compareHigh;
    }

    public void setCompareHigh(double compareHigh) {
        this.compareHigh = compareHigh;
    }

    public double getAfterHigh() {
        return afterHigh;
    }

    public void setAfterHigh(double afterHigh) {
        this.afterHigh = afterHigh;
    }

    public double getYesterdayLastPrice() {
        return yesterdayLastPrice;
    }

    public void setYesterdayLastPrice(double yesterdayLastPrice) {
        this.yesterdayLastPrice = yesterdayLastPrice;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public int getBidStrong() {
        return bidStrong;
    }

    public void setBidStrong(int bidStrong) {
        this.bidStrong = bidStrong;
    }

    public String getBidBreakTime() {
        return bidBreakTime;
    }

    public void setBidBreakTime(String bidBreakTime) {
        this.bidBreakTime = bidBreakTime;
    }

    public String getFormerBanTime() {
        return formerBanTime;
    }

    public void setFormerBanTime(String formerBanTime) {
        this.formerBanTime = formerBanTime;
    }

    public boolean isLastHasBuy() {
        return lastHasBuy;
    }

    public void setLastHasBuy(boolean lastHasBuy) {
        this.lastHasBuy = lastHasBuy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
