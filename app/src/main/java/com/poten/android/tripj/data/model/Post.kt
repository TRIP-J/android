package com.poten.android.tripj.data.model

// 커뮤니티 게시글에 사용할 Data Class(임시 Class)
data class Post(
    val imageUrl: String,
    val nickName: String,
    val time: String,
    val title:String,
    val content:String,
    val likeCount : Int,
    val replyCount: Int,
)
