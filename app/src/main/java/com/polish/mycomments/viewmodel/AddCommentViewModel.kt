package com.polish.mycomments.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polish.mycomments.data.network.addcommentrepository.AddCommentRepositoryImpl
import com.polish.mycomments.model.jpbody.JPBody
import com.polish.mycomments.model.jpbody.JPPostResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddCommentViewModel:ViewModel() {

    val TAG = "ADD_COMMENT_VIEWMODEL"

/*
        a manual injection of the repository dependency
     */
    val addCommentRepositoryImpl = AddCommentRepositoryImpl()

    /*
        create a coroutine job to handle data on the UI thread
     */
    private val job = Job()
    private val viewModelScope = CoroutineScope( job + Dispatchers.Main)

    /*
        let us use livedata to observe the data on the fragment
     */
    private val _viewMyPostResponse = MutableLiveData<JPPostResponse>()
    val viewMyPostResponse:LiveData<JPPostResponse>
    get() = _viewMyPostResponse


    /*
        post comment under the coroutineScope and receive the response
     */
    fun posting(body:JPBody){
        viewModelScope.launch {
            try {
                _viewMyPostResponse.value = addCommentRepositoryImpl.postYourComment(body)
            } catch (t:Throwable){
                Log.d(TAG, t.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }




}