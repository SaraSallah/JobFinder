package com.example.jobfinder.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.xml.sax.ErrorHandler

abstract class BaseViewModel<T, E>(initialState: T) : ViewModel() {
    abstract val TAG: String

    protected open fun log(message: String) {
        Log.e(TAG, message)
    }

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<E>()
    val effect = _effect.asSharedFlow()

    private var job: Job? = null

    protected fun <T : BaseUiEffect> effectActionExecutor(
        _effect: MutableSharedFlow<T>,
        effect: T,
    ) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }

    protected fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (t: ErrorHandler) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ) {
        viewModelScope.launch(dispatcher) {
            handleException(
                onError
            ) {
                val result = function()
                log("tryToExecute: $result ")
                onSuccess(result)
            }
        }
    }

    private suspend fun <T> handleException(
        onError: (t: ErrorHandler) -> Unit,
        action: suspend () -> T,
    ) {
        try {
            action()
        } catch (exception: Exception) {
            log("tryToExecute error: $exception")
            when (exception) {


            }
        }
    }


}