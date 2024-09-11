package com.songyongmeng.gp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songyongmeng.gp.adapter.LTAdapter;
import com.songyongmeng.gp.utils.AssetsUtils;

import java.util.List;

public class CasualListActivity extends AppCompatActivity {
    private RecyclerView lt_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt_list_layout);
        lt_list = findViewById(R.id.lt_list);
        AssetsUtils assetsUtils = new AssetsUtils();
        String tmp1 = assetsUtils.readAssetsText(this, "casual_essay.json");
        List<LTBean> list = new Gson().fromJson(tmp1, new TypeToken<List<LTBean>>() {
        }.getType());

        lt_list.setLayoutManager(new LinearLayoutManager(this));

        LTAdapter adapter = new LTAdapter(list, new LTAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // 处理 item 点击事件
                Intent intent = new Intent(CasualListActivity.this, CasualDetailActivity.class);
                intent.putExtra("ltDetailData", list.get(position));
                startActivity(intent);
            }
        });
        lt_list.setAdapter(adapter);
    }
}
