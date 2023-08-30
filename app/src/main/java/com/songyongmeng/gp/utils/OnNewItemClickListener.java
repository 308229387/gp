package com.songyongmeng.gp.utils;

import com.songyongmeng.gp.NewStatisticsBean;
import com.songyongmeng.gp.StatisticsBean;

import java.util.List;

public interface OnNewItemClickListener {
    void onItemClick(List<NewStatisticsBean> position);
}
