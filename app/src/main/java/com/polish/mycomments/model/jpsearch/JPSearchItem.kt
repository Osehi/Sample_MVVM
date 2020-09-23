package com.polish.mycomments.model.jpsearch


import com.google.gson.annotations.SerializedName

data class JPSearchItem(
    val body: String?,
    val id: Int?,
    val title: String?,
    val userId: Int?
)