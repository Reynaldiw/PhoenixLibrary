package com.reynaldiwijaya.phoenixlibrary.data.remote

import com.reynaldiwijaya.phoenix.libs.ApiService
import com.reynaldiwijaya.phoenixlibrary.data.model.MovieResponse
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface WebService {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") api_key: String): Single<MovieResponse>

    companion object {
        fun createOkHttpClient(interceptor: PhoenixInterceptor) : OkHttpClient {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val timeout = 120L
            return OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(interceptor)
                .build()
        }

        /**
         *  To Call method Retrofit with RxAdapter in PhoenixLib,
         *  yo have to parse the class which is your service, okHttpClient,
         *  and url
         */
        val apiService = ApiService.createReactiveService(
            WebService::class.java, createOkHttpClient(PhoenixInterceptor()), "http://api.themoviedb.org/3/")

        /**
         * And if you want to call method Retrofit without Rx, you can call like this
         */
//        val apiService = ApiService.createService(
//            WebService::class.java, createOkHttpClient(PhoenixInterceptor()), "http://api.themoviedb.org/3/"
//        )
    }

    class PhoenixInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var requestBody = chain.request()
            requestBody = requestBody.newBuilder()
                .build()
            return chain.proceed(requestBody)
        }

    }
}