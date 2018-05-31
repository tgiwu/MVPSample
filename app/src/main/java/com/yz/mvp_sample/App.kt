package com.yz.mvp_sample

import android.app.Application
import android.content.Context
import com.androidnetworking.AndroidNetworking
import com.yz.mvp_sample.component.ApplicationComponent
import com.yz.mvp_sample.component.DaggerApplicationComponent
import com.yz.mvp_sample.module.AppModule

class App :Application() {

    lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
        mApplicationComponent = DaggerApplicationComponent.builder().appModule(AppModule((this))).build()
        mApplicationComponent.inject(this)
    }

    companion object {
        fun get(context:Context):App = context.applicationContext as App
    }

    fun getComponent(): ApplicationComponent = mApplicationComponent

    fun setComponent(applicationComponent: ApplicationComponent) {
        mApplicationComponent = applicationComponent
    }
}