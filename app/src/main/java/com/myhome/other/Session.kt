package com.myhome.other

import com.myhome.blueprint.Account

class Session {
    companion object Factory {

        private var USER_SESSION: Account? = null

        fun create(account: Account): Account? {
            if (this.USER_SESSION != null)
                this.USER_SESSION = account

            return this.USER_SESSION
        }

        fun get(): Account? {
            return this.USER_SESSION
        }

        fun update(account: Account) {
            this.USER_SESSION = account
        }

        fun destroy() {
            this.USER_SESSION = null
        }
    }
}