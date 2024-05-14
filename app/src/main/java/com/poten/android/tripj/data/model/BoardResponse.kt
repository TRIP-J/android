package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class UserPost(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("profile")
    val profile: String,
    @SerializedName("boardId")
    val boardId: Int,
    @SerializedName("boardCateName")
    val boardCateName: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("regTime")
    val regTime: String,
    @SerializedName("commentCnt")
    val commentCnt: Int,
    @SerializedName("likeCnt")
    val likeCnt: Int
)

data class PostListResponse(
    @SerializedName("data")
    val data: List<UserPost>
)

data class PostEnrollUpdateResponse(
    @SerializedName("boardId")
    val boardId:Int
)

data class PostDetailResponse(
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("userName")
    val userName:String,
    @SerializedName("profile")
    val profile:String,
    @SerializedName("boardId")
    val boardId:Int,
    @SerializedName("boardCateName")
    val boardCateName: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("regTime")
    val regTime:LocalDate,
    @SerializedName("commentCnt")
    val commentCnt: Int,
    @SerializedName("likeCnt")
    val likeCnt: Int,
)

data class UserComment(
    @SerializedName("id")
    val id:Int,
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("boardId")
    val boardId:Int,
    @SerializedName("content")
    val content:String,
)

data class PostCommentResponse(
    @SerializedName("data")
    val data:List<UserComment>
)

