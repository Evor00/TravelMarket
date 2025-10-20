package com.miempresa.travelmarket.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miempresa.travelmarket.data.Repository
import com.miempresa.travelmarket.models.Destino
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class HomeViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _destinos = MutableStateFlow(Repository.lugares + Repository.eventos + Repository.gastronomia + Repository.transporte)

    val searchResults = searchText
        .combine(_destinos) { text, destinos ->
            if (text.isBlank()) {
                emptyList()
            } else {
                destinos.filter {
                    it.nombre.contains(text, ignoreCase = true) || it.descripcion.contains(text, ignoreCase = true)
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList<Destino>()
        )

    fun onSearchTextChanged(text: String) {
        _searchText.value = text
    }
}
