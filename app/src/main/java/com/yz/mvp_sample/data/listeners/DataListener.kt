package com.yz.mvp_sample.data.listeners

interface DataListener {

    fun onResponse(data: String)

    fun onError(error: String)
}