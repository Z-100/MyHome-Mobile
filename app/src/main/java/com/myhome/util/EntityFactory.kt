package com.myhome.util

import java.lang.IllegalArgumentException

class EntityFactory<T> {

    companion object {
        fun <T> getInstance(t: Class<T>): T {
            return try {
                t.newInstance()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
                throw IllegalArgumentException("Class of type $t not found.")
            }
        }
    }
}
