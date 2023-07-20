package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.OnDetailItemClickListener;
import com.songyongmeng.gp.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SumUpListAdapter extends RecyclerView.Adapter<SumUpListAdapter.VerticalScrollViewHolder> {

    boolean result;
    boolean sell;
    boolean self;
    boolean turnover;
    boolean buy;

    private List<StatisticsBean> dataList; // 数据列表
    List<StatisticsBean> originalBeanList;

    private OnDetailItemClickListener mListener;


    public SumUpListAdapter(List<StatisticsBean> dataList) {
        this.dataList = dataList;
        originalBeanList = new ArrayList<>(this.dataList); // 备份原始列表
    }


    @Override
    public VerticalScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View verticalView = inflater.inflate(R.layout.sum_up_list_item, parent, false);
        return new VerticalScrollViewHolder(verticalView);

    }

    @Override
    public void onBindViewHolder(VerticalScrollViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (dataList.get(position).getResultPoint() > 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFC0CB"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        holder.sumNameText.setText(dataList.get(position).getGpName());
        holder.sumResultPointText.setText(dataList.get(position).getResultPoint() + "");
        holder.self_turnover_text.setText(dataList.get(position).getEndQuantity() < 5 ? "缩量" : "平放量");
        holder.sell_open_text.setText(dataList.get(position).getSellOpen() + "");
        String allTurnover = "";
        if (dataList.get(position).getAllTurnover() == -1) {
            allTurnover = "缩量";
        }
        if (dataList.get(position).getAllTurnover() == 0) {
            allTurnover = "平量";
        }
        if (dataList.get(position).getAllTurnover() == 1) {
            allTurnover = "放量";
        }
        holder.all_turnover_text.setText(allTurnover);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(dataList.get(position));
                }
            }
        });

        holder.is_ban_text.setText(dataList.get(position).getBuyPoint()+"");
    }

    public void recoverData() {
        dataList.clear();
        dataList.addAll(originalBeanList);
        notifyDataSetChanged();
    }

    public void changeResultData() {
        Collections.sort(dataList, new Comparator<StatisticsBean>() {
            @Override
            public int compare(StatisticsBean bean1, StatisticsBean bean2) {
                if (result) {
                    return bean2.getResultPoint() - bean1.getResultPoint();
                } else {
                    return bean1.getResultPoint() - bean2.getResultPoint();
                }
            }
        });
        result = !result;
        notifyDataSetChanged();
    }
    public void changeSellData() {
        Collections.sort(dataList, new Comparator<StatisticsBean>() {
            @Override
            public int compare(StatisticsBean bean1, StatisticsBean bean2) {
                if (sell) {
                    return bean2.getSellOpen() - bean1.getSellOpen();
                } else {
                    return bean1.getSellOpen() - bean2.getSellOpen();
                }
            }
        });
        sell = !sell;
        notifyDataSetChanged();
    }

    public void changeSelfData() {
        Collections.sort(dataList, new Comparator<StatisticsBean>() {
            @Override
            public int compare(StatisticsBean bean1, StatisticsBean bean2) {
                if (self) {
                    return bean2.getEndQuantity() - bean1.getEndQuantity();
                } else {
                    return bean1.getEndQuantity() - bean2.getEndQuantity();
                }
            }
        });
        self = !self;
        notifyDataSetChanged();
    }

    public void changeTurnoverData() {
        Collections.sort(dataList, new Comparator<StatisticsBean>() {
            @Override
            public int compare(StatisticsBean bean1, StatisticsBean bean2) {
                if (turnover) {
                    return bean2.getAllTurnover() - bean1.getAllTurnover();
                } else {
                    return bean1.getAllTurnover() - bean2.getAllTurnover();
                }
            }
        });
        turnover = !turnover;
        notifyDataSetChanged();
    }

    public void changeBuyPointData() {
        Collections.sort(dataList, new Comparator<StatisticsBean>() {
            @Override
            public int compare(StatisticsBean bean1, StatisticsBean bean2) {
                if (buy) {
                    return bean2.getBuyPoint() - bean1.getBuyPoint();
                } else {
                    return bean1.getBuyPoint() - bean2.getBuyPoint();
                }
            }
        });
        buy = !buy;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnDetailItemClickListener(OnDetailItemClickListener listener) {
        mListener = listener;
    }


    protected  class VerticalScrollViewHolder extends RecyclerView.ViewHolder {
        TextView sumNameText;
        TextView sumResultPointText;
        TextView self_turnover_text;
        TextView sell_open_text;
        TextView all_turnover_text;
        TextView is_ban_text;

        public VerticalScrollViewHolder(View itemView) {
            super(itemView);
            sumNameText = itemView.findViewById(R.id.sum_name_text);
            sumResultPointText = itemView.findViewById(R.id.result_point_text);
            self_turnover_text = itemView.findViewById(R.id.self_turnover_text);
            sell_open_text = itemView.findViewById(R.id.sell_open_text);
            all_turnover_text = itemView.findViewById(R.id.all_turnover_text);
            is_ban_text = itemView.findViewById(R.id.is_ban_text);
        }
    }
}
