package com.poten.android.tripj.presentation.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.poten.android.tripj.databinding.ActivityLoginBinding
import com.poten.android.tripj.presentation.ui.select.SelectActivity
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        /*
           TODO : 카카오 및 네이버 소셜 로그인 구현 (Server와 연동)
           TODO : 로그인 한 적이 있어 Token 값을 가지고 있다면 자동 나라 선택 화면으로 점프
         */

        with(binding) {
            kakaoLoginImageView.setOnAvoidDuplicateClick {
                // 임시 화면 전환용 코드
                val intent = Intent(this@LoginActivity, SelectActivity::class.java)
                startActivity(intent)
            }


            naverLoginImageView.setOnAvoidDuplicateClick {

            }
        }


    }
}