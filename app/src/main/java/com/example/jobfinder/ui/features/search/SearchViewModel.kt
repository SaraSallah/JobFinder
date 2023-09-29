package com.example.jobfinder.ui.features.search

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.SearchJobUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import com.example.jobfinder.ui.features.home.HomeUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchJobUseCase: SearchJobUseCase,
) : BaseViewModel<SearchUiState, SearchUiEffect>(SearchUiState()),SearchInteractionListener {
    override val TAG: String = this::class.simpleName.toString()
    private val actionStream = MutableSharedFlow<String>()

    init {
        observeKeyword()

    }

    fun searchForJob() {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val jobs  =searchJobUseCase(_state.value.query)
            _state.update { it.copy(jobs =jobs.toSearchForJobUiState() , isLoading = false )  }
        }
        log(_state.value.jobs.toString())
    }

     override fun onSearchTextChange(text : String ){
        _state.update { it.copy(isLoading = true , query = text) }
        viewModelScope.launch{actionStream.emit(text)}
//         searchForJob()

     }
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(FlowPreview::class)
    private fun observeKeyword() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            actionStream.debounce(700).distinctUntilChanged().filter { keyword ->
                keyword.isNotBlank()
            }.collect { searchForJob() }
        }
    }
    override fun onClickJobJob(jobId : Int) {
        effectActionExecutor(_effect ,SearchUiEffect.NavigateToJobDetailsScreen(jobId = jobId))

    }




}