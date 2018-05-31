package com.yz.mvp_sample.mvp

interface MvpPresenter<V : MvpView> {
    fun attachView(mvpView: V)
    fun detachView()
}