package com.reynaldiwijaya.phoenix.data

interface PreferenceManager {
    fun getBoolean(key: String, default: Boolean = false): Boolean
    fun saveBoolean(key: String, value: Boolean)

    fun getInt(key: String, default: Int = 0): Int
    fun saveInt(key: String, value: Int)

    fun getString(key: String, default: String = ""): String
    fun saveString(key: String, value: String)

    fun getLong(key: String, default: Long = 0): Long
    fun saveLong(key: String, value: Long)

    fun getFloat(key: String, default: Float = 0f): Float
    fun saveFloat(key: String, value: Float)

    fun <T> getObject(key: String, type: Class<T>): T?
    fun saveObject(key: String, value: Any)
}