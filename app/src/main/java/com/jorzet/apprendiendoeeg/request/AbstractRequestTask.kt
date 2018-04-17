package com.jorzet.apprendiendoeeg.request

import android.os.AsyncTask

/**
 * Created by Jorge Zepeda Tinoco on 17/04/2018.
 * jorzet.94@gmail.com
 */

abstract open class AbstractRequestTask<A, B, C> : AsyncTask<A, B, C>() {

    private lateinit var mUrl : String
    private lateinit var mResponse : String

    private lateinit var onRequestListenerSucces : OnRequestListenerSuccess
    private lateinit var onRequestLietenerFailed : OnRequestListenerFailed

    interface OnRequestListenerSuccess {
        fun onSuccess(result: Any)
    }

    interface OnRequestListenerFailed {
        fun onFailed(result: Any)
    }

    public fun setOnRequestListenerSuccess(onResquestListenerSuccess : OnRequestListenerSuccess) {
        this.onRequestListenerSucces = onRequestListenerSucces
    }

    public fun setOnRequestListenerFailed(onRequestListenerFailed : OnRequestListenerFailed) {
        this.onRequestLietenerFailed = onRequestLietenerFailed
    }

    protected open fun getUrl() : String {
        return ""
    }

    override protected fun onPreExecute() {
        super.onPreExecute()
        mUrl = getUrl()
    }

    override protected fun doInBackground(vararg p0: A): C? {
        return null
    }

    override protected fun onPostExecute(result: C) {
        super.onPostExecute(result)
        mResponse = result as String
    }

    protected open fun onGettingResponse(response : C) {

    }
}