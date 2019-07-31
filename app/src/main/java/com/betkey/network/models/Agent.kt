package com.betkey.network.models

import com.google.gson.annotations.SerializedName

data class Agent (

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("first_name")
    var firstName: String? = null,

    @SerializedName("last_name")
    var lastName: String? = null,

    @SerializedName("language")
    var language: String? = null,

    @SerializedName("timezone")
    var timezone: String? = null,

    @SerializedName("currency")
    var currency: String? = null,

    @SerializedName("status")
    var status: Int? = null,

    @SerializedName("agent_id")
    var agentId: Int? = null,

    @SerializedName("created")
    var created: Int? = null,

    @SerializedName("updated")
    var updated: Int? = null,

    @SerializedName("credit_limit")
    var creditLimit: Int? = null,

    @SerializedName("shop")
    var shop: Shop? = null
)