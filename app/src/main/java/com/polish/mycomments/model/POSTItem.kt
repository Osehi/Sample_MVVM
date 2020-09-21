package com.polish.mycomments.model


import com.google.gson.annotations.SerializedName

data class POSTItem(
    val body: String?,
    val id: Int?,
    val title: String?,
    val userId: Int?
)