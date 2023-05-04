package com.songyongmeng.gp.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.songyongmeng.gp.R
import com.songyongmeng.gp.dialog.BaseDialog

class RememberDialog : BaseDialog, View.OnClickListener {
    private var listener: RememberDialogCallBack? = null
    private var leftStr: String? = null
    private var rightStr: String? = null

    constructor(context: Context) : super(context, R.style.SimpleDialog) {
    }

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState ?: Bundle())
        setContentView(R.layout.remember_dialog)
        setCanceledOnTouchOutside(false)
        initView()
    }

    private fun initView() {
        val leftTv = findViewById<Button>(R.id.btn_virtual_left)
        leftTv.setOnClickListener(this)
        val rightTv = findViewById<Button>(R.id.btn_virtual_right)
        rightTv.setOnClickListener(this)

        if (leftStr != null) {
            leftTv.text = leftStr
        }
        if (rightStr != null) {
            rightTv.text = rightStr
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_virtual_left -> {
                listener?.cancel()
            }

            R.id.btn_virtual_right -> {//跳转到设置页面
                listener?.result()
            }
        }
    }


    override fun getHeightRatio(): Float {
        return 0.25f
    }

    override fun getWidthRatio(): Float {
        return 0.8f
    }

    fun setListener(listener: RememberDialogCallBack): BaseDialog {
        this.listener = listener
        return this
    }

    fun setLeftAndRightText(left: String, right: String): BaseDialog {
        leftStr = left
        rightStr = right
        return this
    }

    interface RememberDialogCallBack {
        fun result()
        fun cancel()
    }
}