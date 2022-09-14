package com.sudansh.planetm.presentation

import androidx.annotation.StringRes

sealed interface UiState<out T> {
    object Loading : UiState<Nothing>
    class Success<T>(val data: T) : UiState<T>
    class Error(@StringRes val message: Int) : UiState<Nothing>
}