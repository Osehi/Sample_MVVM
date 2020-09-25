package com.polish.mycomments.data.api

import com.polish.mycomments.constants.URLConstants
import com.polish.mycomments.constants.URLEndPoint
import com.polish.mycomments.helper.LoggingInterceptor
import com.polish.mycomments.model.jpbody.JPBody
import com.polish.mycomments.model.jpbody.JPPostResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface CommentAPI {

    /*
        this is the endpoint for the API
     */
    @POST(URLEndPoint.POST_A_COMMENT)
    suspend fun postMyComment(
        @Body body:JPBody
    ):JPPostResponse

    /*
        this function creates the web_service for the retrofit to make a network call
     */

    companion object {
    /*
        val client = OkHttpClient.Builder().build()

     */

        operator fun invoke():CommentAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .client(LoggingInterceptor.okHttpClient)
                .build()
                .create(CommentAPI::class.java)
        }

    }

}