package com.devrachit.swiggy_com_imdb.presentation.screens.list


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.swiggy_com_imdb.domain.model.SearchResult
import com.devrachit.swiggy_com_imdb.domain.usecase.SearchTitleDetailsUseCase
import com.devrachit.swiggy_com_imdb.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewmodel @Inject constructor(
    private val searchTitles: SearchTitleDetailsUseCase
) : ViewModel() {
    private val TAG = "ListScreenViewmodel"

    private val _uiState = MutableStateFlow(States())
    val uiState:StateFlow<States> = _uiState.asStateFlow()

    fun getSearchResults(query:String){
        viewModelScope.launch(Dispatchers.IO) {
            searchTitles.invoke(query).collectLatest {response->
                when (response)
                {
                    is Resource.Success->{
                        _uiState.value = _uiState.value.copy(
                            list=response.data?:SearchResult(emptyList())
                        )
                    }
                    is Resource.Error ->{

                    }
                    is Resource.Loading-> {

                    }
                }
            }
        }
    }

}