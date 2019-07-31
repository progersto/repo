package com.betkey.data

import android.content.SharedPreferences

class PreferencesManager(private val pref: SharedPreferences){
    private  val TOKEN = "token"
    private var FIRST_INIT = "first_init"

    fun saveToken(token: String?){
        pref.edit().putString(TOKEN, token).apply()
    }

    fun getToken() = pref.getString(TOKEN, "")


    fun fistInit(value: Boolean) {
        pref.edit().putBoolean(FIRST_INIT, value).apply()
    }

    fun isInit(): Boolean {
        return pref.getBoolean(FIRST_INIT, false)
    }
}