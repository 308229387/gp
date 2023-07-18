package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.songyongmeng.gp.utils.OnItemClickListener;
import com.songyongmeng.gp.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class SumUpListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sum_up_list_layout);
        Utility.setActionBar(this, R.color.title_bar_grey);
        Intent intent = getIntent();
        if (getIntent() != null) {
            ArrayList<StatisticsBean> receivedList = (ArrayList<StatisticsBean>) intent.getSerializableExtra("sumUpListData");
            if (receivedList != null) {
                RecyclerView recyclerView = findViewById(R.id.sum_up_list);
                RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(verticalLayoutManager);

                recyclerView.setAdapter(new SumUpListAdapter(receivedList));
            }
        }
    }
}
