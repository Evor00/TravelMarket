package com.miempresa.travelmarket.ui.home

import androidx.lifecycle.ViewModel
import com.miempresa.travelmarket.data.Repository
import com.miempresa.travelmarket.model.Evento
import com.miempresa.travelmarket.model.Lugar
import com.miempresa.travelmarket.model.Servicio

class HomeViewModel : ViewModel() {
    val lugares: List<Lugar> = Repository.getLugares()
    val eventos: List<Evento> = Repository.getEventos()
    val servicios: List<Servicio> = Repository.getServicios()
}