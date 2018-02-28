package com.jorzet.apprendiendoeeg.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.jorzet.apprendiendoeeg.R
import com.jorzet.apprendiendoeeg.security.AccessToken

/**
 * Created by Jorge Zepeda Tinoco on 25/02/18.
 * jorzet.94@gmail.com
 */

class Splash : BaseActivityLifecycle() {
    val TIME_OUT : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        launchSplash()
    }

    fun launchSplash() {
        Handler().apply {
            val runnable = object : Runnable {
                override fun run() {
                    AccessToken.setAccessToken(applicationContext,"hola")
                    val token = AccessToken.getCurrentAccessToken(applicationContext)
                    if (token.equals(""))
                        goLogInActivity();
                    else
                        goHomeActivity();
                }
            }
            postDelayed(runnable, TIME_OUT)
        }
    }

    fun goHomeActivity() {
        val intent = Intent(this, ContentActivity::class.java)
        startActivity(intent)
    }

    fun goLogInActivity() {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }
}
