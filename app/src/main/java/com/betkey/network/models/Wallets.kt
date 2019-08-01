package com.betkey.network.models

import com.google.gson.annotations.SerializedName

data class Wallets(

    @SerializedName("wallets")
    val wallets: MutableList<Wallet>

)