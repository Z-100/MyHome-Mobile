package com.myhome.blueprint

import com.myhome.other.Headers

class SecurityHeaders {

    private val headers: HashMap<String, String> = HashMap();

    fun setHeaders(email: String, password: String, token: String) {
        headers[Headers.EMAIL] = email
        headers[Headers.PASSWORD] = password
        headers[Headers.TOKEN] = token
    }

    fun getHeaders(): HashMap<String, String> {
        return headers;
    }

    fun addHeader(key: String, value: String) {
        headers.replace(key, value)
    }
}
