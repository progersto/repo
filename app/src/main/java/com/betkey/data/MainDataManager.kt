package com.betkey.data

import com.betkey.network.ApiInterface
import com.betkey.repository.ModelRepository
import io.reactivex.Completable

class MainDataManager(
    private val prefManager: PreferencesManager,
    private val modelRepository: ModelRepository,
    private val apiInterface: ApiInterface
) {


    fun login(userName: String, password: String): Completable {
        return apiInterface.login(userName, password)
            .doOnSuccess {
                prefManager.saveName(it.token)
            }
            .ignoreElement()
    }


}