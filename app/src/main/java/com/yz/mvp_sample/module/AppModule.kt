package com.yz.mvp_sample.module

import android.app.Application
import android.content.Context
import com.yz.mvp_sample.annotation.AppContext
import dagger.Module
import dagger.Provides

@Module
class AppModule(app: Application) {
    private val mApp: Application = app

    @Provides
    fun provideApp() : Application = mApp

    @AppContext
    @Provides
    fun provideContext() : Context = mApp

}