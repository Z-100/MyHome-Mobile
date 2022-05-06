package com.myhome.other

import com.myhome.blueprint.Member

class Session {
    companion object Factory {

        private var USER_SESSION: Member? = null
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