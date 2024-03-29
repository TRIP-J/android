package com.poten.android.tripj.util

import android.view.LayoutInflater
import android.view.ViewGroup

// BaseFragment 에서 쓰이는 별칭
typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

// 버튼 중복 클릭 방지 시간
const val THROTTLE_TIME=300L

const val BASE_URL="192.168.45.212:8080/"