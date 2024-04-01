package com.poten.android.tripj.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.poten.android.tripj.data.model.OauthRequest
import com.poten.android.tripj.databinding.ActivityLoginBinding
import com.poten.android.tripj.presentation.ui.select.SelectActivity
import com.poten.android.tripj.presentation.uistate.login.LoginViewModel
import com.poten.android.tripj.util.BEARER
import com.poten.android.tripj.util.LOGIN_KAKAO
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


private const val TAG = "LoginActivity"

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    private val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            val errorMessage = when (error.toString()) {
                AuthErrorCause.AccessDenied.toString() -> {
                    "접근이 거부 됨(동의 취소)"
                }

                AuthErrorCause.InvalidClient.toString() -> {
                    "유효하지 않은 앱"
                }

                AuthErrorCause.InvalidGrant.toString() -> {
                    "인증 수단이 유효하지 않아 인증할 수 없는 상태"
                }

                AuthErrorCause.InvalidRequest.toString() -> {
                    "요청 파라미터 오류"
                }

                AuthErrorCause.InvalidScope.toString() -> {
                    "유효하지 않은 scope ID"
                }

                AuthErrorCause.Misconfigured.toString() -> {
                    "설정이 올바르지 않음(android key hash)"
                }

                AuthErrorCause.ServerError.toString() -> {
                    "카카오 서버 에러"
                }

                AuthErrorCause.Unauthorized.toString() -> {
                    "현재 앱은 요청권한이 없음"
                }

                else -> { // Unknown
                    "알려지지 않은 에러"
                }
            }
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
        // 카카오톡 로그인 성공 시
        else if (token != null) {
            Log.e(TAG, token.accessToken)
            lifecycleScope.launch {
                Log.e(TAG, "THIS NOT CALLED")
                viewModel.login("$BEARER${token.accessToken}", OauthRequest(userType = LOGIN_KAKAO))
                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LoginActivity, SelectActivity::class.java))
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }


        with(binding) {
             kakaoLoginImageView.setOnAvoidDuplicateClick {
            /*    if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
                    Log.e(TAG, "Kakao Talk")
                    UserApiClient.instance.loginWithKakaoTalk(
                        this@LoginActivity,
                        callback = callback
                    )
                } else {
                    Log.e(TAG, "Kakao Account")
                    UserApiClient.instance.loginWithKakaoAccount(
                        this@LoginActivity,
                        callback = callback
                    )
                }*/

            val intent = Intent(this@LoginActivity, SelectActivity::class.java)
            startActivity(intent)
        }


            naverLoginImageView.setOnAvoidDuplicateClick {

            }
        }
    }

}
