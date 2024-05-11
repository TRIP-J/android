package com.poten.android.tripj.presentation.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.poten.android.tripj.data.model.login.OauthRequest
import com.poten.android.tripj.databinding.FragmentLoginBinding
import com.poten.android.tripj.presentation.uistate.login.LoginViewModel
import com.poten.android.tripj.util.BEARER
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.LOGIN_KAKAO
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val TAG="LoginFragment"
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by activityViewModels()

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
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        }
        // 카카오톡 로그인 성공 시
        else if (token != null) {
            val accessToken="$BEARER${token.accessToken}"
            Log.e(TAG, accessToken)
//            viewModel.login(accessToken, OauthRequest(LOGIN_KAKAO))
            findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToCountrySelectFragment())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kakaoLogin()
    }

    private fun kakaoLogin() {
        with(binding) {
            kakaoLoginImageView.setOnAvoidDuplicateClick {
               /* if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
                    Log.e("TAG", "Kakao Talk")
                    UserApiClient.instance.loginWithKakaoTalk(
                        requireContext(),
                        callback = callback
                    )
                } else {
                    Log.e("TAG", "Kakao Account")
                    UserApiClient.instance.loginWithKakaoAccount(
                        requireContext(),
                        callback = callback
                    )
                }*/
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToCountrySelectFragment())
            }
        }
    }





}
