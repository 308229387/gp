package com.songyongmeng.gp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.q_a_detail_layout.*
import java.util.*

/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class QADetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_a_detail_layout)
        if (intent != null) {

            question_text.text = intent.getStringExtra("title")
            answer_text.text = intent.getStringExtra("answer")

            if (null != intent.getStringArrayListExtra("imageList")) {
                image_parent.visibility = View.VISIBLE
                var imageList =
                    intent.getStringArrayListExtra("imageList") as ArrayList<String>

                if (imageList != null) {
                    for (i in 0..(imageList.size-1)) {
                        var tmp = imageList[i]
                        if(ToolUtils.startWithText(tmp)){
                            val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            lp.bottomMargin = 70
                            val textView = TextView(this)
                            textView.text = ToolUtils.replaceText(tmp)
                            textView.textSize = 20f
                            textView.setTextColor(resources.getColor(R.color.grey))
                            textView.layoutParams = lp
                            image_parent.addView(textView)
                        }else if(ToolUtils.startWithImage(tmp)){
                            val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            lp.bottomMargin = 70
                            val imageView = ImageView(this)
                            imageView.layoutParams = lp
                            Glide.with(this).load(ToolUtils.getImages(ToolUtils.replaceImage(tmp))).into(imageView)
                            image_parent.addView(imageView)
                        }

                    }
                }
            }


        }

    }


}