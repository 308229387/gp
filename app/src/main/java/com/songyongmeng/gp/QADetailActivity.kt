package com.songyongmeng.gp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.q_a_detail_layout.*
import java.lang.reflect.Field

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

            if (null != intent.getStringExtra("image")) {
                answer_image.visibility = View.VISIBLE
//                val resId: Int = this.resources.getIdentifier(intent.getStringExtra("image"), "drawable", this.packageName)
                Glide.with(this).load(ToolUtils.getImages(intent.getStringExtra("image"))).into(answer_image)
                answer_image.setOnClickListener(View.OnClickListener {
                })
            }

            if (null != intent.getStringExtra("image1")) {
                answer_image1.visibility = View.VISIBLE
//                val resId: Int = this.resources.getIdentifier(intent.getStringExtra("image"), "drawable", this.packageName)
                Glide.with(this).load(ToolUtils.getImages(intent.getStringExtra("image1"))).into(answer_image1)
                answer_image.setOnClickListener(View.OnClickListener {
                })
            }

            if (null != intent.getStringExtra("image2")) {
                answer_image2.visibility = View.VISIBLE
//                val resId: Int = this.resources.getIdentifier(intent.getStringExtra("image"), "drawable", this.packageName)
                Glide.with(this).load(ToolUtils.getImages(intent.getStringExtra("image2"))).into(answer_image2)
                answer_image.setOnClickListener(View.OnClickListener {
                })
            }

            if (null != intent.getStringExtra("image3")) {
                answer_image3.visibility = View.VISIBLE
//                val resId: Int = this.resources.getIdentifier(intent.getStringExtra("image"), "drawable", this.packageName)
                Glide.with(this).load(ToolUtils.getImages(intent.getStringExtra("image3"))).into(answer_image3)
                answer_image.setOnClickListener(View.OnClickListener {
                })
            }

            if (null != intent.getStringExtra("image4")) {
                answer_image4.visibility = View.VISIBLE
//                val resId: Int = this.resources.getIdentifier(intent.getStringExtra("image"), "drawable", this.packageName)
                Glide.with(this).load(ToolUtils.getImages(intent.getStringExtra("image4"))).into(answer_image4)
                answer_image.setOnClickListener(View.OnClickListener {
                })
            }

        }
    }


}