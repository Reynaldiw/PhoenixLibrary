package com.reynaldiwijaya.phoenix.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update
import io.reactivex.Single

/**
 * <T> : Your Data Model Class
 */
interface RxLocalDb<T> {

    // Basic functions, no need to override

    @Insert(onConflict = REPLACE)
    fun save(vararg response: T)

    @Update
    fun update(vararg response: T)

    @Delete
    fun remove(vararg response: T)


    // Override this method to comply each class needs

    fun get(intId: Int? = 0): Single<T>

    fun getList(): Single<List<T>>

    fun remove(intId: Int? = 0)

    fun removeAll()

    fun isItemCached(intId: Int? = 0, strId: String? = ""): Single<Boolean>

    fun isItemCacheExpired(intId: Int? = 0, strId: String? = ""): Single<Boolean>

    fun isCached(): Single<Boolean>

    fun isCacheExpired(): Single<Boolean>
}