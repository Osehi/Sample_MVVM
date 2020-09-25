package com.polish.mycomments.helper

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object LoggingInterceptor {

    /**
     *  HttpLoggingInterceptor shows the request and response to jsonplaceholderapi
     */

    val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()



}