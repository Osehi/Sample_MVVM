package com.polish.mycomments.data.network.searchcommentrepository

import com.polish.mycomments.model.jpcomments.JPostCommentItem
import com.polish.mycomments.model.jpsearch.JPSearchItem
import com.polish.mycomments.model.jpsearch.UserIdInput

interface SearchCommentRepository {

    suspend fun getMySearchItems(userIdInput: String):List<JPostCommentItem>

}