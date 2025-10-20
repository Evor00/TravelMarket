package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.models.Destino
import kotlinx.coroutines.flow.MutableStateFlow

object FavoritesManager {
    val favorites = MutableStateFlow<List<Destino>>(emptyList())

    fun addFavorite(destino: Destino) {
        if (!favorites.value.contains(destino)) {
            favorites.value = favorites.value + destino
        }
    }

    fun removeFavorite(destino: Destino) {
        favorites.value = favorites.value - destino
    }

    fun isFavorite(destino: Destino): Boolean {
        return favorites.value.contains(destino)
    }
}