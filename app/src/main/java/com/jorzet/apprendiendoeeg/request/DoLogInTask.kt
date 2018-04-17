package com.jorzet.apprendiendoeeg.request

import android.content.Context

/**
 * Created by Jorge Zepeda Tinoco on 17/04/2018.
 * jorzet.94@gmail.com
 */

class DoLogInTask(context: Context) : AbstractRequestTask<Void, Void, String>() {

    private val mContext : Context = context

    override fun getUrl(): String {
        return super.getUrl()
    }

    override fun onGettingResponse(response: String) {
        super.onGettingResponse(response)

    }
}