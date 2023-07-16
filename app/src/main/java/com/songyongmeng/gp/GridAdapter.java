package com.songyongmeng.gp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private Context context;
    private ArrayList<StatisticsBean> data;

    private List<String> itemList = new ArrayList<>();

    public GridAdapter(Context context, ArrayList<StatisticsBean> data) {
        this.context = context;
        this.data = data;
        modifyData();
    }

    private void modifyData() {
        int allNum = 0;
        int allNumSuc = 0;

        int pullUpNum = 0;
        int pullUpSucNum = 0;

        int turnedToOneNum = 0;
        int turnedToOneSucNum = 0;

        int isHot = 0;
        int isHotSuc = 0;

        int isBan = 0;
        int isBanSuc = 0;

        int isTimeBottom = 0;
        int isTimeBottomSuc = 0;

        for (StatisticsBean tmp : data) {
            allNum++;
            if (tmp.isSuc()) {
                allNumSuc++;
            }
            if (tmp.isIsPullUp()) {
                pullUpNum++;
                if (tmp.isSuc()) {
                    pullUpSucNum++;
                }
            }
            if (tmp.isWhenBuyIsTurnedToOne()) {
                turnedToOneNum++;
                if (tmp.isSuc()) {
                    turnedToOneSucNum++;
                }
            }
            if (tmp.isWhenBuyIsHot()) {
                isHot++;
                if (tmp.isSuc()) {
                    isHotSuc++;
                }
            }
            if (tmp.isIsBuyBan()) {
                isBan++;
                if (tmp.isSuc()) {
                    isBanSuc++;
                }
            }
            if (tmp.isIsBuyTimeKBottom()) {
                isTimeBottom++;
                if (tmp.isSuc()) {
                    isTimeBottomSuc++;
                }
            }
        }

        itemList.add("总计");
        itemList.add("总数：" + allNum + "次");
        itemList.add("盈利：" + allNumSuc + "次");
        itemList.add(getResult(allNum, allNumSuc));

        itemList.add("主升模式");
        itemList.add("总数：" + pullUpNum + "次");
        itemList.add("盈利：" + pullUpSucNum + "次");
        itemList.add(getResult(pullUpNum, pullUpSucNum));

        itemList.add("分歧转一致");
        itemList.add("总数：" + turnedToOneNum + "次");
        itemList.add("盈利：" + turnedToOneSucNum + "次");
        itemList.add(getResult(turnedToOneNum, turnedToOneSucNum));

        itemList.add("当日追热点");
        itemList.add("总数：" + isHot + "次");
        itemList.add("盈利：" + isHotSuc + "次");
        itemList.add(getResult(isHot, isHotSuc));

        itemList.add("打板买入");
        itemList.add("总数：" + isBan + "次");
        itemList.add("盈利：" + isBanSuc + "次");
        itemList.add(getResult(isBan, isBanSuc));

        itemList.add("分时低点买");
        itemList.add("总数：" + isTimeBottom + "次");
        itemList.add("盈利：" + isTimeBottomSuc + "次");
        itemList.add(getResult(isTimeBottom, isTimeBottomSuc));
    }

    public String getResult(int all, int suc) {
        int dividend = suc; // 被除数
        int divisor = all; // 除数
        int result = (dividend * 100) / divisor;
        return "胜率：" + result + "%";
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
