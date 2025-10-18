package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.R
import com.miempresa.travelmarket.model.Evento
import com.miempresa.travelmarket.model.Lugar
import com.miempresa.travelmarket.model.Servicio

object Repository {
    private val lugares = listOf(
        Lugar("l1", "Plaza de Armas", "La Plaza de Armas es el corazón de Arequipa.", R.drawable.lugares),
        Lugar("l2", "Monasterio de Santa Catalina", "Un complejo religioso y turístico de gran importancia.", R.drawable.eventos),
        Lugar("l3", "Mirador de Yanahuara", "Ofrece una vista panorámica de la ciudad y el volcán Misti.", R.drawable.gastronomia)
    )

    private val eventos = listOf(
        Evento("e1", "Festival de la Cerveza", "Celebración anual con las mejores cervezas artesanales.", R.drawable.eventos, "20-22 Oct"),
        Evento("e2", "Aniversario de Arequipa", "Fiestas y eventos por toda la ciudad.", R.drawable.lugares, "15 Ago"),
        Evento("e3", "Festival Gastronómico", "Los mejores platos de la región en un solo lugar.", R.drawable.gastronomia, "5-7 Nov")
    )

    private val servicios = listOf(
        Servicio("s1", "Restaurante La Nueva Palomino", "Picantería tradicional arequipeña.", R.drawable.gastronomia),
        Servicio("s2", "Hotel Casa Andina", "Alojamiento de primera categoría en el centro histórico.", R.drawable.lugares),
        Servicio("s3", "Tour al Cañón del Colca", "Excursiones de uno o dos días al famoso cañón.", R.drawable.eventos)
    )

    fun getLugares(): List<Lugar> = lugares
    fun getEventos(): List<Evento> = eventos
    fun getServicios(): List<Servicio> = servicios

    fun getLugar(id: String?): Lugar? = lugares.find { it.id == id }
    fun getEvento(id: String?): Evento? = eventos.find { it.id == id }
    fun getServicio(id: String?): Servicio? = servicios.find { it.id == id }

    // Nueva función para obtener cualquier item por su ID único
    fun getItem(id: String?): Any? {
        if (id == null) return null
        return when {
            id.startsWith("l") -> getLugar(id)
            id.startsWith("e") -> getEvento(id)
            id.startsWith("s") -> getServicio(id)
            else -> null
        }
    }
}
