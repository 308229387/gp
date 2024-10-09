package com.songyongmeng.gp.adapter;

import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.hawk.Hawk;
import com.songyongmeng.gp.LTBean;
import com.songyongmeng.gp.QABean;
import com.songyongmeng.gp.R;
import com.songyongmeng.gp.dialog.RememberDialog;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.casual_item_layout, parent, false);
        return new LTViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LTViewHolder holder, int position) {
        LTBean ltBean = list.get(position);
        holder.casual_item_name.setText(Html.fromHtml(ltBean.getLtName()));
        holder.casual_learn_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RememberDialog dialog = new RememberDialog(holder.casual_learn_icon.getContext());
                dialog.setListener(new RememberDialog.RememberDialogCallBack() {
                    @Override
                    public void result() {
                        QABean tmp = Hawk.get(list.get(position).getLtName(), new QABean());
                        tmp.setCount(tmp.getCount() + 1);
                        Hawk.put(list.get(position).getLtName(), tmp);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }

                    @Override
                    public void cancel() {
                        dialog.dismiss();
                    }
                }).show();
            }
        });

        holder.casual_learn_icon.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                RememberDialog dialog = new RememberDialog(holder.casual_learn_icon.getContext(), "清除此条状态");
                dialog.setListener(new RememberDialog.RememberDialogCallBack() {
                    @Override
                    public void result() {
                        if (Hawk.contains(list.get(position).getLtName())) {
                            QABean tmp = Hawk.get(list.get(position).getLtName());
                            tmp.setCount(0);
                            Hawk.put(list.get(position).getLtName(), tmp);
                            notifyDataSetChanged();
                        }
                        dialog.dismiss();
                    }

                    @Override
                    public void cancel() {
                        dialog.dismiss();
                    }
                }).show();

                return false;
            }
        });

        if (Hawk.contains(list.get(position).getLtName())) {
            QABean tmp = Hawk.get(list.get(position).getLtName());
            switch (tmp.getCount()) {
                case 0:
                    holder.parent_view.setBackgroundColor(Color.parseColor("#ffffff"));
                    break;
                case 1:
                    holder.parent_view.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case 2:
                    holder.parent_view.setBackgroundColor(Color.parseColor("#FFD700"));

                    break;
                case 3:
                    holder.parent_view.setBackgroundColor(Color.parseColor("#006400"));

                    break;
                default:
                    holder.parent_view.setBackgroundColor(Color.parseColor("#00FF00"));
                    break;
            }
        } else {
            holder.parent_view.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LTViewHolder extends RecyclerView.ViewHolder {
        TextView casual_item_name;
        LinearLayout parent_view;
        ImageView casual_learn_icon;

        public LTViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            casual_item_name = itemView.findViewById(R.id.casual_item_name);
            casual_learn_icon = itemView.findViewById(R.id.casual_learn_icon);
            parent_view = itemView.findViewById(R.id.parent_view);

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
