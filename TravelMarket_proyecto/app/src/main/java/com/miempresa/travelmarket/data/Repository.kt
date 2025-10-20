package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.R
import com.miempresa.travelmarket.models.Destino
import com.miempresa.travelmarket.models.Evento
import com.miempresa.travelmarket.models.Gastronomia
import com.miempresa.travelmarket.models.Lugar
import com.miempresa.travelmarket.models.Transporte

object Repository {
    val lugares = listOf(
        Lugar("l1", "Plaza de Armas", "La Plaza de Armas es el corazón de Arequipa.", R.drawable.plazadearmas),
        Lugar("l2", "Monasterio de Santa Catalina", "Un complejo religioso y turístico de gran importancia.", R.drawable.catalina),
        Lugar("l3", "Mirador de Yanahuara", "Ofrece una vista panorámica de la ciudad y el volcán Misti.", R.drawable.mirador),
        Lugar("l4", "Cañón del Colca","Es uno de los cañones más profundos del mundo y hogar del majestuoso cóndor andino.",R.drawable.colca)
    )

    val eventos = listOf(
        Evento("e1", "Festival de la Cerveza", "Celebración anual con las mejores cervezas artesanales.", R.drawable.cerveza, "20-22 Oct"),
        Evento("e2", "Aniversario de Arequipa", "Fiestas y eventos por toda la ciudad.", R.drawable.aniversario, "15 Ago"),
        Evento("e3", "Festival Gastronómico", "Los mejores platos de la región en un solo lugar.", R.drawable.festival, "5-7 Nov"),
        Evento("e4","Ceremonia de Apertura","Gran ceremonia inaugural de los Juegos Panamericanos con espectáculo de luces, música y cultura latinoamericana.",R.drawable.ceremonia,"26 Jul"),
        Evento("e5","Natación - Competencias","Competencias de natación olímpica en diversas categorías.",R.drawable.natacion,"2 Ago"),
        Evento("e6","Final Baloncesto Masculino","Emocionante final del torneo de baloncesto masculino por la medalla de oro.",R.drawable.baloncesto,"10 Ago")
    )

    val gastronomia = listOf(
        Gastronomia("g1", "Restaurante La Nueva Palomino", "Picantería tradicional arequipeña.", R.drawable.lanuevapalomino, "Picantería"),
        Gastronomia("g2", "Chicha por Gastón Acurio", "Cocina peruana de autor.", R.drawable.chica, "Gourmet"),
        Gastronomia("g3", "Zig Zag Restaurant", "Especialidades en carnes a la piedra volcánica.", R.drawable.zigzag, "Internacional"),
        Gastronomia("g4","Sol de Mayo","Es famoso por su comida tradicional arequipeña y su ambiente típico con música y danzas locales.",R.drawable.soldemayo,"Tradicional")
    )

    val transporte = listOf(
        Transporte("t1", "Línea 1 del Bus Turístico", "Recorrido por los principales atractivos de la ciudad.", R.drawable.bus, "Bus Turístico"),
        Transporte("t2", "Taxis Arequipa", "Servicio de taxi seguro y confiable.", R.drawable.taxis, "Taxi"),
        Transporte("t3", "Alquiler de Scooters Eléctricos", "Movilidad sostenible para explorar el centro histórico.", R.drawable.scooter, "Scooter")
    )


    fun getItem(id: String?): Destino? {
        if (id == null) return null
        return lugares.find { it.id == id } 
            ?: eventos.find { it.id == id } 
            ?: gastronomia.find { it.id == id } 
            ?: transporte.find { it.id == id }
    }
}
