package com.songyongmeng.gp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;

import com.bumptech.glide.Glide;
import com.songyongmeng.gp.utils.AssetsUtils;
import com.songyongmeng.gp.utils.ZoomableImageView;

public class BjcjBigImageActivity extends Activity {

    private OrientationEventListener mOrientationEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image_layout);
        String image = "";
        if (getIntent().getStringExtra("path") != null && !getIntent().getStringExtra("path").isEmpty()) {
            image = getIntent().getStringExtra("path") + "/" + getIntent().getStringExtra("image");
        } else {
            image = Constants.YZB_IMG + "/" + getIntent().getStringExtra("image");
        }

        ZoomableImageView imageView = findViewById(R.id.image_view);
        Glide.with(this).load(AssetsUtils.getBitmapFromAsset(this, image)).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentOrientation = getResources().getConfiguration().orientation;

                if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }

            }
        });


    }

}



