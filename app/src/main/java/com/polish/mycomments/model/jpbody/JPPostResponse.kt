package com.polish.mycomments.model.jpbody


import com.google.gson.annotations.SerializedName

data class JPPostResponse(
    val body: String?,
    val id: Int?,
    val title: String?,
    val userId: Int?
)