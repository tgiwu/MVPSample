package com.yz.mvp_sample.mvp

interface MainMvpView : MvpView {
    fun showData(data: String)
    fun showError(error: String)
}