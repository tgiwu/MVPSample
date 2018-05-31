package com.yz.mvp_sample.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.yz.mvp_sample.R

object DialogUtils {
    fun showLoadingDialog(context: Context): ProgressDialog {
        val dialog = ProgressDialog(context)
        dialog.show()
        dialog.window?.let {
            it.setBackgroundDrawable(object : ColorDrawable(Color.TRANSPARENT) {})
        }
        dialog.setContentView(R.layout.dialog_layout)
        dialog.isIndeterminate = true
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }
}