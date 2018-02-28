package com.jorzet.apprendiendoeeg.security

import android.content.Context

/**
 * Created by Jorge Zepeda Tinoco on 25/02/18.
 * jorzet.94@gmail.com
 */

open class AccessToken {

    companion object Factory {

        val TOKEN_NAME_FILE: String = "com.eeg.pt1_v1.security.AccessToken"
        val TOKEN_NAME: String = "token_name"

        /**
         *
         */
        fun setAccessToken(context : Context, token : String) {
            val editor = context.getSharedPreferences(AccessToken.TOKEN_NAME_FILE, Context.MODE_PRIVATE).edit();
            editor.putString(AccessToken.TOKEN_NAME, token);
            editor.apply();
        }

        /**
         *
         */
        fun getCurrentAccessToken(context: Context): String {
            val prefs = context.getSharedPreferences(AccessToken.TOKEN_NAME_FILE, Context.MODE_PRIVATE);
            return prefs.getString(AccessToken.TOKEN_NAME, null);
        }
    }

}