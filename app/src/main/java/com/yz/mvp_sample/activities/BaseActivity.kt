package com.yz.mvp_sample.activities

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import com.yz.mvp_sample.App
import com.yz.mvp_sample.component.ActivityComponent
import com.yz.mvp_sample.component.DaggerActivityComponent
import com.yz.mvp_sample.module.ActivityModule
import com.yz.mvp_sample.mvp.MvpView
import com.yz.mvp_sample.utils.DialogUtils

abstract class BaseActivity: AppCompatActivity(), MvpView {
    private var mActivityComponent: ActivityComponent? = null
    private var progressDialog : ProgressDialog? = null

    fun activityComponent() : ActivityComponent? {
        if (null == mActivityComponent) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(App.get(this).getComponent())
                    .activityModule(ActivityModule(this))
                    .build()
        }
        return mActivityComponent
    }

    fun requestPermissionsSafely(permissions: Array<String>, requestCode : Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String) = (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) or (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED)

    override fun showLoading() {
        hideLoading()
        progressDialog = DialogUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if ((progressDialog != null) and progressDialog!!.isShowing) {
            progressDialog!!.cancel()
        }
    }
}