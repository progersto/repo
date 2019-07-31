package com.betkey.network.models

import com.google.gson.annotations.SerializedName

data class AuthenticateAgent(
    @SerializedName("status")
    var status: Boolean? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("errors")
    var errors: List<Any>? = null,

    @SerializedName("token")
    var token: String? = null,

    @SerializedName("token_expires")
    var tokenExpires: String? = null,

    @SerializedName("agent")
    var agent: Agent? = null,

    @SerializedName("wallets")
    var wallets: List<Wallet>? = null
)