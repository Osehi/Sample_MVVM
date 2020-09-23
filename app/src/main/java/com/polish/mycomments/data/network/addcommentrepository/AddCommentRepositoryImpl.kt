package com.polish.mycomments.data.network.addcommentrepository

import com.polish.mycomments.data.api.CommentAPI
import com.polish.mycomments.model.jpbody.JPBody
import com.polish.mycomments.model.jpbody.JPPostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddCommentRepositoryImpl:AddCommentRepository {

    val TAG = "ADDCOMMENTREPOIMPL"
    /*
        a manual injection of the api
     */
    private val commentAPI = CommentAPI()

    override suspend fun postYourComment(body: JPBody): JPPostResponse {

        return withContext(Dispatchers.IO){
            commentAPI.postMyComment(body)
        }

    }
}