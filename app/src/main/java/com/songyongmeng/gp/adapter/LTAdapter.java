package com.songyongmeng.gp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.LTBean;
import com.songyongmeng.gp.R;

import java.util.List;

public class LTAdapter extends RecyclerView.Adapter<LTAdapter.LTViewHolder> {
    private List<LTBean> list;
    private OnItemClickListener onItemClickListener;


    public LTAdapter(List<LTBean> list, OnItemClickListener onItemClickListener) {
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }

    // 定义点击事件的接口
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public LTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lt, parent, false);
        return new LTViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LTViewHolder holder, int position) {
        LTBean ltBean = list.get(position);
        holder.ltName.setText(ltBean.getLtName());
        holder.ltDate.setText(ltBean.getLtDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class LTViewHolder extends RecyclerView.ViewHolder {
        TextView ltName, ltDate;

        public LTViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ltName = itemView.findViewById(R.id.lt_name);
            ltDate = itemView.findViewById(R.id.lt_date);

            // 设置 itemView 的点击事件
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (onItemClickListener != null && position != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(position);
                }
            });
        }
    }
}
