package com.poten.android.tripj.domain.repository

import com.poten.android.tripj.data.model.Post
import com.poten.android.tripj.data.model.PostCommentResponse
import com.poten.android.tripj.data.model.PostDetailResponse
import com.poten.android.tripj.data.model.PostEnrollUpdateRequest
import com.poten.android.tripj.data.model.PostEnrollUpdateResponse
import com.poten.android.tripj.data.model.PostListResponse
import retrofit2.Response

interface BoardRepository {
    suspend fun getPostList(boardCateId: Int): Response<PostListResponse>

    suspend fun enrollPost(
        userId: Int,
        postEnrollRequest: PostEnrollUpdateRequest
    ) : Response<PostEnrollUpdateResponse>

    suspend fun getPostDetail(boardId: Int): Response<PostDetailResponse>

    suspend fun updatePost(
        boardId: Int,
        userId: Int,
        postUpdateRequest: PostEnrollUpdateRequest
    ): Response<PostEnrollUpdateResponse>

    suspend fun deletePost(userId: Int, boardId: Int): Response<Unit>

    suspend fun getPostComments(boardId: Int): Response<PostCommentResponse>

    suspend fun getLatestPostList(): Response<PostListResponse>

    suspend fun getMyPostList(userId: Int): Response<PostListResponse>

    suspend fun getMyLikedPostList(userId: Int): Response<PostListResponse>

    suspend fun getPopularPostList(): Response<PostListResponse>

}