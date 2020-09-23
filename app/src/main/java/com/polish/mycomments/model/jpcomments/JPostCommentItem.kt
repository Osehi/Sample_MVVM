package com.polish.mycomments.model.jpcomments


import com.google.gson.annotations.SerializedName

data class JPostCommentItem(
    val body: String?,
    val email: String?,
    val id: Int?,
    val name: String?,
    val postId: Int?
)