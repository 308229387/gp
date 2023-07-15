package com.songyongmeng.gp.utils;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
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
