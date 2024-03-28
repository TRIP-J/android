package com.poten.android.tripj.util

import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import reactivecircus.flowbinding.android.view.clicks
import kotlin.coroutines.CoroutineContext

/**
 * Set on avoid duplicate click
 * 중복 클릭 방지를 위한 확장 함수
 * @param action (Main 함수 에서 실행될 로직)
 * @receiver
 */
fun View.setOnAvoidDuplicateClick(action : () -> Unit) {
    this.clicks()
        .flowOn(Dispatchers.Main)
        .throttleFirst(THROTTLE_TIME)
        .flowOn(Dispatchers.IO)
        .onEach {
            action()
        }
        .launchIn(CoroutineScope(Dispatchers.Main))
}

/**
 * Throttle first
 * Debounce 대신 Throttle First를 구현
 * @param T
 * @param interval (입력 처리하는 간격)
 * @return
 */
private fun <T> Flow<T>.throttleFirst(interval :Long) : Flow<T> = flow {
    var throttleTime=0L
    collect { upstream->
        val currentTime=System.currentTimeMillis()
        if ((currentTime-throttleTime)>interval) {
            throttleTime=currentTime
            emit(upstream)
        }
    }
}