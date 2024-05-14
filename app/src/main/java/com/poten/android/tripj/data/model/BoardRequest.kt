package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName

data class PostEnrollUpdateRequest (
    @SerializedName("boardCateId")
    val boardCateId:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("content")
    val content:String,
)

