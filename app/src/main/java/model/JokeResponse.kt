package model


import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("safe")
    val safe: Boolean,
    @SerializedName("type")
    val type: String
)