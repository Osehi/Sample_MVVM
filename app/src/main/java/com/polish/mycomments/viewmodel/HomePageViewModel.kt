package com.polish.mycomments.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polish.mycomments.data.network.HomePageRepositoryImpl
import com.polish.mycomments.model.POSTItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomePageViewModel:ViewModel() {

    val TAG = "HOME_PAGE_VIEWMODEL"
    /*
        a manual injection of the repository dependency
     */
    val homePageRepository = HomePageRepositoryImpl()

    /*
        create a coroutine job to handle data on the UI thread
     */
    private val job = Job()
    private val viewModelScope = CoroutineScope(job + Dispatchers.Main)

    /*
        lets use Livedata to observe the data on the fragment
     */
    private val _myListOfPost = MutableLiveData<List<POSTItem>>()
    val myListOfPost: LiveData<List<POSTItem>>
    get() = _myListOfPost

    init {
        displayMyPost()
    }


    /*
        get data under the coroutinescope
     */
    fun displayMyPost(){

        viewModelScope.launch {
            try {
                _myListOfPost.value = homePageRepository.getMyPost()
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