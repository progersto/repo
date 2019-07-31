package com.betkey.ui

import com.betkey.base.BaseViewModel
import com.betkey.data.MainDataManager
import com.betkey.network.models.AuthenticateAgent
import io.reactivex.Completable
import io.reactivex.Single

class MainViewModel(private val dataManager: MainDataManager) : BaseViewModel() {


    fun login(userName: String, password: String): Completable {
        return dataManager.login(userName, password)
    }
}