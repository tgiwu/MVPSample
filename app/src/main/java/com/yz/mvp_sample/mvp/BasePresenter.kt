package com.yz.mvp_sample.mvp

open class BasePresenter<V : MvpView> : MvpPresenter<V> {
    private var mMvpView: V? = null

    override fun attachView(mvpView: V) {
        mMvpView = mvpView
    }

    override fun detachView() {
        mMvpView = null
    }

    fun isViewAttached() = mMvpView != null

    fun getMvpView() = mMvpView

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpNotAttachedException()
    }

    class MvpNotAttachedException() : RuntimeException("Please call Presenter.attachView(MvpView) before requesting data to the Presenter")

}