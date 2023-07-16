package com.songyongmeng.gp.utils;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {


    /**
     * gpName : 睿能科技                 股票名称
     * suc : false                      是否盈利
     * resultPoint : 5                  最终点位
     * autoStopSuc:false,               是不是自动止盈
     * autoStopLoss:false,              是不是自动止损
     * buyPoint : 7                     买点
     * sellPoint : -8                   卖点
     * holdDays : 1                     持有天数
     * buyDate : 2022-07-13             买入日期
     * buyTime : 10:02                  买入时间点
     * sellTime : 13:35                 卖出时间点
     * isPullUp : true                  是否是主升
     * whenBuyIsTurnedToOne : false     买入逻辑是不是分歧转一至
     * isRebound : false                买入逻辑是不是反弹
     * isBuyBan : false                 是不是打板买的
     * reboundLine : 0                  反弹均线数
     * buyBanNum : 3                    购买当天是几板
     * buyKTop : true                   是不是买在了k线顶部
     * sellAfterMiss : false            卖后有没有涨
     * beforeThought : 版块涨的好         买前怎么想的
     * afterThought : 弱并未转强          卖后怎么想的
     * buyQuantity : 2                  买时成交量0-10，无量到爆量
     * endQuantity : 3                  当天成交量0-10，无量到爆量
     * environment : 2                  给环境打分0-10，差到很强
     * image : fail_38                  交易图
     */
    private int spanCount; // 列数
    private int spacing; // 间距
    private boolean includeEdge; // 是否包含边缘

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // Item 的位置
        int column = position % spanCount; // 列索引

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column + 1) * spacing / spanCount;
            if (position < spanCount) {
                outRect.top = 0; // 上间距设为零
            }
            outRect.bottom = 0; // 下间距设为零
        } else {
            outRect.left = column * spacing / spanCount;
            outRect.right = spacing - (column + 1) * spacing / spanCount;
            if (position >= spanCount) {
                outRect.top = -spacing; // 上间距设为负值，将 Item 向上偏移
            }
            outRect.bottom = 0; // 下间距设为零
        }
    }
}
