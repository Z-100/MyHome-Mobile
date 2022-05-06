package com.myhome.other

import com.myhome.blueprint.Member

class Session {
    companion object Factory {

        private var USER_SESSION: Member? = null

        fun create(member: Member) {
            if (this.USER_SESSION == null)
                this.USER_SESSION = member
            else update(member)
        }

        fun get(): Member? {
            return this.USER_SESSION
        }

        fun update(member: Member) {
            this.USER_SESSION = member
        }

        fun destroy() {
            this.USER_SESSION = null
        }
    }
}