package com.poten.android.tripj.presentation.uistate

import androidx.lifecycle.ViewModel
import com.poten.android.tripj.data.model.PostCommentResponse
import com.poten.android.tripj.data.model.PostDetailResponse
import com.poten.android.tripj.data.model.PostListResponse
import com.poten.android.tripj.domain.repository.BoardRepository
import com.poten.android.tripj.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    private val repository: BoardRepository
) : ViewModel() {

    // 게시 글 전체
    private val _postList = MutableStateFlow<Resource<PostListResponse>>(Resource.Loading())
    val postList = _postList.asStateFlow()

    // 게시글 상세
    private val _postDetail = MutableStateFlow<Resource<PostDetailResponse>>(Resource.Loading())
    val postDetail = _postDetail.asStateFlow()

    // 게시글의 댓글 들
    private val _postComments = MutableStateFlow<Resource<PostCommentResponse>>(Resource.Loading())
    val postComments = _postComments.asStateFlow()

    // 최신 글 리스트
    private val _latestPostList = MutableStateFlow<Resource<PostListResponse>>(Resource.Loading())
    val latestPostList = _latestPostList.asStateFlow()

    // 내가 쓴 글
    private val _myPostList = MutableStateFlow<Resource<PostListResponse>>(Resource.Loading())
    val myPostList = _myPostList.asStateFlow()

    // 내가 좋아요 누른 게시글
    private val _myLikedPostList = MutableStateFlow<Resource<PostListResponse>>(Resource.Loading())
    val myLikedPostList = _myLikedPostList.asStateFlow()

    // 인기 글
    private val _popularPostList = MutableStateFlow<Resource<PostListResponse>>(Resource.Loading())
    val popularPostList = _popularPostList.asStateFlow()

    // 데이터 받아오는 부분은 보일러 플레이트 코드 발생으로 작성 보류

}