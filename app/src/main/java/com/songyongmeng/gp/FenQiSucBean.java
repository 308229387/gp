package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class FenQiSucBean implements Serializable {


    /**
     * gpName : 张江高科
     * afterHigh : 15.01
     * bidStrong : 0
     * compareHigh : -2.06
     * selfTurnover : 49.09
     * bidBreakTime : 09:18
     * formerBanTime : 09:32
     * formerStartPoint : 5.5
     * formerAveragePoint : 7.9
     * bidPrice : 23900.0
     * yesterdaySelfTurnover : 172.64
     * yesterdayStartPoint : 7.57
     * yesterdayAveragePoint : 8.13
     * lastPrice : 4.89
     * yesterdayLastPrice : 1.27
     * formerLargeOrder : 15.3
     * yesterdayLargeOrder : 16.2
     * firstDayLargeOrder : 44.0
     * formerAllValue : 303.85
     * formerDate : 2023-09-08
     * image_list : ["apgd_k","qdhj_b","apgd_s"]
     */

    private String gpName;
    private double afterHigh;
    private int bidStrong;
    private double compareHigh;
    private double selfTurnover;
    private String bidBreakTime;
    private String formerBanTime;
    private double formerStartPoint;
    private double formerAveragePoint;
    private double bidPrice;
    private double yesterdaySelfTurnover;
    private double yesterdayStartPoint;
    private double yesterdayAveragePoint;
    private double lastPrice;
    private double yesterdayLastPrice;
    private double formerLargeOrder;
    private double yesterdayLargeOrder;
    private double firstDayLargeOrder;
    private double formerAllValue;
    private String formerDate;
    private List<String> image_list;

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public double getAfterHigh() {
        return afterHigh;
    }

    public void setAfterHigh(double afterHigh) {
        this.afterHigh = afterHigh;
    }

    public int getBidStrong() {
        return bidStrong;
    }

    public void setBidStrong(int bidStrong) {
        this.bidStrong = bidStrong;
    }

    public double getCompareHigh() {
        return compareHigh;
    }

    public void setCompareHigh(double compareHigh) {
        this.compareHigh = compareHigh;
    }

    public double getSelfTurnover() {
        return selfTurnover;
    }

    public void setSelfTurnover(double selfTurnover) {
        this.selfTurnover = selfTurnover;
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

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getYesterdaySelfTurnover() {
        return yesterdaySelfTurnover;
    }

    public void setYesterdaySelfTurnover(double yesterdaySelfTurnover) {
        this.yesterdaySelfTurnover = yesterdaySelfTurnover;
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

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getYesterdayLastPrice() {
        return yesterdayLastPrice;
    }

    public void setYesterdayLastPrice(double yesterdayLastPrice) {
        this.yesterdayLastPrice = yesterdayLastPrice;
    }

    public double getFormerLargeOrder() {
        return formerLargeOrder;
    }

    public void setFormerLargeOrder(double formerLargeOrder) {
        this.formerLargeOrder = formerLargeOrder;
    }

    public double getYesterdayLargeOrder() {
        return yesterdayLargeOrder;
    }

    public void setYesterdayLargeOrder(double yesterdayLargeOrder) {
        this.yesterdayLargeOrder = yesterdayLargeOrder;
    }

    public double getFirstDayLargeOrder() {
        return firstDayLargeOrder;
    }

    public void setFirstDayLargeOrder(double firstDayLargeOrder) {
        this.firstDayLargeOrder = firstDayLargeOrder;
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

    public List<String> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<String> image_list) {
        this.image_list = image_list;
    }
}
