package com.example.jobfinder.ui.features.profile

import com.example.jobfinder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel<ProfileUiState, ProfileUiEffect>(
    ProfileUiState()
) {
    override val TAG: String = this::class.simpleName.toString()
}