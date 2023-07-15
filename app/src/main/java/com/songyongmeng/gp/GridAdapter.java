package com.songyongmeng.gp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private Context context;
    private ArrayList<StatisticsBean> data;

    private List<String> itemList= new ArrayList<>();

    public GridAdapter(Context context, ArrayList<StatisticsBean> data) {
        this.context = context;
        this.data = data;
        modifyData();
    }

    private void modifyData() {
        for(int i = 0;i<data.size();i++){
            itemList.add(data.get(i).getName());
            itemList.add("总数："+data.get(i).getData().size());
            int suc = 0;
            for (StatisticsBean.DataBean tmp:data.get(i).getData()){
                if(tmp.isSuc()){
                    suc++;
                }
            }
            int dividend = suc; // 被除数
            int divisor = data.get(i).getData().size(); // 除数
            int result = (dividend * 100) / divisor;

            itemList.add("胜率："+ result + "%");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bigText.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bigText;
//        TextView smallText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bigText = itemView.findViewById(R.id.grid_big_text);
//            smallText = itemView.findViewById(R.id.grid_small_text);
        }
    }
}
