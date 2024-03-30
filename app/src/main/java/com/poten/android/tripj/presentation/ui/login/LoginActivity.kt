package com.poten.android.tripj.presentation.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.poten.android.tripj.BuildConfig
import com.poten.android.tripj.databinding.ActivityLoginBinding
import com.poten.android.tripj.presentation.ui.select.SelectActivity
import com.poten.android.tripj.presentation.uistate.login.LoginViewModel
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        KakaoSdk.init(this, BuildConfig.KAKAO_NAVITE_APP_KEY)

        /*
           TODO : 카카오 및 네이버 소셜 로그인 구현 (Server와 연동)
           TODO : 로그인 한 적이 있어 Token 값을 가지고 있다면 자동 나라 선택 화면으로 점프
         */

        with(binding) {
            kakaoLoginImageView.setOnAvoidDuplicateClick {
                    lifecycleScope.launch {
                        viewModel.login()
                    }
                }


               /* val intent = Intent(this@LoginActivity, SelectActivity::class.java)
                startActivity(intent)*/

            naverLoginImageView.setOnAvoidDuplicateClick {

            }
        }
    }
}
