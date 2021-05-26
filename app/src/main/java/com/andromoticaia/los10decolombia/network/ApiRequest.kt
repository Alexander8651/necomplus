package com.andromoticaia.los10decolombia.network

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASEURL = "http://ws.audioscrobbler.com/2.0/"

val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.BODY
}

val client: OkHttpClient = OkHttpClient.Builder().apply {
    this.addInterceptor(interceptor)
    this.readTimeout(10, TimeUnit.SECONDS)
    connectTimeout(10, TimeUnit.SECONDS)
}.build()


val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASEURL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

object RetrofitService{
    val retrofitService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}