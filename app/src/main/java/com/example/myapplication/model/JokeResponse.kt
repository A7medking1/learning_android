package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("delivery")
    val delivery: String,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("safe")
    val safe: Boolean,
    @SerializedName("setup")
    val setup: String,
    @SerializedName("type")
    val type: String
)