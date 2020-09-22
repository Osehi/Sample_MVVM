package com.polish.mycomments.data.network

import com.polish.mycomments.model.POSTItem

interface HomePageRepository {

   suspend fun getMyPost():List<POSTItem>

}