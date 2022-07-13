package com.myhome.service.data

import android.content.SharedPreferences
import com.myhome.Application
import com.myhome.blueprint.Account
import com.myhome.other.Session
import com.myhome.other.SpStrings
import java.lang.Appendable

//TODO Switch to session management
class DataHandlingService {

    private val sharedPref: SharedPreferences = Application.sp;

    //TODO Replace by session
    //TODO Session should contain all information
    fun saveData(): Boolean {

        val editor = sharedPref.edit()

        if (Session == null) {
            editor.clear()
            return true
        }

        editor.apply {
              putString(SpStrings.EMAIL, account.email)
              putString(SpStrings.PASSWORD, account.password)
              putString(SpStrings.TOKEN, account.token)
        }.apply()

        return sharedPref.getString(SpStrings.EMAIL, null) != null
                && sharedPref.getString(SpStrings.PASSWORD, null) != null
    }

    fun loadData(): Session? {

        val email = sharedPref.getString(SpStrings.EMAIL, null)
        val password = sharedPref.getString(SpStrings.PASSWORD, null)
        val token = sharedPref.getString(SpStrings.TOKEN, null)
        val lastUsedMember = sharedPref.getString(SpStrings.LAST_MEMBER, null)

        return if (email != null && password != null && token != null)
            Account(email, password, token) else null
    }
}
