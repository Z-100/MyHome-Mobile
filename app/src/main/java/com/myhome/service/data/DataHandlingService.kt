package com.myhome.service.data

import android.content.SharedPreferences
import com.myhome.blueprint.Account
import com.myhome.other.SharedPreferencesStrings

/**
 * Class used to save and retrieve data from SharedPreferences
 */
class DataHandlingService {

    fun saveData(sharedPref: SharedPreferences, account: Account): Boolean {

        val editor = sharedPref.edit()

        editor.apply {
              putString(SharedPreferencesStrings.EMAIL, account.email)
              putString(SharedPreferencesStrings.PASSWORD, account.password)
        }.apply()

        return sharedPref.getString(SharedPreferencesStrings.EMAIL, null) != null
                && sharedPref.getString(SharedPreferencesStrings.PASSWORD, null) != null
    }

    fun loadData(sharedPref: SharedPreferences): Account? {

        val email = sharedPref.getString(SharedPreferencesStrings.EMAIL, null)
        val password = sharedPref.getString(SharedPreferencesStrings.PASSWORD, null)

        return if (email != null && password != null)
            Account(email, password) else null
    }
}