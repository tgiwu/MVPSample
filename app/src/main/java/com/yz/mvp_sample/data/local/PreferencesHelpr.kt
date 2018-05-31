package com.yz.mvp_sample.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelper @Inject constructor(context: Context)  {

    companion object {
        const val PREFERENCE_NAME = "pref_file"
        const val DATA = "data"
    }

    var mPref : SharedPreferences
    init {
        mPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun clear() {
        mPref.edit().clear().apply()
    }

    fun put(data: String) {
        mPref.edit().putString(DATA, data).apply()
    }

    fun get() : String? =
        mPref.getString(DATA, null)

}