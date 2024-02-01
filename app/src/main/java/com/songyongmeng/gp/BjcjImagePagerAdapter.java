package com.songyongmeng.gp;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.ToolUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BjcjImagePagerAdapter extends PagerAdapter {
    //    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; // 添加你的图片资源
    private List<String> images = new ArrayList<>(); // 添加你的图片资源
    private Context mContext;

    public BjcjImagePagerAdapter(Context context) {
        mContext = context;
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
        imageView.setImageBitmap(AssetsUtils.getBitmapFromAsset(mContext,"bjcj_img/"+images.get(position)));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BjcjBigImageActivity.class);
                intent.putExtra("image", images.get(position));
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
