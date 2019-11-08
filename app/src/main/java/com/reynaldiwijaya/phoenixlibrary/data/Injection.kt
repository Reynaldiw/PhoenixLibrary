package com.reynaldiwijaya.phoenixlibrary.data

object Injection {

    fun providePhoenixDataStore() : PhoenixDataStore {
        return PhoenixDataStore()
    }
}