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
    private boolean yesterdayAllTopBanNum;
    private boolean yesterdaySelfTurnover;
    private boolean whenWillFirstBanTurnover;
    private boolean selfTurnover;
    private boolean formerGroupPoint;
    private boolean afterHigh;
    private boolean formerAllTurnover;
    private boolean latterLowPoint;
    private boolean formerEndPoint;
    private boolean formerAveragePoint;
    private boolean formerStartPoint;
    private boolean latterTopPoint;
    private boolean isHasBeforeTop;
    private boolean isHasHighLevelLinePin;
    private boolean isLatterStartPullUp;

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

    public void changeLatterTopPointData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeLastTopPointTimeData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (latterTopPointTime) {
                    return bean2.getLatterTopPointTime().compareTo(bean1.getLatterTopPointTime());
                } else {
                    return bean1.getLatterTopPointTime().compareTo(bean2.getLatterTopPointTime());
                }
            }
        };
        Collections.sort(mDataList, comparator);
        latterTopPointTime = !latterTopPointTime;
        notifyDataSetChanged();
    }

    public void changeHasOpenData() {
        Comparator<FenQiBean> comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (hasOpen) {
                    return bean2.getBanHasOpen() - bean1.getBanHasOpen();
                } else {
                    return bean1.getBanHasOpen() - bean2.getBanHasOpen();
                }
            }
        };

        Collections.sort(mDataList, comparator);
        hasOpen = !hasOpen;
        notifyDataSetChanged();
    }

    public void changeFormerStartData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeFormerAveragePointData() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeLatterStartPullUpData() {
        Comparator<FenQiBean> comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (isLatterStartPullUp) {
                    return Boolean.compare(bean2.isLatterStartPullUp(), bean1.isLatterStartPullUp());
                } else {
                    return Boolean.compare(bean1.isLatterStartPullUp(), bean2.isLatterStartPullUp());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        isLatterStartPullUp = !isLatterStartPullUp;
        notifyDataSetChanged();
    }

    public void changeLatterLowPoint() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeLatterLowPointTime() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (latterLowPointTime) {
                    return bean2.getLatterLowPointTime().compareTo(bean1.getLatterLowPointTime());
                } else {
                    return bean1.getLatterLowPointTime().compareTo(bean2.getLatterLowPointTime());
                }
            }
        };
        Collections.sort(mDataList, comparator);
        latterLowPointTime = !latterLowPointTime;
        notifyDataSetChanged();

    }

    public void changeAfterHigh() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeFormerGroupPoint() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (formerGroupPoint) {
                    return Double.compare(bean1.getFormerGroupPoint(), bean2.getFormerGroupPoint());
                } else {
                    return Double.compare(bean2.getFormerGroupPoint(), bean1.getFormerGroupPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerGroupPoint = !formerGroupPoint;
        notifyDataSetChanged();
    }

    public void changeHasBeforeTop() {
        Comparator<FenQiBean> comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (isHasBeforeTop) {
                    return Boolean.compare(bean2.isHasBeforeTop(), bean1.isHasBeforeTop());
                } else {
                    return Boolean.compare(bean1.isHasBeforeTop(), bean2.isHasBeforeTop());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        isHasBeforeTop = !isHasBeforeTop;
        notifyDataSetChanged();
    }

    public void changeHasHighLevelLinePin() {
        Comparator<FenQiBean> comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (isHasHighLevelLinePin) {
                    return Boolean.compare(bean2.isHasHighLevelLinePin(), bean1.isHasHighLevelLinePin());
                } else {
                    return Boolean.compare(bean1.isHasHighLevelLinePin(), bean2.isHasHighLevelLinePin());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        isHasHighLevelLinePin = !isHasHighLevelLinePin;
        notifyDataSetChanged();
    }

    public void changeSelfTurnover() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeYesterdaySelfBanNum() {
        Collections.sort(mDataList, new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (yesterdaySelfBanNum) {
                    return bean2.getYesterdaySelfBanNum() - bean1.getYesterdaySelfBanNum();
                } else {
                    return bean1.getYesterdaySelfBanNum() - bean2.getYesterdaySelfBanNum();
                }
            }
        });
        yesterdaySelfBanNum = !yesterdaySelfBanNum;
        notifyDataSetChanged();
    }

    public void changeYesterdayAllBanNum() {
        Collections.sort(mDataList, new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (yesterdayAllBanNum) {
                    return bean2.getYesterdayAllBanNum() - bean1.getYesterdayAllBanNum();
                } else {
                    return bean1.getYesterdayAllBanNum() - bean2.getYesterdayAllBanNum();
                }
            }
        });
        yesterdayAllBanNum = !yesterdayAllBanNum;
        notifyDataSetChanged();
    }

    public void changeYesterdayAllTopBanNum() {
        Collections.sort(mDataList, new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (yesterdayAllTopBanNum) {
                    return bean2.getYesterdayAllTopBanNum() - bean1.getYesterdayAllTopBanNum();
                } else {
                    return bean1.getYesterdayAllTopBanNum() - bean2.getYesterdayAllTopBanNum();
                }
            }
        });
        yesterdayAllTopBanNum = !yesterdayAllTopBanNum;
        notifyDataSetChanged();
    }

    public void changeFormerAllValue() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
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

    public void changeYesterdayEnvironmentScore() {
        Collections.sort(mDataList, new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (yesterdayEnvironmentScore) {
                    return bean2.getYesterdayEnvironmentScore() - bean1.getYesterdayEnvironmentScore();
                } else {
                    return bean1.getYesterdayEnvironmentScore() - bean2.getYesterdayEnvironmentScore();
                }
            }
        });
        yesterdayEnvironmentScore = !yesterdayEnvironmentScore;
        notifyDataSetChanged();
    }

    public void changeEnvironmentScore() {
        Collections.sort(mDataList, new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (environmentScore) {
                    return bean2.getEnvironmentScore() - bean1.getEnvironmentScore();
                } else {
                    return bean1.getEnvironmentScore() - bean2.getEnvironmentScore();
                }
            }
        });
        environmentScore = !environmentScore;
        notifyDataSetChanged();
    }

    public void changeWhenWillFirstBanTurnover() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (whenWillFirstBanTurnover) {
                    return Double.compare(bean1.getWhenWillFirstBanTurnover(), bean2.getWhenWillFirstBanTurnover());
                } else {
                    return Double.compare(bean2.getWhenWillFirstBanTurnover(), bean1.getWhenWillFirstBanTurnover());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        whenWillFirstBanTurnover = !whenWillFirstBanTurnover;
        notifyDataSetChanged();
    }

    public void changeYesterdayLastPrice() {
        comparator = new Comparator<FenQiBean>() {
            @Override
            public int compare(FenQiBean bean1, FenQiBean bean2) {
                if (yesterdayLastPrice) {
                    return Double.compare(bean1.getYesterdayLastPrice(), bean2.getYesterdayLastPrice());
                } else {
                    return Double.compare(bean2.getYesterdayLastPrice(), bean1.getYesterdayLastPrice());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        yesterdayLastPrice = !yesterdayLastPrice;
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
            for (int i = 0; i < 30; i++) {
                TextView textView = new TextView(itemView.getContext());
                if (i == 0) {
                    textView.setWidth(250); // 名称
                } else if (i == 28) {
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
                        textView.setText(data.getLastPrice() + "亿");
                        break;
                    case 2:
                        textView.setText(data.getSelfTurnover() + "%");
                        break;
                    case 3:
                        textView.setText(data.getFormerGroupPoint() + "%");
                        break;
                    case 4:
                        textView.setText(data.getFormerAveragePoint() + "%");
                        break;
                    case 5:
                        textView.setText(data.getFormerStartPoint() + "%");
                        break;
                    case 6:
                        textView.setText(data.getLatterStartPoint() + "%");
                        break;
                    case 7:
                        textView.setText(data.getLatterAveragePoint() + "%");
                        break;
                    case 8:
                        textView.setText(data.getLatterTopPoint() + "%");
                        break;
                    case 9:
                        textView.setText(data.getLatterTopPointTime());
                        break;
                    case 10:
                        textView.setText(data.getWhenWillFirstBanTurnover() + "%");
                        break;
                    case 11:
                        textView.setText(data.isHasBeforeTop() ? "有" : "无");
                        break;
                    case 12:
                        textView.setText(data.getYesterdaySelfTurnover() + "%");
                        break;
                    case 13:
                        textView.setText(data.getYesterdaySelfBanScore() + "分");
                        break;
                    case 14:
                        textView.setText(data.getLatterLowPoint() + "%");
                        break;
                    case 15:
                        textView.setText(data.getLatterLowPointTime());
                        break;
                    case 16:
                        textView.setText(data.getAfterHigh() + "%");
                        break;
                    case 17:
                        textView.setText(data.getYesterdayEnvironmentScore() + "分");
                        break;
                    case 18:
                        textView.setText(data.getEnvironmentScore() + "分");
                        break;
                    case 19:
                        String tmp = "";
                        if (data.getBanHasOpen() == 1) {
                            tmp = "未开板";
                        } else if (data.getBanHasOpen() == 0) {
                            tmp = "开板回封";
                        } else {
                            tmp = "炸板";
                        }
                        textView.setText(tmp);
                        break;
                    case 20:
                        textView.setText(data.getFormerEndPoint() + "%");
                        break;
                    case 21:
                        textView.setText(data.isLatterStartPullUp() ? "是" : "否");
                        break;
                    case 22:
                        textView.setText(data.isHasHighLevelLinePin() ? "有" : "无");
                        break;
                    case 23:
                        textView.setText(data.getFormerBanTime());
                        break;
                    case 24:
                        textView.setText(data.getYesterdaySelfBanNum() + "板");
                        break;
                    case 25:
                        textView.setText(data.getYesterdayAllBanNum() + "个");
                        break;
                    case 26:
                        textView.setText(data.getYesterdayAllTopBanNum() + "板");
                        break;
                    case 27:
                        textView.setText(data.getFormerAllValue() + "亿");
                        break;
                    case 28:
                        textView.setText(data.getFormerDate());
                        break;
                    case 29:
                        textView.setText(data.getYesterdayLastPrice() + "亿");
                        break;
                }
                linearLayout.addView(textView);
            }
        }
    }
}
