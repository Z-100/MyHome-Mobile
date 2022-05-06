package com.myhome.other

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

class SharedPreferencesStrings {
    companion object Factory {
        const val SHARED_PREF_NAME = "user-preferences"

        const val EMAIL = "e-mail"
        const val PASSWORD = "password"
        const val TOKEN = "token"
    }
}

class Strings {
    companion object Factory {
        const val DEFAULT_MEMBER_NAME = "ma-ta"

        // Error
        const val FILL_IN_ALL_FIELDS = "Please fill in all fields!"
        const val INVALID_USERNAME_OR_PASSWORD = "The entered username and/or password are wrong"
        const val USERNAME_ALREADY_TAKEN = "The entered username already is taken"
    }
}
