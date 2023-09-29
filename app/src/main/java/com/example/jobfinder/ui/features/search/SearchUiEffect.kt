package com.example.jobfinder.ui.features.search

import com.example.jobfinder.ui.base.BaseUiEffect

interface SearchUiEffect : BaseUiEffect {
    data class NavigateToJobDetailsScreen (val jobId  : Int) :SearchUiEffect
}