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

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<StatisticsBean> data;

    private List<ShowBean> itemList = new ArrayList<>();

    public StatisticsAdapter(Context context, ArrayList<StatisticsBean> data) {
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

        int isRebound = 0;
        int isReboundSuc = 0;

        int isRebound5 = 0;
        int isRebound5Suc = 0;

        int isRebound10 = 0;
        int isRebound10Suc = 0;

        int isRebound20 = 0;
        int isRebound20Suc = 0;

        int isRebound30 = 0;
        int isRebound30Suc = 0;

        int isHot = 0;
        int isHotSuc = 0;

        int isBan = 0;
        int isBanSuc = 0;

        int isTimeBottom = 0;
        int isTimeBottomSuc = 0;

        int isAllTurnover = 0;
        int isAllTurnoverSuc = 0;

        int reduceAllTurnover = 0;
        int reduceAllTurnoverSuc = 0;

        int addAllTurnover = 0;
        int addAllTurnoverSuc = 0;

        int twoBan = 0;
        int twoBanSuc = 0;

        int threeBan = 0;
        int threeBanSuc = 0;

        int highBan = 0;
        int highBanSuc = 0;

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
            if (tmp.isWhenBuyIsRebound()) {
                isRebound++;
                if (tmp.isSuc()) {
                    isReboundSuc++;
                }

                if(tmp.getReboundLine()==5){
                    isRebound5++;
                    if(tmp.isSuc()){
                        isRebound5Suc++;
                    }
                }

                if(tmp.getReboundLine()==10){
                    isRebound10++;
                    if(tmp.isSuc()){
                        isRebound10Suc++;
                    }
                }

                if(tmp.getReboundLine()==20){
                    isRebound20++;
                    if(tmp.isSuc()){
                        isRebound20Suc++;
                    }
                }

                if(tmp.getReboundLine()==30){
                    isRebound30++;
                    if(tmp.isSuc()){
                        isRebound30Suc++;
                    }
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
            if (tmp.getAllTurnover() ==0) {
                isAllTurnover++;
                if (tmp.isSuc()) {
                    isAllTurnoverSuc++;
                }
            }
            if (tmp.getAllTurnover() ==-1) {
                reduceAllTurnover++;
                if (tmp.isSuc()) {
                    reduceAllTurnoverSuc++;
                }
            }
            if (tmp.getAllTurnover() ==1) {
                addAllTurnover++;
                if (tmp.isSuc()) {
                    addAllTurnoverSuc++;
                }
            }
            if (tmp.isIsPullUp()&&tmp.getBuyBanNum() ==2) {
                twoBan++;
                if (tmp.isSuc()) {
                    twoBanSuc++;
                }
            }
            if (tmp.isIsPullUp()&&tmp.getBuyBanNum() ==3) {
                threeBan++;
                if (tmp.isSuc()) {
                    threeBanSuc++;
                }
            }
            if (tmp.isIsPullUp()&&tmp.getBuyBanNum() >3) {
                highBan++;
                if (tmp.isSuc()) {
                    highBanSuc++;
                }
            }


        }

        itemList.add(new ShowBean("总计", "总数：" + allNum + "次", "盈利：" + allNumSuc + "次", "胜率：" + getResult(allNum, allNumSuc)));
        itemList.add(new ShowBean("主升模式", "总数：" + pullUpNum + "次", "盈利：" + pullUpSucNum + "次", "胜率：" + getResult(pullUpNum, pullUpSucNum)));
        itemList.add(new ShowBean("分歧转一致", "总数：" + turnedToOneNum + "次", "盈利：" + turnedToOneSucNum + "次", "胜率：" + getResult(turnedToOneNum, turnedToOneSucNum)));
        itemList.add(new ShowBean("反弹", "总数：" + isRebound + "次", "盈利：" + isReboundSuc + "次", "胜率：" + getResult(isRebound, isReboundSuc)));
        itemList.add(new ShowBean("当日追热点", "总数：" + isHot + "次", "盈利：" + isHotSuc + "次", "胜率：" + getResult(isHot, isHotSuc)));
        itemList.add(new ShowBean("打板买入", "总数：" + isBan + "次", "盈利：" + isBanSuc + "次", "胜率：" + getResult(isBan, isBanSuc)));
        itemList.add(new ShowBean("分时低点买", "总数：" + isTimeBottom + "次", "盈利：" + isTimeBottomSuc + "次", "胜率：" + getResult(isTimeBottom, isTimeBottomSuc)));
        itemList.add(new ShowBean("5日线反弹", "总数：" + isRebound5 + "次", "盈利：" + isRebound5Suc + "次", "胜率：" + getResult(isRebound5, isRebound5Suc)));
        itemList.add(new ShowBean("10日线反弹", "总数：" + isRebound10 + "次", "盈利：" + isRebound10Suc + "次", "胜率：" + getResult(isRebound10, isRebound10Suc)));
        itemList.add(new ShowBean("20日线反弹", "总数：" + isRebound20 + "次", "盈利：" + isRebound20Suc + "次", "胜率：" + getResult(isRebound20, isRebound20Suc)));
        itemList.add(new ShowBean("30日线反弹", "总数：" + isRebound30 + "次", "盈利：" + isRebound30Suc + "次", "胜率：" + getResult(isRebound30, isRebound30Suc)));
        itemList.add(new ShowBean("沪深缩量", "总数：" + reduceAllTurnover + "次", "盈利：" + reduceAllTurnoverSuc + "次", "胜率：" + getResult(reduceAllTurnover, reduceAllTurnoverSuc)));
        itemList.add(new ShowBean("沪深平量", "总数：" + isAllTurnover + "次", "盈利：" + isAllTurnoverSuc + "次", "胜率：" + getResult(isAllTurnover, isAllTurnoverSuc)));
        itemList.add(new ShowBean("沪深增量", "总数：" + addAllTurnover + "次", "盈利：" + addAllTurnoverSuc + "次", "胜率：" + getResult(addAllTurnover, addAllTurnoverSuc)));
        itemList.add(new ShowBean("二板", "总数：" + twoBan + "次", "盈利：" + twoBanSuc + "次", "胜率：" + getResult(twoBan, twoBanSuc)));
        itemList.add(new ShowBean("三板", "总数：" + threeBan + "次", "盈利：" + threeBanSuc + "次", "胜率：" + getResult(threeBan, threeBanSuc)));
        itemList.add(new ShowBean("高位板", "总数：" + highBan + "次", "盈利：" + highBanSuc + "次", "胜率：" + getResult(highBan, highBanSuc)));

    }

    public String getResult(int all, int suc) {
        int dividend = suc; // 被除数
        int divisor = all; // 除数
        int result = (dividend * 100) / divisor;
        return result + "%";
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).model);
        holder.all_time.setText(itemList.get(position).allTime);
        holder.suc_time.setText(itemList.get(position).sucTime);
        holder.radio.setText(itemList.get(position).ratio);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView all_time;
        TextView suc_time;
        TextView radio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            all_time = itemView.findViewById(R.id.all_time_txt);
            suc_time = itemView.findViewById(R.id.suc_time_text);
            radio = itemView.findViewById(R.id.radio_text);
        }
    }

    private class ShowBean {
        private String model;
        private String allTime;
        private String sucTime;
        private String ratio;

        private ShowBean(String model, String allTime, String sucTime, String ratio) {
            this.model = model;
            this.allTime = allTime;
            this.sucTime = sucTime;
            this.ratio = ratio;
        }
    }
}
