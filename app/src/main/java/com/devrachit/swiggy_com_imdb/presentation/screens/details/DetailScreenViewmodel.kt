package com.devrachit.swiggy_com_imdb.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.swiggy_com_imdb.domain.usecase.GetTitleDetails
import com.devrachit.swiggy_com_imdb.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewmodel @Inject constructor(
    private val repository: GetTitleDetails
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState : StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun getTitleDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.invoke(id).collectLatest { response ->
                when (response) {
                    is Resource.Success -> {
                        _uiState.update{
                            _uiState.value.copy(title = response.data)
                        }
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {

                    }
                }
            }
        }
    }
}