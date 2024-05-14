package com.poten.android.tripj.data.usecase

import com.poten.android.tripj.data.model.PostCommentResponse
import com.poten.android.tripj.data.model.PostDetailResponse
import com.poten.android.tripj.data.model.PostEnrollUpdateRequest
import com.poten.android.tripj.data.model.PostEnrollUpdateResponse
import com.poten.android.tripj.data.model.PostListResponse
import com.poten.android.tripj.data.retrofit.BoardService
import com.poten.android.tripj.domain.repository.BoardRepository
import retrofit2.Response
import javax.inject.Inject

class BoardRepositoryImpl @Inject constructor(
    private val service: BoardService
) : BoardRepository {
    override suspend fun getPostList(boardCateId: Int): Response<PostListResponse> {
        return service.getPostList(boardCateId)
    }

    override suspend fun enrollPost(
        userId: Int,
        postEnrollRequest: PostEnrollUpdateRequest
    ): Response<PostEnrollUpdateResponse> {
        return service.enrollPost(userId, postEnrollRequest)
    }

    override suspend fun getPostDetail(boardId: Int): Response<PostDetailResponse> {
        return service.getPostDetail(boardId)
    }

    override suspend fun updatePost(
        boardId: Int,
        userId: Int,
        postUpdateRequest: PostEnrollUpdateRequest
    ): Response<PostEnrollUpdateResponse> {
        return service.updatePost(boardId, userId, postUpdateRequest)
    }

    override suspend fun deletePost(userId: Int, boardId: Int): Response<Unit> {
        return service.deletePost(userId, boardId)
    }

    override suspend fun getPostComments(boardId: Int): Response<PostCommentResponse> {
        return service.getComments(boardId)
    }

    override suspend fun getLatestPostList(): Response<PostListResponse> {
        return service.getLatestPosts()
    }

    override suspend fun getMyPostList(userId: Int): Response<PostListResponse> {
        return service.getMyPostList(userId)
    }

    override suspend fun getMyLikedPostList(userId: Int): Response<PostListResponse> {
        return service.getMyLikedPosts(userId)
    }

    override suspend fun getPopularPostList(): Response<PostListResponse> {
        return service.getPopularPosts()
    }


}