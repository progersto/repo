package com.betkey.network.models

import com.google.gson.annotations.SerializedName

data class Wallet(
    @SerializedName("_id")
    var id: String = "",

    @SerializedName("short_id")
    var shortId: String = "",

    @SerializedName("type")
    var type: Int = 0,

    @SerializedName("status")
    var status: Int = 0,

    @SerializedName("currency")
    var currency: String = "",

    @SerializedName("balance")
    var balance: Double = 0.0,

    @SerializedName("is_locked")
    var isLocked: Boolean = false
)