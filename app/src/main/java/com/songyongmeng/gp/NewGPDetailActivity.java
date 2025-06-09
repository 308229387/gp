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
        name.setText("股票名称： " + data.getGpName());
        result.setText("后续： " + data.getResultPoint() + "%");
        if (null != intent.getStringExtra("source") && intent.getStringExtra("source").equals("BiddingStatisticsActivity")) {
            last.setText("竞价金额：" + data.getLastPrice());
        } else {
            last.setText(data.getLastPrice() == 0 ? "未涨停" : "封单: " + data.getLastPrice() + "亿");
        }
        reason.setText("描述： " + data.getBuyReason());
        if (data.getFailureReason() != null && data.getFailureReason().size() > 0) {
            StringBuilder builder = new StringBuilder("亏损原因：");
            for (int a : data.getFailureReason()) {
                if (!builder.toString().equals("亏损原因：")) {
                    builder.append(" + ");
                }
                switch (a) {
                    case 0:
                        builder.append(ReasonForFailure.REASON_0);
                        break;
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
                    case 12:
                        builder.append(ReasonForFailure.REASON_12);
                        break;
                    case 13:
                        builder.append(ReasonForFailure.REASON_13);
                        break;
                    case 14:
                        builder.append(ReasonForFailure.REASON_14);
                        break;
                    case 15:
                        builder.append(ReasonForFailure.REASON_15);
                        break;
                    case 16:
                        builder.append(ReasonForFailure.REASON_16);
                        break;
                    case 17:
                        builder.append(ReasonForFailure.REASON_17);
                        break;
                    case 18:
                        builder.append(ReasonForFailure.REASON_18);
                        break;
                    case 19:
                        builder.append(ReasonForFailure.REASON_19);
                        break;
                    case 20:
                        builder.append(ReasonForFailure.REASON_20);
                        break;
                    case 21:
                        builder.append(ReasonForFailure.REASON_21);
                        break;
                    case 22:
                        builder.append(ReasonForFailure.REASON_22);
                        break;
                    case 23:
                        builder.append(ReasonForFailure.REASON_23);
                        break;
                    case 24:
                        builder.append(ReasonForFailure.REASON_24);
                        break;
                    case 25:
                        builder.append(ReasonForFailure.REASON_25);
                        break;
                    case 26:
                        builder.append(ReasonForFailure.REASON_26);
                        break;
                    case 27:
                        builder.append(ReasonForFailure.REASON_27);
                        break;
                    case 28:
                        builder.append(ReasonForFailure.REASON_28);
                        break;
                    case 29:
                        builder.append(ReasonForFailure.REASON_29);
                        break;
                    case 30:
                        builder.append(ReasonForFailure.REASON_30);
                        break;
                    case 31:
                        builder.append(ReasonForFailure.REASON_31);
                        break;
                    case 32:
                        builder.append(ReasonForFailure.REASON_32);
                        break;
                    case 33:
                        builder.append(ReasonForFailure.REASON_33);
                        break;
                    case 34:
                        builder.append(ReasonForFailure.REASON_34);
                        break;
                    case 35:
                        builder.append(ReasonForFailure.REASON_35);
                        break;
                    case 36:
                        builder.append(ReasonForFailure.REASON_36);
                        break;
                    case 37:
                        builder.append(ReasonForFailure.REASON_37);
                        break;
                    case 38:
                        builder.append(ReasonForFailure.REASON_38);
                        break;
                    case 39:
                        builder.append(ReasonForFailure.REASON_39);
                        break;
                    default:
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
