package com.yz.mvp_sample.data

import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.yz.mvp_sample.data.listeners.DataListener
import com.yz.mvp_sample.data.local.PreferencesHelper
import com.yz.mvp_sample.data.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(preferencesHelper: PreferencesHelper, apiHelper: ApiHelper) {

    val mPrefHelper = preferencesHelper
    val mApiHelper = apiHelper

    fun getData( listener: DataListener) {
        val data = mPrefHelper.get()
        data?.let {
            listener.onResponse(data)
            return
        }

        mApiHelper.getData(object : StringRequestListener {
            override fun onResponse(response: String?) {
                response?.let {
                    mPrefHelper.put(it)
                    listener.onResponse(it)
                }
            }

            override fun onError(anError: ANError?) {
                anError?.let {
                    listener.onError(it.errorDetail)
                }
            }

        })
    }
}