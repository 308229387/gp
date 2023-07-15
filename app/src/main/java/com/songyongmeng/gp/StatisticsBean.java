package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class StatisticsBean implements Serializable {


    /**
     * name : 分歧转一至
     * data : [{"gpName":"上海物贸","suc":true,"resultPoint":4,"buyPoint":-3,"time":"2022-01-01","buyTime":"09:33","sellPoint":-3,"sellTime":"09:33","buyTop":false,"afterSlip":true,"beforeThought":"before","afterThought":"after","environment":2,"quantity":2,"image":"xintai"},{"gpName":"光迅科技","suc":true,"resultPoint":4,"buyPoint":-3,"time":"2022-01-01","buyTime":"09:33","sellPoint":-3,"sellTime":"09:33","buyTop":false,"afterSlip":true,"beforeThought":"before","afterThought":"after","environment":2,"quantity":2,"image":"xintai"}]
     */

    private String name;
    private List<DataBean> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * gpName : 上海物贸
         * suc : true
         * resultPoint : 4
         * buyPoint : -3
         * time : 2022-01-01
         * buyTime : 09:33
         * sellPoint : -3
         * sellTime : 09:33
         * buyTop : false
         * afterSlip : true
         * beforeThought : before
         * afterThought : after
         * environment : 2
         * quantity : 2
         * image : xintai
         */

        private String gpName;
        private boolean suc;
        private int resultPoint;
        private int buyPoint;
        private String time;
        private String buyTime;
        private int sellPoint;
        private String sellTime;
        private boolean buyTop;
        private boolean afterSlip;
        private String beforeThought;
        private String afterThought;
        private int environment;
        private int quantity;
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

        public int getBuyPoint() {
            return buyPoint;
        }

        public void setBuyPoint(int buyPoint) {
            this.buyPoint = buyPoint;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getBuyTime() {
            return buyTime;
        }

        public void setBuyTime(String buyTime) {
            this.buyTime = buyTime;
        }

        public int getSellPoint() {
            return sellPoint;
        }

        public void setSellPoint(int sellPoint) {
            this.sellPoint = sellPoint;
        }

        public String getSellTime() {
            return sellTime;
        }

        public void setSellTime(String sellTime) {
            this.sellTime = sellTime;
        }

        public boolean isBuyTop() {
            return buyTop;
        }

        public void setBuyTop(boolean buyTop) {
            this.buyTop = buyTop;
        }

        public boolean isAfterSlip() {
            return afterSlip;
        }

        public void setAfterSlip(boolean afterSlip) {
            this.afterSlip = afterSlip;
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

        public int getEnvironment() {
            return environment;
        }

        public void setEnvironment(int environment) {
            this.environment = environment;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
