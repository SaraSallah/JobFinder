package com.example.jobfinder.ui.features.home

import com.example.jobfinder.ui.base.BaseUiEffect

interface HomeUiEffect :BaseUiEffect {
    object NavigateToCategoryScreenEffect : HomeUiEffect
    object NavigateToSearchScreenEffect : HomeUiEffect

}