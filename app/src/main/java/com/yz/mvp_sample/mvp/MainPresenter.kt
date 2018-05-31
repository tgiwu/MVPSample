package com.yz.mvp_sample.mvp

import com.yz.mvp_sample.data.DataManager
import com.yz.mvp_sample.data.listeners.DataListener
import javax.inject.Inject

class MainPresenter<V : MainMvpView> @Inject constructor(dataManager: DataManager): BasePresenter<V>(), MainMvpPresenter<V> {

    private val mDataManager: DataManager = dataManager

    override fun getData() {
        getMvpView()?.showLoading()

        mDataManager.getData(object : DataListener{
            override fun onResponse(data: String) {
                getMvpView()?.hideLoading()
                getMvpView()?.showData(data)
            }

            override fun onError(error: String) {
                getMvpView()?.hideLoading()
                getMvpView()?.showError(error)
            }

        })
    }

}