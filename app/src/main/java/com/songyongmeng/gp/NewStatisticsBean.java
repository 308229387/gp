package com.songyongmeng.gp;

import java.io.Serializable;

public class NewStatisticsBean implements Serializable {
    /**
     * gpName : 金科股份
     * formerDate : 2023-08-29
     * mode : 2
     * lastPrice : 1.55
     * isBanBuy : false
     * resultPoint : 4.5
     * buyReason :
     * image_k :
     * image_buy :
     * image_sell :
     */

    private String gpName;
    private String formerDate;
    private int mode;
    private double lastPrice;
    private boolean isBanBuy;
    private double resultPoint;
    private String buyReason;
    private String image_k;
    private String image_buy;
    private String image_sell;

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

    public String getImage_k() {
        return image_k;
    }

    public void setImage_k(String image_k) {
        this.image_k = image_k;
    }

    public String getImage_buy() {
        return image_buy;
    }

    public void setImage_buy(String image_buy) {
        this.image_buy = image_buy;
    }

    public String getImage_sell() {
        return image_sell;
    }

    public void setImage_sell(String image_sell) {
        this.image_sell = image_sell;
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
