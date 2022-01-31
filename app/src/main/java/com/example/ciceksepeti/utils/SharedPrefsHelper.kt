package com.example.ciceksepeti.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class SharedPrefsHelper private constructor(context: Context) {
    private val privateSharedPreferences: SharedPreferences

    private fun storeString(key: String, content: String) {
        val editor = privateSharedPreferences.edit()
        editor.putString(key, content)
        editor.apply()
    }

    private fun getStringFromSharedPreferences(key: String): String? {
        return privateSharedPreferences.getString(key, "")
    }

    private fun getStringFromSharedPreferences(key: String, defaultKey: String?): String? {
        return privateSharedPreferences.getString(key, defaultKey)
    }

    private fun storeLong(key: String, value: Long) {
        val editor = privateSharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    private fun getLongFromSharedPreferences(key: String): Long {
        return privateSharedPreferences.getLong(key, 0L)
    }

    private fun storeInt(key: String, value: Int) {
        val editor = privateSharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    private fun getIntFromSharedPreferences(key: String): Int {
        return privateSharedPreferences.getInt(key, DEFAULT_INT_VALUE)
    }

    private fun storeStringSet(key: String, value: Set<String>) {
        val editor = privateSharedPreferences.edit()
        editor.remove(key)
        editor.apply()
        editor.putStringSet(key, value)
        editor.apply()
    }

    private fun getStringSetFromSharedPreferences(key: String): Set<String>? {
        return privateSharedPreferences.getStringSet(key, HashSet())
    }
    fun saveDataWithKey(data: String, key: String) {
        storeString(key, data)
    }

    fun getDataWithKey(key: String): String? {
        return getStringFromSharedPreferences(key)
    }
    fun saveDetailId(detailId: String) {
        storeString(DETAIL_VALUE, detailId)
    }

    val detailId: String?
        get() = getStringFromSharedPreferences(DETAIL_VALUE)

    companion object {
        private const val SHARED_PREFERENCES_KEY = "xpay.com.xpay.data"
        private const val DEFAULT_INT_VALUE = -1
        private var instance: SharedPrefsHelper? = null
        private const val DETAIL_VALUE = "DETAIL_VALUE"
        fun getInstance(context: Context): SharedPrefsHelper? {
            synchronized(SharedPrefsHelper::class.java) {
                if (instance == null) {
                    instance = SharedPrefsHelper(context)
                }
                return instance
            }
        }
    }

    init {
        privateSharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
    }
}