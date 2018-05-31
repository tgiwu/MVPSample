package com.yz.mvp_sample.mvp

interface MainMvpPresenter<V : MainMvpView>: MvpPresenter<V> {
    fun getData()
}