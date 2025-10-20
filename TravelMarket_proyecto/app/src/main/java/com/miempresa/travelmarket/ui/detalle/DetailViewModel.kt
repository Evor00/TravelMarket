
package com.miempresa.travelmarket.ui.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miempresa.travelmarket.data.FavoritesManager
import com.miempresa.travelmarket.data.Repository
import com.miempresa.travelmarket.models.Destino
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _destino = MutableStateFlow<Destino?>(null)
    val destino = _destino.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite = _isFavorite.asStateFlow()

    fun loadData(id: String) {
        viewModelScope.launch {
            val loadedDestino = Repository.getItem(id)
            _destino.value = loadedDestino
            if (loadedDestino != null) {
                _isFavorite.value = FavoritesManager.isFavorite(loadedDestino)
            }
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            _destino.value?.let { currentDestino ->
                if (FavoritesManager.isFavorite(currentDestino)) {
                    FavoritesManager.removeFavorite(currentDestino)
                    _isFavorite.value = false
                } else {
                    FavoritesManager.addFavorite(currentDestino)
                    _isFavorite.value = true
                }
            }
        }
    }
}
