package com.sudansh.planetm.presentation.screens.albumdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sudansh.planetm.R
import com.sudansh.planetm.data.AlbumRepository
import com.sudansh.planetm.domain.model.Album
import com.sudansh.planetm.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<Album>>(UiState.Loading)
    val state = _state.asStateFlow()

    fun getAlbumDetail(albumId: String?) {
        _state.value = UiState.Loading
        if (albumId == null) {
            onError()
        } else {
            loadAlbum(albumId)
        }
    }

    private fun loadAlbum(albumId: String) {
        viewModelScope.launch {
            val album = repository.findAlbum(albumId)
            if (album != null) {
                _state.value = UiState.Success(album)
            } else {
                onError()
            }
        }
    }

    private fun onError() {
        _state.value = UiState.Error(R.string.invalid_album_id)
    }
}