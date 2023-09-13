package com.songyongmeng.gp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.ToolUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FenQiSucAdapter extends RecyclerView.Adapter<FenQiSucAdapter.MyViewHolder> {
    private List<FenQiSucBean> mDataList;
    private List<FenQiSucBean> originalFenQiList;
    Comparator<FenQiSucBean> comparator;
    private boolean bidBreakTime;
    private boolean formerAllValue;
    private boolean formerAveragePoint;
    private boolean formerBanTime;
    private boolean lastPrice;
    private boolean yesterdayLastPrice;
    private boolean yesterdayStartPoint;
    private boolean yesterdayAveragePoint;
    private boolean formerLargeOrder;
    private boolean yesterdayLargeOrder;
    private boolean firstDayLargeOrder;
    private boolean formerDate;
    private boolean latterLowPointTime;
    private boolean latterTopPointTime;
    private boolean hasOpen;
    private boolean yesterdaySelfBanNum;
    private boolean yesterdayAllBanNum;
    private boolean formerAmPm;
    private boolean bidStrong;
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
    private boolean compareHigh;
    private boolean formerStartPoint;
    private boolean formerTopPoint;
    private boolean formerLowPoint;
    private boolean latterTopPoint;
    private boolean isHasBeforeTop;
    private boolean isLastHasBuy;
    private boolean isLatterStartPullUp;
    private Context mContext;

    public FenQiSucAdapter(List<FenQiSucBean> dataList, Context context) {
        this.mDataList = dataList;
        originalFenQiList = new ArrayList<>(mDataList);
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fen_qi_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FenQiSucBean data = mDataList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,BigImageActivity.class);
                int id = ToolUtils.getImages(data.getImage().replace("image:", ""));
                intent.putExtra("image",id);
                intent.putExtra("orientation","horizontal");
                mContext.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(mContext,BigImageActivity.class);
                int id = ToolUtils.getImages(data.getImage_2().replace("image:", ""));
                intent.putExtra("image",id);
                intent.putExtra("orientation","horizontal");
                mContext.startActivity(intent);
                return false;
            }
        });
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

    public void changeYesterdayLastPriceData() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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



    public void changeLastPriceData() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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
    public void changeFormerLargeOrder() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (formerLargeOrder) {
                    return Double.compare(bean1.getFormerLargeOrder(), bean2.getFormerLargeOrder());
                } else {
                    return Double.compare(bean2.getFormerLargeOrder(), bean1.getFormerLargeOrder());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        formerLargeOrder = !formerLargeOrder;
        notifyDataSetChanged();
    }

    public void changeYesterdayLargeOrder() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (yesterdayLargeOrder) {
                    return Double.compare(bean1.getYesterdayLargeOrder(), bean2.getYesterdayLargeOrder());
                } else {
                    return Double.compare(bean2.getYesterdayLargeOrder(), bean1.getYesterdayLargeOrder());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        yesterdayLargeOrder = !yesterdayLargeOrder;
        notifyDataSetChanged();
    }

    public void changeFirstDayLargeOrder() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (firstDayLargeOrder) {
                    return Double.compare(bean1.getFirstDayLargeOrder(), bean2.getFirstDayLargeOrder());
                } else {
                    return Double.compare(bean2.getFirstDayLargeOrder(), bean1.getFirstDayLargeOrder());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        firstDayLargeOrder = !firstDayLargeOrder;
        notifyDataSetChanged();
    }



    public void changeFormerStartData() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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

    public void changeBidStrong() {
        Collections.sort(mDataList, new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (bidStrong) {
                    return bean2.getBidStrong() - bean1.getBidStrong();
                } else {
                    return bean1.getBidStrong() - bean2.getBidStrong();
                }
            }
        });
        bidStrong = !bidStrong;
        notifyDataSetChanged();
    }

    public void changeCompareHigh() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (compareHigh) {
                    return Double.compare(bean1.getCompareHigh(), bean2.getCompareHigh());
                } else {
                    return Double.compare(bean2.getCompareHigh(), bean1.getCompareHigh());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        compareHigh = !compareHigh;
        notifyDataSetChanged();
    }

    public void changeLastHasBuy() {
        Comparator<FenQiSucBean> comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (isLastHasBuy) {
                    return Boolean.compare(bean2.isLastHasBuy(), bean1.isLastHasBuy());
                } else {
                    return Boolean.compare(bean1.isLastHasBuy(), bean2.isLastHasBuy());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        isLastHasBuy = !isLastHasBuy;
        notifyDataSetChanged();
    }


    public void changeAfterHigh() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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
    public void changeFormerAveragePoint() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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
    public void changeYesterdayAveragePoint() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (yesterdayAveragePoint) {
                    return Double.compare(bean1.getYesterdayAveragePoint(), bean2.getYesterdayAveragePoint());
                } else {
                    return Double.compare(bean2.getYesterdayAveragePoint(), bean1.getYesterdayAveragePoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        yesterdayAveragePoint = !yesterdayAveragePoint;
        notifyDataSetChanged();
    }
    public void changeYesterdayStartPoint() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (yesterdayStartPoint) {
                    return Double.compare(bean1.getYesterdayStartPoint(), bean2.getYesterdayStartPoint());
                } else {
                    return Double.compare(bean2.getYesterdayStartPoint(), bean1.getYesterdayStartPoint());
                }
            }
        };

        Collections.sort(mDataList, comparator);
        yesterdayStartPoint = !yesterdayStartPoint;
        notifyDataSetChanged();
    }

    public void changeSelfTurnover() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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

    public void changeBidBreakTime() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
                if (bidBreakTime) {
                    return bean2.getBidBreakTime().compareTo(bean1.getBidBreakTime());
                } else {
                    return bean1.getBidBreakTime().compareTo(bean2.getBidBreakTime());
                }
            }
        };
        Collections.sort(mDataList, comparator);
        bidBreakTime = !bidBreakTime;
        notifyDataSetChanged();

    }

    public void changeFormerBanTime() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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
    public void changeFormerDate() {
        comparator = new Comparator<FenQiSucBean>() {
            @Override
            public int compare(FenQiSucBean bean1, FenQiSucBean bean2) {
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


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }

        public void bindData(FenQiSucBean data) {
            // 清空容器中的所有子视图
            linearLayout.removeAllViews();

            // 动态添加 TextView
            for (int i = 0; i < 20; i++) {
                TextView textView = new TextView(itemView.getContext());
                if (i == 0) {
                    textView.setWidth(250); // 名称
                } else if (i == 19) {
                    textView.setWidth(270); // 日期
                } else {
                    textView.setWidth(230); // 设置宽度为200像素
                }
                textView.setHeight(100);
                textView.setTextColor(Color.parseColor("#ff000000"));
                textView.setGravity(Gravity.CENTER);
//                if (data.getLatterAveragePoint() > 0 && data.getLastPrice() > 0) {
                    textView.setBackgroundColor(Color.parseColor("#FFC0CB"));
//                } else {
//                    textView.setBackgroundColor(Color.parseColor("#90EE90"));
//                }
                switch (i) {
                    case 0:
                        textView.setText(data.getGpName());
                        break;
                    case 1:
                        textView.setText(data.getAfterHigh() + "%");

                        break;
                    case 2:
                        String res = "";
                        if(data.getBidStrong() == 1){
                            res = "强";
                        }else if(data.getBidStrong() == 0){
                            res = "一般";
                        }else if(data.getBidStrong()==-1){
                            res = "弱";
                        }
                        textView.setText(res);
                        break;
                    case 3:
                        textView.setText(data.getCompareHigh() + "%");
                        break;
                    case 4:
                        textView.setText(data.isLastHasBuy()?"有买入":"无");
                        break;
                    case 5:
                        textView.setText(data.getSelfTurnover() + "%");
                        break;
                    case 6:
                        textView.setText(data.getBidBreakTime());
                        break;
                    case 7:
                        textView.setText(data.getFormerBanTime());
                        break;
                    case 8:
                        textView.setText(data.getFormerStartPoint() + "%");
                        break;
                    case 9:
                        textView.setText(data.getFormerAveragePoint() + "%");
                        break;
                    case 10:
                        textView.setText(data.getYesterdaySelfTurnover() + "%");
                        break;
                    case 11:
                        textView.setText(data.getYesterdayStartPoint() + "%");
                        break;
                    case 12:
                        textView.setText(data.getYesterdayAveragePoint() + "%");
                        break;
                    case 13:
                        textView.setText(data.getFirstDayLargeOrder() + "千万");
                        break;
                    case 14:
                        textView.setText(data.getYesterdayLargeOrder() + "千万");
                        break;
                    case 15:
                        textView.setText(data.getFormerLargeOrder() + "千万");
                        break;
                    case 16:
                        textView.setText(data.getLastPrice() + "亿");
                        break;
                    case 17:
                        textView.setText(data.getYesterdayLastPrice() + "亿");
                        break;
                    case 18:
                        textView.setText(data.getFormerAllValue() + "亿");
                        break;
                    case 19:
                        textView.setText(data.getFormerDate());
                        break;
                }
                linearLayout.addView(textView);
            }

        }
    }
}
