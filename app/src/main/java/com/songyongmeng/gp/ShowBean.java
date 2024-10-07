package com.songyongmeng.gp;

import lombok.Data;

public class ShowBean {
    private String model;
    private int allTime;
    private int sucTime;
    private int ratio;
    private int ban;
    private double averageSuc;
    private double averageFai;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAllTime() {
        return allTime;
    }

    public void setAllTime(int allTime) {
        this.allTime = allTime;
    }

    public int getSucTime() {
        return sucTime;
    }

    public void setSucTime(int sucTime) {
        this.sucTime = sucTime;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public double getAverageSuc() {
        return averageSuc;
    }

    public void setAverageSuc(double averageSuc) {
        this.averageSuc = averageSuc;
    }

    public double getAverageFai() {
        return averageFai;
    }

    public void setAverageFai(double averageFai) {
        this.averageFai = averageFai;
    }
}
