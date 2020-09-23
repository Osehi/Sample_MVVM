package com.polish.mycomments.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polish.mycomments.data.network.searchcommentrepository.SearchCommentRepositoryImpl
import com.polish.mycomments.model.jpcomments.JPostCommentItem
import com.polish.mycomments.model.jpsearch.JPSearchItem
import com.polish.mycomments.model.jpsearch.UserIdInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchCommentViewModel:ViewModel() {

    val TAG = "SERCH_COMMENT_VIEWmODEL"

    /*
        a manual injection of the searchCommentRepository
     */
    val searchCommentRepository = SearchCommentRepositoryImpl()

    /*
        create a coroutine job to handle data in the UI thread
     */
    private val job = Job()
    private val viewModelScope = CoroutineScope( job + Dispatchers.Main)

    /*
        use livedata to observe the data on the fragment
     */
    private val _searchResult = MutableLiveData<List<JPostCommentItem>>()
    val searchResult:LiveData<List<JPostCommentItem>>
    get() = _searchResult


    /*
        get data in the coroutine scope to bring them to the main thread
     */
    /*
    init {
        val userIdInput = UserIdInput("1")
        displaySearchResult(userIdInput)
    }

     */

    fun displaySearchResult(userIdInput: String){

        viewModelScope.launch {
            try {
              val searchComments = searchCommentRepository.getMySearchItems(userIdInput)
                _searchResult.value =  searchComments

                Log.d(TAG, "check here: ${searchComments}")
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