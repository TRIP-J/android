package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.Date


data class OauthRequest(
    @SerializedName("userType")
    val userType: String
)

data class OauthResponse(
    @SerializedName("grantType")
    val grantType: String,
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("accessTokenExpireTime")
    val accessTokenExpireTime: Date,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("refreshTokenExpireTime")
    val refreshTokenExpireTime: Date,
    )


