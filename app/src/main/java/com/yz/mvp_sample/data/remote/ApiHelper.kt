package com.yz.mvp_sample.data.remote

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interfaces.StringRequestListener
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelper @Inject constructor() {
    fun getData(listener: StringRequestListener) {
        AndroidNetworking.get(ApiEndPoint.GET_URL)
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "3")
                .build()
                .getAsString(listener)
    }
}