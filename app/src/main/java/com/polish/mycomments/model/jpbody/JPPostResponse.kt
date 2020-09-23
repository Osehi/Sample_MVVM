package com.polish.mycomments.model.jpbody


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JPPostResponse(
    val body: String?,
    val id: Int?,
    val title: String?,
    val userId: Int?
):Parcelable