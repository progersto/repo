package com.betkey.network.models

import com.google.gson.annotations.SerializedName

data class Wallet(
    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("short_id")
    var shortId: String? = null,

    @SerializedName("type")
    var type: Int? = null,

    @SerializedName("status")
    var status: Int? = null,

    @SerializedName("currency")
    var currency: String? = null,

    @SerializedName("balance")
    var balance: String? = null,

    @SerializedName("is_locked")
    var isLocked: Boolean? = null
)