package com.songyongmeng.gp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.songyongmeng.gp.utils.ZoomableImageView;

public class BigImageActivity extends Activity {

    private OrientationEventListener mOrientationEventListener;
    private boolean isVertical = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image_layout);
        int image = getIntent().getIntExtra("image", 0);
        if(getIntent().getStringExtra("orientation")!=null){
            isVertical = getIntent().getStringExtra("orientation").equals("vertical");
        }

        ZoomableImageView imageView = findViewById(R.id.image_view);
        TextView change = findViewById(R.id.change_layout);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),image);
//        imageView.setImageBitmap(bitmap);
        Glide.with(this).load(image).into(imageView);
        if (isVertical) {
            setVertical();
        }else {
            setHorizontal();
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isVertical) {
                    setHorizontal();
                } else {
                    setVertical();
                }
                isVertical = !isVertical;
            }
        });


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

}



