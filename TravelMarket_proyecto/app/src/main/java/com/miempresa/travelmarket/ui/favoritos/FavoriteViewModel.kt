package com.miempresa.travelmarket.ui.favoritos

import androidx.lifecycle.ViewModel
import com.miempresa.travelmarket.data.FavoritesManager
import com.miempresa.travelmarket.models.Destino
import kotlinx.coroutines.flow.asStateFlow

class FavoriteViewModel : ViewModel() {
    val favorites = FavoritesManager.favorites.asStateFlow()

}