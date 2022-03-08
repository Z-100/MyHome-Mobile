package com.myhome.other

import android.view.View
import com.google.android.material.snackbar.Snackbar

class Constants {
    companion object Factory {
        const val killAndy: String = "Kill him"
    }
}

class SharedPreferencesStrings {
    companion object Factory {
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}

class Snackbar {
    companion object Factory {
        fun displaySnackbar(s: String, view: View) {
            Snackbar.make(view, s, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
