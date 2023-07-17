package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.songyongmeng.gp.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.ViewHolder> {

    boolean all ;
    boolean suc ;
    boolean radio ;
    private Context context;
    private ArrayList<StatisticsBean> data;

    private OnItemClickListener mListener;

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

        itemList.add(new ShowBean("总计", allNum,  allNumSuc , getResult(allNum, allNumSuc)));
        itemList.add(new ShowBean("主升模式",  pullUpNum ,  pullUpSucNum , getResult(pullUpNum, pullUpSucNum)));
        itemList.add(new ShowBean("分歧转一致",  turnedToOneNum ,  turnedToOneSucNum , getResult(turnedToOneNum, turnedToOneSucNum)));
        itemList.add(new ShowBean("反弹",  isRebound ,  isReboundSuc , getResult(isRebound, isReboundSuc)));
        itemList.add(new ShowBean("当日追热点",  isHot ,  isHotSuc , getResult(isHot, isHotSuc)));
        itemList.add(new ShowBean("打板买入",  isBan ,  isBanSuc , getResult(isBan, isBanSuc)));
        itemList.add(new ShowBean("分时低点买",  isTimeBottom ,  isTimeBottomSuc , getResult(isTimeBottom, isTimeBottomSuc)));
        itemList.add(new ShowBean("5日线反弹",  isRebound5 ,  isRebound5Suc , getResult(isRebound5, isRebound5Suc)));
        itemList.add(new ShowBean("10日线反弹",  isRebound10 ,  isRebound10Suc , getResult(isRebound10, isRebound10Suc)));
        itemList.add(new ShowBean("20日线反弹",  isRebound20 ,  isRebound20Suc , getResult(isRebound20, isRebound20Suc)));
        itemList.add(new ShowBean("30日线反弹",  isRebound30 ,  isRebound30Suc , getResult(isRebound30, isRebound30Suc)));
        itemList.add(new ShowBean("沪深缩量",  reduceAllTurnover ,  reduceAllTurnoverSuc , getResult(reduceAllTurnover, reduceAllTurnoverSuc)));
        itemList.add(new ShowBean("沪深平量",  isAllTurnover ,  isAllTurnoverSuc , getResult(isAllTurnover, isAllTurnoverSuc)));
        itemList.add(new ShowBean("沪深增量",  addAllTurnover ,  addAllTurnoverSuc , getResult(addAllTurnover, addAllTurnoverSuc)));
        itemList.add(new ShowBean("二板",  twoBan ,  twoBanSuc , getResult(twoBan, twoBanSuc)));
        itemList.add(new ShowBean("三板",  threeBan ,  threeBanSuc , getResult(threeBan, threeBanSuc)));
        itemList.add(new ShowBean("高位板",  highBan ,  highBanSuc , getResult(highBan, highBanSuc)));

    }

    public int getResult(int all, int suc) {
        int dividend = suc; // 被除数
        int divisor = all; // 除数
        int result = (dividend * 100) / divisor;
        return result ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(itemList.get(position).model);
        holder.all_time.setText("总数：" + itemList.get(position).allTime+ "次");
        holder.suc_time.setText("盈利："+itemList.get(position).sucTime+ "次");
        holder.radio.setText("胜率：" +itemList.get(position).ratio+ "%");
        // 为 item 设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void changeAllTimeData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if(all){
                    return bean2.allTime - bean1.allTime;
                }else{
                    return bean1.allTime - bean2.allTime;
                }
            }
        });
        all = !all;
        notifyDataSetChanged();

    }

    public void changeSucTimeData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if(suc){
                    return bean2.sucTime - bean1.sucTime;
                }else{
                    return bean1.sucTime - bean2.sucTime;
                }
            }
        });
        suc = !suc;
        notifyDataSetChanged();

    }

    public void changeRadioData() {
        Collections.sort(itemList, new Comparator<ShowBean>() {
            @Override
            public int compare(ShowBean bean1, ShowBean bean2) {
                if(radio){
                    return bean2.ratio - bean1.ratio;
                }else {
                    return bean1.ratio - bean2.ratio;
                }
            }
        });
        radio = !radio;
        notifyDataSetChanged();

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
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
        private int allTime;
        private int sucTime;
        private int ratio;

        private ShowBean(String model, int allTime, int sucTime,int ratio) {
            this.model = model;
            this.allTime = allTime;
            this.sucTime = sucTime;
            this.ratio = ratio;
        }
    }
}
