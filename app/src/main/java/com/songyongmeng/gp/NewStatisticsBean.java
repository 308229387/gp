package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class NewStatisticsBean implements Serializable {
    /**
     * gpName : 哈空调
     * formerDate : 2023-09-18
     * mode : 2
     * lastPrice : 0.036
     * failureReason : [2]
     * isBanBuy : true
     * resultPoint : -1.14
     * buyReason : 环境很差，几乎所有二板都不顺利，哈空调早盘拉板，形态也还可以，有1个亿的封单，炸板回封上车，但也很弱。自己明明已经预测了冰点的到来，还是上了仓位。
     * image_list : ["apgd_k","apgd_b","apgd_s"]
     */

    private String gpName;
    private String formerDate;
    private int mode;
    private int sellTiming;
    private int phase;
    private int hasDay;
    private double bigPrice;
    private double lastPrice;
    private boolean isBanBuy;
    private double resultPoint;
    private String buyReason;
    private List<Integer> failureReason;
    private List<String> image_list;

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isBanBuy() {
        return isBanBuy;
    }

    public void setBanBuy(boolean banBuy) {
        isBanBuy = banBuy;
    }

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

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getSellTiming() {
        return sellTiming;
    }

    public void setSellTiming(int sellTiming) {
        this.sellTiming = sellTiming;
    }

    public double getBigPrice() {
        return bigPrice;
    }

    public void setBigPrice(double bigPrice) {
        this.bigPrice = bigPrice;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public boolean isIsBanBuy() {
        return isBanBuy;
    }

    public void setIsBanBuy(boolean isBanBuy) {
        this.isBanBuy = isBanBuy;
    }

    public double getResultPoint() {
        return resultPoint;
    }

    public void setResultPoint(double resultPoint) {
        this.resultPoint = resultPoint;
    }

    public String getBuyReason() {
        return buyReason;
    }

    public void setBuyReason(String buyReason) {
        this.buyReason = buyReason;
    }

    public List<Integer> getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(List<Integer> failureReason) {
        this.failureReason = failureReason;
    }

    public List<String> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<String> image_list) {
        this.image_list = image_list;
    }

    public int getHasDay() {
        return hasDay;
    }

    public void setHasDay(int hasDay) {
        this.hasDay = hasDay;
    }

    /*    mode购买类型解释
    1: 首板
    2: 一进二
    3: 二进三
    4: 三进四
    5: 高位
    6:
    10: 10日线回踩
    */


}
