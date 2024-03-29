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

public class ErBanShangYingXianAdapter extends RecyclerView.Adapter<ErBanShangYingXianAdapter.MyViewHolder> {
    private List<ErBanShangYingXianBean> mDataList;
    private List<ErBanShangYingXianBean> originalFenQiList;
    Comparator<ErBanShangYingXianBean> comparator;
    private boolean latterAverage;
    private boolean formerAllValue;
    private boolean latterStart;
    private boolean formerBanTime;
    private boolean lastPrice;
    private boolean yesterdayLastPrice;
    private boolean banScore;
    private boolean yesterdayEnvironmentScore;
    private boolean allTurnoverAddOrReduce;
    private boolean environmentScore;
    private boolean formerDate;
    private boolean latterLowPointTime;
    private boolean latterTopPointTime;
    private boolean hasOpen;
    private boolean yesterdaySelfBanNum;
    private boolean yesterdayAllBanNum;
    private boolean formerAmPm;
    private boolean yesterdayAllTopBanNum;
    private boolean yesterdaySelfTurnover;
    private boolean whenWillFirstBanTurnover;
    private boolean selfTurnover;
    private boolean formerGroupPoint;
    private boolean afterHigh;
    private boolean formerAllTurnover;
    private boolean latterLowPoint;
    private boolean latterEndPoint;
    private boolean formerEndPoint;
    private boolean formerAveragePoint;
    private boolean formerStartPoint;
    private boolean formerTopPoint;
    private boolean formerLowPoint;
    private boolean latterTopPoint;
    private boolean isHasBeforeTop;
    private boolean isHasHighLevelLinePin;
    private boolean isLatterStartPullUp;
    private int where = 0;

    public ErBanShangYingXianAdapter(List<ErBanShangYingXianBean> dataList) {
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
        ErBanShangYingXianBean data = mDataList.get(position);
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
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
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
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
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


    public void changeLastPriceData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
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


    public void changeLatterTopPointData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (latterTopPoint) {
                    return Double.compare(bean1.getLatterTopPoint(), bean2.getLatterTopPoint());
                } else {
                    return Double.compare(bean2.getLatterTopPoint(), bean1.getLatterTopPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        latterTopPoint = !latterTopPoint;
        notifyDataSetChanged();
    }


    public void changeFormerStartData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerStartPoint) {
                    return Double.compare(bean1.getFormerStartPoint(), bean2.getFormerStartPoint());
                } else {
                    return Double.compare(bean2.getFormerStartPoint(), bean1.getFormerStartPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerStartPoint = !formerStartPoint;
        notifyDataSetChanged();
    }

    public void changeFormerTopData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerTopPoint) {
                    return Double.compare(bean1.getFormerTopPoint(), bean2.getFormerTopPoint());
                } else {
                    return Double.compare(bean2.getFormerTopPoint(), bean1.getFormerTopPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerTopPoint = !formerTopPoint;
        notifyDataSetChanged();
    }

    public void changeFormerLowData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerLowPoint) {
                    return Double.compare(bean1.getFormerLowPoint(), bean2.getFormerLowPoint());
                } else {
                    return Double.compare(bean2.getFormerLowPoint(), bean1.getFormerLowPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerLowPoint = !formerLowPoint;
        notifyDataSetChanged();
    }

    public void changeFormerAveragePointData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerAveragePoint) {
                    return Double.compare(bean1.getFormerAveragePoint(), bean2.getFormerAveragePoint());
                } else {
                    return Double.compare(bean2.getFormerAveragePoint(), bean1.getFormerAveragePoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerAveragePoint = !formerAveragePoint;
        notifyDataSetChanged();
    }

    public void changeFormerEndPointData() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerEndPoint) {
                    return Double.compare(bean1.getFormerEndPoint(), bean2.getFormerEndPoint());
                } else {
                    return Double.compare(bean2.getFormerEndPoint(), bean1.getFormerEndPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerEndPoint = !formerEndPoint;
        notifyDataSetChanged();
    }


    public void changeLatterLowPoint() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (latterLowPoint) {
                    return Double.compare(bean1.getLatterLowPoint(), bean2.getLatterLowPoint());
                } else {
                    return Double.compare(bean2.getLatterLowPoint(), bean1.getLatterLowPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        latterLowPoint = !latterLowPoint;
        notifyDataSetChanged();
    }

    public void changeLatterEndPoint() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (latterEndPoint) {
                    return Double.compare(bean1.getLatterEndPoint(), bean2.getLatterEndPoint());
                } else {
                    return Double.compare(bean2.getLatterEndPoint(), bean1.getLatterEndPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        latterEndPoint = !latterEndPoint;
        notifyDataSetChanged();
    }


    public void changeAfterHigh() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (afterHigh) {
                    return Double.compare(bean1.getAfterHigh(), bean2.getAfterHigh());
                } else {
                    return Double.compare(bean2.getAfterHigh(), bean1.getAfterHigh());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        afterHigh = !afterHigh;
        notifyDataSetChanged();
    }


    public void changeSelfTurnover() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (selfTurnover) {
                    return Double.compare(bean1.getSelfTurnover(), bean2.getSelfTurnover());
                } else {
                    return Double.compare(bean2.getSelfTurnover(), bean1.getSelfTurnover());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        selfTurnover = !selfTurnover;
        notifyDataSetChanged();
    }

    public void changeYesterdaySelfTurnover() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (yesterdaySelfTurnover) {
                    return Double.compare(bean1.getYesterdaySelfTurnover(), bean2.getYesterdaySelfTurnover());
                } else {
                    return Double.compare(bean2.getYesterdaySelfTurnover(), bean1.getYesterdaySelfTurnover());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        yesterdaySelfTurnover = !yesterdaySelfTurnover;
        notifyDataSetChanged();
    }


    public void changeFormerAllValue() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerAllValue) {
                    return Double.compare(bean1.getFormerAllValue(), bean2.getFormerAllValue());
                } else {
                    return Double.compare(bean2.getFormerAllValue(), bean1.getFormerAllValue());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerAllValue = !formerAllValue;
        notifyDataSetChanged();
    }

    public void changeFormerDate() {
        comparator = new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerDate) {
                    return bean2.getFormerDate().compareTo(bean1.getFormerDate());
                } else {
                    return bean1.getFormerDate().compareTo(bean2.getFormerDate());
                }
            }
        };
        Collections.sort(mDataList, comparator);
        formerDate = !formerDate;
        notifyDataSetChanged();

    }

    public void changeFormerAmPm() {
        Collections.sort(mDataList, new Comparator<ErBanShangYingXianBean>() {
            @Override
            public int compare(ErBanShangYingXianBean bean1, ErBanShangYingXianBean bean2) {
                if (formerAmPm) {
                    return bean2.getFormerAmPm() - bean1.getFormerAmPm();
                } else {
                    return bean1.getFormerAmPm() - bean2.getFormerAmPm();
                }
            }
        });
        formerAmPm = !formerAmPm;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }

        public void bindData(ErBanShangYingXianBean data) {
            // 清空容器中的所有子视图
            linearLayout.removeAllViews();

            // 动态添加 TextView
            for (int i = 0; i < 18; i++) {
                TextView textView = new TextView(itemView.getContext());
                if (i == 0) {
                    textView.setWidth(250); // 名称
                } else if (i == 17) {
                    textView.setWidth(270); // 日期
                } else {
                    textView.setWidth(230); // 设置宽度为200像素
                }
                textView.setHeight(100);
                textView.setTextColor(Color.parseColor("#ff000000"));
                textView.setGravity(Gravity.CENTER);
                if (data.getLatterAveragePoint() > 0 && data.getLastPrice() > 0) {
                    textView.setBackgroundColor(Color.parseColor("#FFC0CB"));
                } else {
                    textView.setBackgroundColor(Color.parseColor("#90EE90"));
                }
                switch (i) {
                    case 0:
                        textView.setText(data.getGpName());
                        break;
                    case 1:
                        textView.setText(data.getSelfTurnover() + "%");

                        break;
                    case 2:
                        textView.setText(data.getYesterdaySelfTurnover() + "%");
                        break;
                    case 3:
                        textView.setText(data.getFormerAmPm() == 0 ? "上午" : "下午");
                        break;
                    case 4:
                        textView.setText(data.getFormerStartPoint() + "%");

                        break;
                    case 5:
                        textView.setText(data.getFormerTopPoint() + "%");
                        break;
                    case 6:
                        textView.setText(data.getFormerLowPoint() + "%");
                        break;
                    case 7:
                        textView.setText(data.getFormerEndPoint() + "%");
                        break;
                    case 8:
                        textView.setText(data.getFormerAveragePoint() + "%");
                        break;
                    case 9:
                        textView.setText(data.getLatterStartPoint() + "%");
                        break;
                    case 10:
                        textView.setText(data.getLatterTopPoint() + "%");
                        break;
                    case 11:
                        textView.setText(data.getLatterLowPoint() + "%");
                        break;
                    case 12:
                        textView.setText(data.getLatterEndPoint() + "%");
                        break;
                    case 13:
                        textView.setText(data.getLatterAveragePoint() + "%");
                        break;
                    case 14:
                        textView.setText(data.getAfterHigh() + "%");
                        break;
                    case 15:
                        textView.setText(data.getLastPrice() + "亿");
                        break;
                    case 16:
                        textView.setText(data.getFormerAllValue() + "亿");
                        break;
                    case 17:
                        textView.setText(data.getFormerDate());
                        break;

                }
                linearLayout.addView(textView);
            }

        }
    }
}
