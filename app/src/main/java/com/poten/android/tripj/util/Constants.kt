package com.poten.android.tripj.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat

// BaseFragment 에서 쓰이는 별칭
typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

// 버튼 중복 클릭 방지 시간
const val THROTTLE_TIME = 300L

const val AUTHORIZATION_HEADER = "Authorization"
const val BEARER = "Bearer "
const val BASE_URL="http://223.130.136.164:8080/api/"
const val LOGIN_KAKAO = "KAKAO"

enum class Country(val countryName:String) {
    JAPAN("일본"),
    CHINA("중국"),
    THAILAND("태국"),
    HONGKONG("홍콩"),
    ENGLAND("영국"),
    FRANCE("프랑스"),
    ITALY("이탈리아"),
    USA("미국"),
    CANADA("캐나다"),
    ARGENTINA("아르헨티나");

    companion object {
        fun fromCountryName(name : String) : Country? {
            return values().find { it.countryName==name }
        }
    }

}