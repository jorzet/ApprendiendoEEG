package com.jorzet.apprendiendoeeg.utils

class HttpUtil {

    enum class RestfulMethod {
        GET, POST, PUT, PATCH, DELETE
    }

    companion object {
        val APLICATION_JSON : String = "application/json"
        val APLICATION_XML : String = "application/xml"
    }
}