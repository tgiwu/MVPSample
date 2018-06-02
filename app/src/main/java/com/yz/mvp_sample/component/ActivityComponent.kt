package com.yz.mvp_sample.component

import com.yz.mvp_sample.activities.MainActivity
import com.yz.mvp_sample.annotation.ActivityScope
import com.yz.mvp_sample.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}