package com.songyongmeng.gp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.songyongmeng.gp.utils.SPManager;
import com.songyongmeng.gp.utils.Utility;

public class SellActivity extends AppCompatActivity {
    TextView tmp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);
        String result = SPManager.getInstance(SellActivity.this).getValue(SPManager.SELF_TURNOVER);
        tmp =findViewById(R.id.ji_sun_result);
        tmp.setText(Html.fromHtml(result));
    }

}
