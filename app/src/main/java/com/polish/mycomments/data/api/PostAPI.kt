package com.polish.mycomments.data.api

import com.polish.mycomments.constants.URLConstants
import com.polish.mycomments.constants.URLEndPoint
import com.polish.mycomments.helper.LoggingInterceptor
import com.polish.mycomments.model.POSTItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostAPI {

    /*
        this is the endpoint interface for the api
     */
    @GET(URLEndPoint.LIST_OF_POST)
    suspend fun viewPosts():List<POSTItem>
    /*
        this function creates the web_service for the retrofit to make a network call
     */
    companion object {

        operator fun invoke():PostAPI {
            /**
             *  the HttpLoggingInterceptor shows information of the request and response
             */
/*
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

 */


            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .client(LoggingInterceptor.okHttpClient)
                .build()
                .create(PostAPI::class.java)

        }

    }

}