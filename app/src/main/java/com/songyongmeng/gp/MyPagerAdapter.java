package com.songyongmeng.gp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.songyongmeng.gp.utils.ToolUtils;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    //    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; // 添加你的图片资源
    private List<String> images = new ArrayList<>(); // 添加你的图片资源
    private Context mContext;

    public MyPagerAdapter(NewGPDetailActivity newGPDetailActivity) {
        mContext = newGPDetailActivity;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(ToolUtils.getImages(images.get(position)));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BigImageActivity.class);
                intent.putExtra("image", ToolUtils.getImages(images.get(position)));
                String str;
                if (images.get(position).contains("_k")||images.get(position).contains("_2k")) {
                    str = "vertical";
                } else {
                    str = "horizontal";
                }
                intent.putExtra("orientation", str);
                mContext.startActivity(intent);
            }
        });

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setImageList(List<String> list) {
        images = list;
    }
}
