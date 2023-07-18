package com.songyongmeng.gp;

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
        holder.sumNameText.setText(dataList.get(position).getGpName());
        holder.sumResultPointText.setText(dataList.get(position).getResultPoint()+"");
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected static class VerticalScrollViewHolder extends RecyclerView.ViewHolder {
        TextView sumNameText;
        TextView sumResultPointText;

        public VerticalScrollViewHolder(View itemView) {
            super(itemView);
            sumNameText = itemView.findViewById(R.id.sum_name_text);
            sumResultPointText = itemView.findViewById(R.id.result_point_text);

        }
    }
}
