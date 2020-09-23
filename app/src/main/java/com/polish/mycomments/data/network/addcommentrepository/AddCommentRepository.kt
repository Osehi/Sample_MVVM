package com.polish.mycomments.data.network.addcommentrepository

import com.polish.mycomments.model.jpbody.JPBody
import com.polish.mycomments.model.jpbody.JPPostResponse

interface AddCommentRepository {

    suspend fun postYourComment(body:JPBody):JPPostResponse

}