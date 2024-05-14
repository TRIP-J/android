package com.poten.android.tripj.data.retrofit

import com.poten.android.tripj.data.model.PostCommentResponse
import com.poten.android.tripj.data.model.PostDetailResponse
import com.poten.android.tripj.data.model.PostEnrollUpdateRequest
import com.poten.android.tripj.data.model.PostEnrollUpdateResponse
import com.poten.android.tripj.data.model.PostListResponse
import com.poten.android.tripj.data.model.UserPost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BoardService {

    // 카테고리 별 게시글 전체 조회
    @GET("board")
    suspend fun getPostList(
        @Query("boardCateId") boardCateId:Int,
    ) : Response<PostListResponse>

    // 게시글 등록
    @POST("board")
    suspend fun enrollPost(
        @Query("userId") userId:Int,
        @Body postEnrollRequest: PostEnrollUpdateRequest
    ) : Response<PostEnrollUpdateResponse>

    // 게시글 상세 조회
    @GET("board/{boardId}")
    suspend fun getPostDetail(
        @Path("boardId") boardId:Int
    ) : Response<PostDetailResponse>

    // 게시글 수정
    @POST("board/{boardId}")
    suspend fun updatePost(
        @Path("boardId") boardId: Int,
        @Query("userId") userId: Int,
        @Body postUpdateRequest: PostEnrollUpdateRequest
    ) : Response<PostEnrollUpdateResponse>

    // 게시글 삭제
    @DELETE("board/{boardId}")
    suspend fun deletePost(
        @Query("userId") userId: Int,
        @Path("boardId") boardId: Int
    ) : Response<Unit>

    // 게시글 댓글 조회
    @GET("board/{boardId}/comments")
    suspend fun getComments(
        @Path("boardId") boardId:Int
    ) : Response<PostCommentResponse>

    // 최신 글 목록 조회
    @GET("board/latest")
    suspend fun getLatestPosts() : Response<PostListResponse>

    // 내가 쓴 게시글 조회
    @GET("board/my/{userId}")
    suspend fun getMyPostList(
        @Query("userId") userId:Int
    ) : Response<PostListResponse>

    // 내가 좋아요 누른 게시글 조회
    @GET("board/my/liked/{userId}")
    suspend fun getMyLikedPosts(
        @Query("userId") userId: Int
    ) : Response<PostListResponse>

    // 인기글 리스트 조회
    @GET("board/polular")
    suspend fun getPopularPosts() : Response<PostListResponse>

    // Paging 처리??
    /*@GET("board/scroll")
    suspend fun */

}