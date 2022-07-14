package com.myhome.other

import com.myhome.blueprint.Account
import com.myhome.blueprint.SecurityHeaders
import com.myhome.blueprint.Member

class Session {
    companion object Factory {

        // ? Get from SharedPreferences / API
        private var USER_ACCOUNT: Account? = null

        // ? Get from SharedPreferences / API
        private var AUTH: SecurityHeaders? = null

        // ? Get from members page
        private var CURRENT_MEMBER: Member? = null

        // ? Get from members page
        private var ALL_MEMBERS: List<Member> = ArrayList()

        fun addAccount(account: Account) {
            this.USER_ACCOUNT
        }

        fun getAccount(): Account? {
            return this.USER_ACCOUNT
        }

        fun addAuth(securityHeaders: SecurityHeaders) {
            this.AUTH = securityHeaders
        }

        fun replaceHeader(key: String, value: String) {
            if (this.AUTH == null)
                this.AUTH = SecurityHeaders()

            this.AUTH!!.replaceHeader(key, value)
        }

        fun getAuth(): SecurityHeaders? {
            return this.AUTH!!
        }

        fun addCurrentMember(member: Member) {
            this.CURRENT_MEMBER = member
        }

        fun getCurrentMember(): Member? {
            return this.CURRENT_MEMBER
        }

        fun exists(): Boolean {
            return this.USER_ACCOUNT != null
                    && this.AUTH != null
                    && this.CURRENT_MEMBER != null
        }

        fun destroy() {
            this.CURRENT_MEMBER = null
            this.ALL_MEMBERS = emptyList()
        }
    }
}