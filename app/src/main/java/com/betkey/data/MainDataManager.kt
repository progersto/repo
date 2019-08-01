package com.betkey.data

import android.util.Log
import com.betkey.network.ApiInterface
import com.betkey.repository.ModelRepository
import io.reactivex.Completable

class MainDataManager(
    private val prefManager: PreferencesManager,
    private val modelRepository: ModelRepository,
    private val apiInterface: ApiInterface
) {


    fun login(userName: String, password: String): Completable {
        return apiInterface.authenticateAgent(userName, password)
            .flatMapCompletable {
                Completable.fromRunnable {
                    prefManager.saveToken(it.token)
                    modelRepository.agent.postWithValue( it.agent!!.agent)
                    modelRepository.wallets.postWithValue( it.wallets!!.toMutableList())
                }
            }
    }

    fun agentLogout() {
        prefManager.getToken()?.also {
            apiInterface.agentLogout(it)
                .flatMapCompletable {
                    Completable.fromRunnable {
                        Log.d("", "")
                    }
                }
        }
    }

    fun generateAgentToken() {
        modelRepository.agent.value?.also { agent ->
            apiInterface.generateAgentToken(agent.id, agent.agentId, agent.username)
                .flatMapCompletable {
                    Completable.fromRunnable {
                        prefManager.saveToken(it.token)
                    }
                }
        }
    }

    fun getAgentInfo() {
        prefManager.getToken()?.also {
            apiInterface.getAgentInfo(it)
                .flatMapCompletable {
                    Completable.fromRunnable {
                        modelRepository.agent.value = it.agent
                    }
                }
        }
    }

    fun getAgentWallets() {
        prefManager.getToken()?.also {
            apiInterface.getAgentWallets(it)
                .flatMapCompletable {
                    Completable.fromRunnable {
                        modelRepository.wallets.value = it.wallets
                    }
                }
        }
    }
}