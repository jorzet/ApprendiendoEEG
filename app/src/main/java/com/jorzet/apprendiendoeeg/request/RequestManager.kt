package com.jorzet.apprendiendoeeg.request

import android.content.Context

/**
 * Created by Jorge Zepeda Tinoco on 17/04/2018.
 * jorzet.94@gmail.com
 */

class RequestManager(context: Context) {
    private val mContext : Context = context

    fun requestDoLogIn() {

    }

    interface OnDoLogInListener {
        fun onDoSignInLoaded(result: String)
        fun onDoSignInError(throwable: String)
    }

    interface OnSingUpListener {
        fun onSingUpLoaded(result: String)
        fun onSingUpError(throwable: String)
    }
}