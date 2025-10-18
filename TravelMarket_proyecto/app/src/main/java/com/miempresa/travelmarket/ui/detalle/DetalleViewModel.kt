package com.miempresa.travelmarket.ui.detalle

import androidx.lifecycle.ViewModel
import com.miempresa.travelmarket.data.Repository

class DetalleViewModel : ViewModel() {
    fun getItem(id: String?): Any? {
        // Ahora usamos la nueva función unificada y sin ambigüedades del repositorio
        return Repository.getItem(id)
    }
}
