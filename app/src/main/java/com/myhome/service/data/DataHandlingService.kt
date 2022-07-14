package com.myhome.service.data

import android.content.SharedPreferences
import com.myhome.Application
import com.myhome.blueprint.Account
import com.myhome.blueprint.Member
import com.myhome.blueprint.SecurityHeaders
import com.myhome.other.Session
import com.myhome.other.SharedPref

class DataHandlingService {

    private val sharedPref: SharedPreferences = Application.sp

    fun saveData() {
        val editor = sharedPref.edit()

        val account = Session.getAccount()
        val currentMember = Session.getCurrentMember()

        if (account != null)
            editor.apply {
                  putString(SharedPref.EMAIL, account.email)
                  putString(SharedPref.PASSWORD, account.password)
                  putString(SharedPref.TOKEN, account.token)
            }.apply()

        if (currentMember != null)
            editor.apply {
                putLong(SharedPref.MEMBER_ID, currentMember.id)
                putString(SharedPref.MEMBER_NAME, currentMember.name)
                putInt(SharedPref.MEMBER_ICON, currentMember.icon)
            }.apply()
    }

    fun loadData() {
        val email = sharedPref.getString(SharedPref.EMAIL, null)
        val password = sharedPref.getString(SharedPref.PASSWORD, null)
        val token = sharedPref.getString(SharedPref.TOKEN, null)

        val memberId = sharedPref.getLong(SharedPref.MEMBER_ID, -1L)
        val memberName = sharedPref.getString(SharedPref.MEMBER_NAME, null)
        val memberIcon = sharedPref.getInt(SharedPref.MEMBER_ICON, -1)

        Session.addAccount(Account(email, password, token))

        if (memberId != -1L && memberName != null && memberIcon != -1) {
            Session.addAuth(SecurityHeaders(email!!, password!!, token!!))
            Session.setCurrentMember(Member(memberId, memberName, memberIcon))
        }
    }
}
