package com.songyongmeng.gp;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FenQiAdapter extends RecyclerView.Adapter<FenQiAdapter.MyViewHolder> {
    private List<FenQiBean> mDataList;

    public FenQiAdapter(List<FenQiBean> dataList) {
        this.mDataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fen_qi_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FenQiBean data = mDataList.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }

        public void bindData(FenQiBean data) {
            // 清空容器中的所有子视图
            linearLayout.removeAllViews();

            // 动态添加 TextView
            for (int i = 0; i < 27; i++) {
                TextView textView = new TextView(itemView.getContext());
                textView.setWidth(200); // 设置宽度为200像素
                textView.setGravity(Gravity.CENTER);
                switch (i) {
                    case 0:
                        textView.setText(data.getGpName());
                        break;
                    case 1:
                        textView.setText(data.getFormerBanTime());
                        break;
                    case 2:
                        textView.setText(data.getLastPrice() + "亿");
                        break;
                    case 3:
                        textView.setText(data.isBanHasOpen() ? "开过板" : "封死未开");
                        break;
                    case 4:
                        textView.setText(data.getFormerOpenPoint() + "%");
                        break;
                    case 5:
                        textView.setText(data.getLatterOpenPoint() + "%");
                        break;
                    case 6:
                        textView.setText(data.isLatterStartPullUp()? "是" : "否" );
                        break;
                    case 7:
                        textView.setText(data.getLatterTopPoint() + "%");
                        break;
                    case 8:
                        textView.setText(data.getLatterTopPointTime());
                        break;
                    case 9:
                        textView.setText(data.getLatterAveragePoint() + "%");
                        break;
                    case 10:
                        textView.setText(data.getLatterLowPoint() + "%");
                        break;
                    case 11:
                        textView.setText(data.getLatterLowPointTime());
                        break;
                    case 12:
                        textView.setText(data.getAfterHigh() + "%");
                        break;
                    case 13:
                        textView.setText(data.getFormerGroupPoint() + "%");
                        break;
                    case 14:
                        textView.setText(data.getFormerGroupTurnover() + "%");
                        break;
                    case 15:
                        textView.setText(data.isHasBeforeTop() ? "有" : "无");
                        break;
                    case 16:
                        textView.setText(data.isHasHighLevelLinePin() ? "有" : "无");
                        break;
                    case 17:
                        textView.setText(data.getSelfTurnover() + "%");
                        break;
                    case 18:
                        textView.setText(data.getYesterdaySelfTurnover() + "%");
                        break;
                    case 19:
                        textView.setText(data.getYesterdayAllTurnover() + "%");
                        break;
                    case 20:
                        textView.setText(data.getYesterdaySelfBanNum() + "板");
                        break;
                    case 21:
                        textView.setText(data.getYesterdayAllBanNum() + "个");
                        break;
                    case 22:
                        textView.setText(data.getYesterdayAllTopBanNum() + "板");
                        break;
                    case 23:
                        textView.setText(data.getFormerAllTurnover() + "%");
                        break;
                    case 24:
                        textView.setText(data.getFormerDate());
                        break;
                    case 25:
                        textView.setText(data.getFormerAllValue() + "亿");
                        break;
                }
                linearLayout.addView(textView);
            }
        }
    }
}
