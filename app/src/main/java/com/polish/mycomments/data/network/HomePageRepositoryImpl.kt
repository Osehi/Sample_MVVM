package com.polish.mycomments.data.network

import com.polish.mycomments.data.api.PostAPI
import com.polish.mycomments.model.POSTItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomePageRepositoryImpl:HomePageRepository {

    /*
        this is a manual dependency injection
     */
    val postAPI = PostAPI()

    override suspend fun getMyPost(): List<POSTItem> {
        return withContext(Dispatchers.IO){
            postAPI.viewPosts()
        }
    }
}