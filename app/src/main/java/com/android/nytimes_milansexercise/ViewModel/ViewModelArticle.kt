package com.android.nytimes_milansexercise.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.nytimes_milansexercise.Data.DataArticle
import com.android.nytimes_milansexercise.Repository.RepositoryApi
import com.android.nytimes_milansexercise.Utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelArticle @Inject constructor(val repositoryApi: RepositoryApi) : ViewModel(){

    var _articleResponse = MutableLiveData<Resource<DataArticle>>()
    val articleResponse: LiveData<Resource<DataArticle>> get() = _articleResponse

    fun getArticle() = viewModelScope.launch {
        _articleResponse.value = repositoryApi.articles()
    }

}