package com.betkey.network

import com.betkey.network.models.AuthenticateAgent
import com.betkey.utils.API_KEY
import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("agents/authenticate")
    fun login(@Field("agent[username]") userName: String, @Field("agent[password]") password: String): Single<AuthenticateAgent>

    data class ApiLoginBody(

        @SerializedName("agent[username]")
        val username: String,

        @SerializedName("agent[password]")
        val password: String)


}