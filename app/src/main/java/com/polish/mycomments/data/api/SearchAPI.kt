package com.polish.mycomments.data.api

import com.polish.mycomments.constants.URLConstants
import com.polish.mycomments.constants.URLEndPoint
import com.polish.mycomments.helper.LoggingInterceptor
import com.polish.mycomments.model.jpcomments.JPostCommentItem
import com.polish.mycomments.model.jpsearch.JPSearchItem
import com.polish.mycomments.model.jpsearch.UserIdInput
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    /*
        this is the endpoint
     */
    @GET(URLEndPoint.SEARCH_COMMENTS_BY_POSTID)
    suspend fun findComments(
        @Query("postId") userId:String
    ): List<JPostCommentItem>

    /*
        this function creates the apiservice
     */

    companion object {


        /*
            this is an okHttp client
         */
        /*
        val client = OkHttpClient.Builder().build()

         */

        operator fun invoke():SearchAPI{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .client(LoggingInterceptor.okHttpClient)
                .build()
                .create(SearchAPI::class.java)

        }

    }

}