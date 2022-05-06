package com.myhome.service.data

import android.content.SharedPreferences
import com.myhome.blueprint.Account
import com.myhome.other.SpStrings

/**
 * Class used to save and retrieve data from SharedPreferences
 */
class DataHandlingService {

    fun saveData(sharedPref: SharedPreferences, account: Account?): Boolean {

        val editor = sharedPref.edit()

        if (account == null) {
            editor.clear()
            return true
        }

        editor.apply {
              putString(SpStrings.EMAIL, account!!.email)
              putString(SpStrings.PASSWORD, account.password)
              putString(SpStrings.TOKEN, account.token)
        }.apply()

        return sharedPref.getString(SpStrings.EMAIL, null) != null
                && sharedPref.getString(SpStrings.PASSWORD, null) != null
    }

    fun loadData(sharedPref: SharedPreferences): Account? {

        val email = sharedPref.getString(SpStrings.EMAIL, null)
        val password = sharedPref.getString(SpStrings.PASSWORD, null)
        val token = sharedPref.getString(SpStrings.TOKEN, null)

        return if (email != null && password != null && token != null)
            Account(email, password, token) else null
    }
}