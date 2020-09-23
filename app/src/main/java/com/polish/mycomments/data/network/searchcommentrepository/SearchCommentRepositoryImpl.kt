package com.polish.mycomments.data.network.searchcommentrepository

import com.polish.mycomments.data.api.SearchAPI
import com.polish.mycomments.model.jpcomments.JPostCommentItem
import com.polish.mycomments.model.jpsearch.JPSearchItem
import com.polish.mycomments.model.jpsearch.UserIdInput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SearchCommentRepositoryImpl:SearchCommentRepository {

    /*
        this is a manual dependency injection
     */
    val searchAPI = SearchAPI()

    /*
        get data from the network in a coroutinescope
     */

    override suspend fun getMySearchItems(userIdInput: String): List<JPostCommentItem> {

        return withContext(Dispatchers.IO){
            searchAPI.findComments(userIdInput)
        }
    }
}