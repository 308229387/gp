package com.songyongmeng.gp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SumUpListAdapter extends RecyclerView.Adapter<SumUpListAdapter.VerticalScrollViewHolder> {


    private List<StatisticsBean> dataList; // 数据列表

    public SumUpListAdapter(List<StatisticsBean> dataList) {
        this.dataList = dataList;
    }


    @Override
    public VerticalScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View verticalView = inflater.inflate(R.layout.sum_up_list_item, parent, false);
        return new VerticalScrollViewHolder(verticalView);

    }

    @Override
    public void onBindViewHolder(VerticalScrollViewHolder holder, int position) {
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
        holder.is_ban_text.setText(dataList.get(position).isIsBuyBan() ? "是" : "否");
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected static class VerticalScrollViewHolder extends RecyclerView.ViewHolder {
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
