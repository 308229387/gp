package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class BiddingStatisticsBean implements Serializable {


    /**
     * gpName : 赛力斯
     * formerDate : 2023-10-10
     * banNum : 3
     * openHighPoint : 8.83
     * bidPrice : 55400
     * afterHigh : 5
     * description :
     * image_list : []
     */

    private String gpName;
    private String formerDate;
    private int banNum;
    private double openHighPoint;
    private int bidPrice;
    private int afterHigh;
    private String description;
    private List<?> image_list;

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

    public int getBanNum() {
        return banNum;
    }

    public void setBanNum(int banNum) {
        this.banNum = banNum;
    }

    public double getOpenHighPoint() {
        return openHighPoint;
    }

    public void setOpenHighPoint(double openHighPoint) {
        this.openHighPoint = openHighPoint;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getAfterHigh() {
        return afterHigh;
    }

    public void setAfterHigh(int afterHigh) {
        this.afterHigh = afterHigh;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<?> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<?> image_list) {
        this.image_list = image_list;
    }
}
