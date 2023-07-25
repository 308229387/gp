package com.songyongmeng.gp;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FenQiAdapter extends RecyclerView.Adapter<FenQiAdapter.MyViewHolder> {
    private List<FenQiBean> mDataList;
    private List<FenQiBean> originalFenQiList;
    Comparator<FenQiBean> comparator;
    private boolean latterAverage;
    private boolean latterStart;
    private boolean formerBanTime;
    private boolean lastPrice;
    private boolean banScore;

    public FenQiAdapter(List<FenQiBean> dataList) {
        this.mDataList = dataList;
        originalFenQiList = new ArrayList<>(mDataList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fen_qi_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FenQiBean data = mDataList.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void recoverFenQiData() {
        mDataList.clear();
        mDataList.addAll(originalFenQiList);
        notifyDataSetChanged();
    }

    public void changeLatterAverageData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (latterAverage) {
                    return Double.compare(bean1.getLatterAveragePoint(), bean2.getLatterAveragePoint());
                } else {
                    return Double.compare(bean2.getLatterAveragePoint(), bean1.getLatterAveragePoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        latterAverage = !latterAverage;
        notifyDataSetChanged();
    }

    public void changeLatterStartPointData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (latterStart) {
                    return Double.compare(bean1.getLatterStartPoint(), bean2.getLatterStartPoint());
                } else {
                    return Double.compare(bean2.getLatterStartPoint(), bean1.getLatterStartPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        latterStart = !latterStart;
        notifyDataSetChanged();
    }

    public void changeFormerBanTime() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (formerBanTime) {
                    return bean2.getFormerBanTime().compareTo(bean1.getFormerBanTime());
                } else {
                    return bean1.getFormerBanTime().compareTo(bean2.getFormerBanTime());
                }
            }
        };
        Collections.sort(mDataList, comparator);
        formerBanTime = !formerBanTime;
        notifyDataSetChanged();
    }

    public void changeLastPriceData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (lastPrice) {
                    return Double.compare(bean1.getLastPrice(), bean2.getLastPrice());
                } else {
                    return Double.compare(bean2.getLastPrice(), bean1.getLastPrice());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        lastPrice = !lastPrice;
        notifyDataSetChanged();
    }

    public void changeYesterdaySelfBanScoreData() {
        Collections.sort(mDataList, new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (banScore) {
                    return bean2.getYesterdaySelfBanScore() - bean1.getYesterdaySelfBanScore();
                } else {
                    return bean1.getYesterdaySelfBanScore() - bean2.getYesterdaySelfBanScore();
                }
            }
        });
        banScore = !banScore;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }

        public void bindData(FenQiBean data) {
            // 清空容器中的所有子视图
            linearLayout.removeAllViews();

            // 动态添加 TextView
            for (int i = 0; i < 29; i++) {
                TextView textView = new TextView(itemView.getContext());
                if (i == 28) {
                    textView.setWidth(270); // 设置宽度为200像素
                } else {
                    textView.setWidth(250); // 设置宽度为200像素
                }
                textView.setHeight(100);
                textView.setGravity(Gravity.CENTER);
                if (data.getLatterAveragePoint() > 0) {
                    textView.setBackgroundColor(Color.parseColor("#FFC0CB"));
                } else {
                    textView.setBackgroundColor(Color.parseColor("#90EE90"));
                }
                switch (i) {
                    case 0:
                        textView.setText(data.getGpName());
                        break;
                    case 1:
                        textView.setText(data.getLatterStartPoint() + "%");
                        break;
                    case 2:
                        textView.setText(data.getLatterAveragePoint() + "%");
                        break;
                    case 3:
                        textView.setText(data.getLatterTopPoint() + "%");
                        break;
                    case 4:
                        textView.setText(data.getLatterTopPointTime());
                        break;
                    case 5:
                        textView.setText(data.getFormerBanTime());
                        break;
                    case 6:
                        textView.setText(data.getLastPrice() + "亿");
                        break;
                    case 7:
                        textView.setText(data.isBanHasOpen() ? "开过板" : "封死未开");
                        break;
                    case 8:
                        textView.setText(data.getFormerStartPoint() + "%");
                        break;
                    case 9:
                        textView.setText(data.getFormerAveragePoint() + "%");
                        break;
                    case 10:
                        textView.setText(data.getFormerEndPoint() + "%");
                        break;
                    case 11:
                        textView.setText(data.isLatterStartPullUp() ? "是" : "否");
                        break;
                    case 12:
                        textView.setText(data.getLatterLowPoint() + "%");
                        break;
                    case 13:
                        textView.setText(data.getLatterLowPointTime());
                        break;
                    case 14:
                        textView.setText(data.getAfterHigh() + "%");
                        break;
                    case 15:
                        textView.setText(data.getFormerGroupPoint() + "%");
                        break;
                    case 16:
                        textView.setText(data.getFormerGroupTurnover() + "%");
                        break;
                    case 17:
                        textView.setText(data.isHasBeforeTop() ? "有" : "无");
                        break;
                    case 18:
                        textView.setText(data.isHasHighLevelLinePin() ? "有" : "无");
                        break;
                    case 19:
                        textView.setText(data.getSelfTurnover() + "%");
                        break;
                    case 20:
                        textView.setText(data.getYesterdaySelfTurnover() + "%");
                        break;
                    case 21:
                        textView.setText(data.getYesterdayAllTurnover() + "%");
                        break;
                    case 22:
                        textView.setText(data.getYesterdaySelfBanNum() + "板");
                        break;
                    case 23:
                        textView.setText(data.getYesterdaySelfBanScore() + "分");
                        break;
                    case 24:
                        textView.setText(data.getYesterdayAllBanNum() + "个");
                        break;
                    case 25:
                        textView.setText(data.getYesterdayAllTopBanNum() + "板");
                        break;
                    case 26:
                        textView.setText(data.getFormerAllTurnover() + "%");
                        break;
                    case 27:
                        textView.setText(data.getFormerAllValue() + "亿");
                        break;
                    case 28:
                        textView.setText(data.getFormerDate());
                        break;
                }
                linearLayout.addView(textView);
            }
        }
    }
}
