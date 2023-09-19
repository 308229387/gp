package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class NewGPDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_gp_detail_layout);

        Intent intent = getIntent();
        NewStatisticsBean data = (NewStatisticsBean) intent.getSerializableExtra("gpDetailData");
        List<String> images = data.getImage_list();
//        Glide.with(this).load(id).into((ImageView) findViewById(R.id.gp_detail_image_view));

        TextView name = findViewById(R.id.gp_name);
        TextView result = findViewById(R.id.result_point);
        TextView reason = findViewById(R.id.buy_reason);
        TextView failureReason = findViewById(R.id.failure_reason);
        TextView last = findViewById(R.id.gp_last_price);
        name.setText("股票名称： "+data.getGpName());
        result.setText("获利： "+data.getResultPoint() + "%");
        last.setText(data.getLastPrice()==0?"未涨停":"封单: "+data.getLastPrice()+"亿");
        reason.setText("购买原因： "+data.getBuyReason());
        if(data.getFailureReason()!=null&&data.getFailureReason().size()>0){
            StringBuilder builder = new StringBuilder("亏损原因：");
            for(int a : data.getFailureReason()){
                if(!builder.toString().equals("亏损原因：")){
                    builder.append(" + ");
                }
                switch (a){
                    case 1:
                        builder.append(ReasonForFailure.REASON_1);
                        break;
                    case 2:
                        builder.append(ReasonForFailure.REASON_2);
                        break;
                    case 3:
                        builder.append(ReasonForFailure.REASON_3);
                        break;
                    case 4:
                        builder.append(ReasonForFailure.REASON_4);
                        break;
                    case 5:
                        builder.append(ReasonForFailure.REASON_5);
                        break;
                    case 6:
                        builder.append(ReasonForFailure.REASON_6);
                        break;
                    case 7:
                        builder.append(ReasonForFailure.REASON_7);
                        break;
                    case 8:
                        builder.append(ReasonForFailure.REASON_8);
                        break;
                    case 9:
                        builder.append(ReasonForFailure.REASON_9);
                        break;
                    case 10:
                        builder.append(ReasonForFailure.REASON_10);
                        break;
                    case 11:
                        builder.append(ReasonForFailure.REASON_11);
                        break;

                }
            }
            failureReason.setText(builder.toString());
        }
        ViewPager viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter adapter = new MyPagerAdapter(this); // 你需要创建一个适配器
        adapter.setImageList(images);
        viewPager.setAdapter(adapter);
    }
}
