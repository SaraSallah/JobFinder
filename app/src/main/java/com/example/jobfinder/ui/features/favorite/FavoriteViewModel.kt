package com.example.jobfinder.ui.features.favorite

import com.example.jobfinder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor() : BaseViewModel<FavoriteUiState, FavoriteUiEffect>(
    FavoriteUiState()
) {
    override val TAG: String =this ::class.simpleName.toString()
}