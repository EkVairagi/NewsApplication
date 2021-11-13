package com.example.newsapplication.api

import com.example.newsapplication.Util.Constants.Companion.BASE_URL
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstances
{
    /*
    * lazy means here we initialize this once
    * */
    companion object{
        private val retrofit by lazy {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }

        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }

    }
}