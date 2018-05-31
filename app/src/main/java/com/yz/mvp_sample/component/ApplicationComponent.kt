package com.yz.mvp_sample.component

import android.content.Context
import com.yz.mvp_sample.App
import com.yz.mvp_sample.annotation.AppContext
import com.yz.mvp_sample.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {

    fun inject(app: App)

    @AppContext
    fun context(): Context

//    fun application() : Application

//    fun dataManager() : DataManager
}