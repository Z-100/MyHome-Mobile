package com.myhome.other

import android.view.View
import com.google.android.material.snackbar.Snackbar

// API Constants
class ApiConstants {
    companion object Factory {
        // ! Replace by server IP
        const val BASE_URL = "http://10.62.110.24:8080"

        // Actual constants
        const val REGISTRATION_TOKEN = "MAHANSH MUTEM blyat suk my dik"
        const val LOGIN_TOKEN = "ma-ta este super dracu, blyat"

        const val DEFAULT_HOME_NAME = "Home"
        const val NEW_HOUSE_FIELD = "newHouseName"
        const val DEFAULT_MEMBER_FIELD = "defaultMemberName"
        const val INVALIDCREDENTIALSERROR = "Invalid Credentials"

        const val EMAIL_FIELD = "email"
        const val PASSWORD_FIELD = "password"
        const val TOKEN_FIELD = "token"
        const val MEMBER_ID_FIELD = "member-id"
        const val ICON_FIELD = "icon"
        const val NAME_FIELD = "name"
        const val REPLACEMENT_ICON_FIELD = "replacement-icon"
        const val REPLACEMENT_NAME_FIELD = "replacement-name"
        const val ID_FIELD = "id"
        const val MEMBER_FIELD = "Members"
        const val GET_RATING_FIELD = "get-rating"

        const val TAG = "api"
        const val DEFAULT_ICON = "3"
    }
}

class ApiError {
    companion object Factory {
        const val GENERAL_ERROR = "Something went wrong. Please try again later"
    }
}

// Fragment Constants
class Constants {
    companion object Factory {

    }
}

class SharedPreferencesStrings {
    companion object Factory {
        const val SHARED_PREF_NAME = "user-preferences"

        const val EMAIL = "e-mail"
        const val PASSWORD = "password"
        const val TOKEN = "token"
    }
}

// Fragment Constants
class Constants {
    companion object Factory {

    }
}

class SharedPreferencesStrings {
    companion object Factory {
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}
