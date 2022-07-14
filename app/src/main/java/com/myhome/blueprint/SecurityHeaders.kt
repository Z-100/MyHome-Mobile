package com.myhome.blueprint

import com.myhome.other.Headers

class SecurityHeaders(email: String, password: String, token: String) {

    constructor() : this("", "", "")

    private val headers = HashMap<String, String>()

    init {
        headers[Headers.EMAIL] = email
        headers[Headers.PASSWORD] = password
        headers[Headers.TOKEN] = token
    }

    fun getHeaders(): HashMap<String, String> {
        return headers
    }

    fun addHeader(key: String, value: String) {
        headers[key] = value
    }

    fun replaceHeader(key: String, value: String) {
        headers.replace(key, value)
    }
}
