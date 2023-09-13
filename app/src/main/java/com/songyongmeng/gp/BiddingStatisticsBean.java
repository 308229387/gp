package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class BiddingStatisticsBean implements Serializable {

    /**
     * gpName : 亚太股份
     * formerDate : 2023-09-11
     * banNum : 2
     * howHigh : 10
     * yesterdayLastPrice : 1135
     * afterHigh : 0
     * description :
     * image_list : []
     */

    private String gpName;
    private String formerDate;
    private int banNum;
    private int howHigh;
    private int yesterdayLastPrice;
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

    public int getHowHigh() {
        return howHigh;
    }

    public void setHowHigh(int howHigh) {
        this.howHigh = howHigh;
    }

    public int getYesterdayLastPrice() {
        return yesterdayLastPrice;
    }

    public void setYesterdayLastPrice(int yesterdayLastPrice) {
        this.yesterdayLastPrice = yesterdayLastPrice;
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
