package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class NewStatisticsBean implements Serializable {
    /**
     * gpName : 中国武夷
     * formerDate : 2023-09-06
     * mode : 1
     * lastPrice : 0.24
     * isBanBuy : true
     * marginTrading : false
     * resultPoint : 3.5
     * buyReason : 下午快速上板，炸后排，上车后，第二天过高点离场，
     * image_list : ["djx_demo_3","djx_demo_3"]
     */

    private String gpName;
    private String formerDate;
    private int mode;
    private double lastPrice;
    private boolean isBanBuy;
    private double resultPoint;
    private String buyReason;
    private List<String> image_list;

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

    public List<String> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<String> image_list) {
        this.image_list = image_list;
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
