package com.songyongmeng.gp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.OrientationEventListener;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.songyongmeng.gp.utils.ZoomableImageView;

public class BigImageActivity extends Activity {

    private OrientationEventListener mOrientationEventListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image_layout);
        int image = getIntent().getIntExtra("image", 0);

        ZoomableImageView imageView = findViewById(R.id.image_view);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),image);
//        imageView.setImageBitmap(bitmap);
        Glide.with(this).load(image).into(imageView);


        mOrientationEventListener = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {
            @Override
            public void onOrientationChanged(int orientation) {
                if (orientation == ORIENTATION_UNKNOWN) {
                    return;
                }

                // 判断设备的方向
                if (orientation >= 0 && orientation < 45 || orientation > 315) {
                    setVertical();
                } else if (orientation >= 45 && orientation < 135) {
                    setReverseHorizontal();
                } else if (orientation >= 135 && orientation < 225) {
                    setVertical();
                } else if (orientation >= 225 && orientation < 315) {
                    setHorizontal();
                }
            }
        };


        if (mOrientationEventListener.canDetectOrientation()) {
            mOrientationEventListener.enable();
        } else {
            mOrientationEventListener.disable();
        }

    }

    // 切换成横屏展示
    public void setHorizontal() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    // 切换成横屏展示
    public void setReverseHorizontal() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
    }




    // 切换成竖屏展示
    public void setVertical() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOrientationEventListener.disable();
    }


}



