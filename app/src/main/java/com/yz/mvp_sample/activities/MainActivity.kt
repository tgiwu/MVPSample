package com.yz.mvp_sample.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.yz.mvp_sample.R
import com.yz.mvp_sample.mvp.MainMvpView
import com.yz.mvp_sample.mvp.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView, View.OnClickListener {


    @Inject
    lateinit var mMainPresenter: MainPresenter<MainMvpView>

    lateinit var textView: TextView
    lateinit var loadBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent()?.inject(this)
        setContentView(R.layout.activity_main)
        initView()
        mMainPresenter.attachView(this)
    }

    private fun initView() {
        textView = findViewById(R.id.textViewData)
        loadBtn = findViewById(R.id.btnLoadData)
        loadBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        mMainPresenter.getData()
    }

    override fun showData(data: String) {
        textView.text = data
    }

    override fun showError(error: String) {
        textView.text = error
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.detachView()
    }
}
