package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.R
import com.miempresa.travelmarket.models.Destino
import com.miempresa.travelmarket.models.Evento
import com.miempresa.travelmarket.models.Lugar
import com.miempresa.travelmarket.models.Servicio
import com.miempresa.travelmarket.models.Gastronomia
import com.miempresa.travelmarket.models.Transporte

object Repository {
    val lugares = listOf(
        Lugar("l1", "Plaza de Armas", "La Plaza de Armas es el corazón de Arequipa.", R.drawable.lugares),
        Lugar("l2", "Monasterio de Santa Catalina", "Un complejo religioso y turístico de gran importancia.", R.drawable.lugares),
        Lugar("l3", "Mirador de Yanahuara", "Ofrece una vista panorámica de la ciudad y el volcán Misti.", R.drawable.lugares)
    )

    val eventos = listOf(
        Evento("e1", "Festival de la Cerveza", "Celebración anual con las mejores cervezas artesanales.", R.drawable.eventos, "20-22 Oct"),
        Evento("e2", "Aniversario de Arequipa", "Fiestas y eventos por toda la ciudad.", R.drawable.eventos, "15 Ago"),
        Evento("e3", "Festival Gastronómico", "Los mejores platos de la región en un solo lugar.", R.drawable.eventos, "5-7 Nov")
    )

    val gastronomia = listOf(
        Gastronomia("g1", "Restaurante La Nueva Palomino", "Picantería tradicional arequipeña.", R.drawable.gastronomia, "Picantería"),
        Gastronomia("g2", "Chicha por Gastón Acurio", "Cocina peruana de autor.", R.drawable.gastronomia, "Gourmet"),
        Gastronomia("g3", "Zig Zag Restaurant", "Especialidades en carnes a la piedra volcánica.", R.drawable.gastronomia, "Internacional")
    )

    val transporte = listOf(
        Transporte("t1", "Línea 1 del Bus Turístico", "Recorrido por los principales atractivos de la ciudad.", R.drawable.transporte, "Bus Turístico"),
        Transporte("t2", "Taxis Arequipa", "Servicio de taxi seguro y confiable.", R.drawable.transporte, "Taxi"),
        Transporte("t3", "Alquiler de Scooters Eléctricos", "Movilidad sostenible para explorar el centro histórico.", R.drawable.transporte, "Scooter")
    )

    fun getLugar(id: String?): Lugar? = lugares.find { it.id == id }
    fun getEvento(id: String?): Evento? = eventos.find { it.id == id }
    fun getGastronomia(id: String?): Gastronomia? = gastronomia.find { it.id == id }
    fun getTransporte(id: String?): Transporte? = transporte.find { it.id == id }


    // Nueva función para obtener cualquier item por su ID único
    fun getItem(id: String?): Destino? {
        if (id == null) return null
        return lugares.find { it.id == id } 
            ?: eventos.find { it.id == id } 
            ?: gastronomia.find { it.id == id } 
            ?: transporte.find { it.id == id }
    }
}
