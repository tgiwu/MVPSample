package com.yz.mvp_sample.module

import android.app.Activity
import android.content.Context
import com.yz.mvp_sample.annotation.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (activity : Activity){

    private val mActivity: Activity = activity

    @Provides
    fun provideActivity() : Activity = mActivity

    @Provides
    fun provideContext() : Context = mActivity
}