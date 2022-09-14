package com.sudansh.planetm.presentation.screens.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sudansh.planetm.R
import com.sudansh.planetm.data.AlbumRepository
import com.sudansh.planetm.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {

    private val isLoading = MutableStateFlow(true)
    private val errorState = MutableStateFlow(false)
    private val albums = repository.observeAlbums()

    val state = combine(isLoading, errorState, albums) { loading, error, albums ->
        when {
            loading && albums.isEmpty() -> UiState.Loading
            error && albums.isEmpty() -> UiState.Error(R.string.something_went_wrong)
            else -> UiState.Success(albums)
        }
    }

    fun refreshData() {
        viewModelScope.launch {
            try {
                repository.refreshAlbums()
            } catch (e: Exception) {
                errorState.emit(true)
            } finally {
                isLoading.emit(false)
            }
        }
    }
}