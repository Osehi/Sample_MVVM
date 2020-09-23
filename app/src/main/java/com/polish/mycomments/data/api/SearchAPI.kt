package com.polish.mycomments.data.api

import com.polish.mycomments.constants.URLConstants
import com.polish.mycomments.constants.URLEndPoint
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
    @GET(URLEndPoint.SEARCH_FOR_COMMENTS)
    suspend fun findComments(
        @Query("userId") userId:UserIdInput
    ): List<JPSearchItem>

    /*
        this function creates the apiservice
     */

    companion object {

        /*
            this is an okHttp client
         */
        val client = OkHttpClient.Builder().build()

        operator fun invoke():SearchAPI{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .client(client)
                .build()
                .create(SearchAPI::class.java)

        }

    }

}