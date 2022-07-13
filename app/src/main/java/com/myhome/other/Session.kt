package com.myhome.other

import android.os.Build
import androidx.annotation.RequiresApi
import com.myhome.blueprint.Account
import com.myhome.blueprint.SecurityHeaders
import com.myhome.blueprint.Member

//TODO Rework entire Session
class Session {
    companion object Factory {

        private var USER_ACCOUNT: Account? = null
        private var USER_SESSION: Member? = null
        private var AUTH: SecurityHeaders? = null
        private var ALL_MEMBERS: List<Member> = ArrayList()

        fun create(member: Member) {
            if (this.USER_SESSION == null)
                this.USER_SESSION = member
            else update(member)
        }

        fun create(member: Member, members: List<Member>) {
            if (this.USER_SESSION == null) {
                this.USER_SESSION = member
                this.ALL_MEMBERS = members
            }
            else update(member, members)
        }

        fun getMember(): Member? {
            return this.USER_SESSION
        }

        fun getMembers(): List<Member> {
            return this.ALL_MEMBERS
        }

        fun update(member: Member) {
            this.USER_SESSION = member
        }

        fun addAuth(securityHeaders: SecurityHeaders) {
            this.AUTH = securityHeaders
        }

        fun addAuth(key: String, value: String) {
            if (this.AUTH == null)
                this.AUTH = SecurityHeaders()

            this.AUTH!!.addHeader(key, value)
        }

        fun getAuth(): SecurityHeaders {
            if (this.AUTH == null)
                this.AUTH = SecurityHeaders()

            return this.AUTH!!
        }

        fun update(member: Member, members: List<Member>) {
            this.USER_SESSION = member
            this.ALL_MEMBERS = members
        }

        fun destroy() {
            this.USER_SESSION = null
            this.ALL_MEMBERS = emptyList()
        }
    }
}