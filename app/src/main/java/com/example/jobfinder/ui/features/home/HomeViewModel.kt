package com.example.jobfinder.ui.features.home

import com.example.jobfinder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()) {
    override val TAG: String =this ::class.simpleName.toString()
}
