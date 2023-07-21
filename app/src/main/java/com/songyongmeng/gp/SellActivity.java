package com.songyongmeng.gp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.songyongmeng.gp.utils.Utility;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);

    }

}
