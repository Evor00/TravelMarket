package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.R

data class Lugar(
    val nombre: String,
    val descripcion: String,
    val descripcionLarga: String,
    val distancia: String,
    val imageRes: Int?
)

fun getLugares(): List<Lugar> {
    return listOf(
        Lugar(
            "Playa Miraflores",
            "Playa urbana con vista al océano",
            "Hermosa playa urbana con vista al océano Pacífico. Ideal para disfrutar del atardecer y practicar surf.",
            "2.3 km de tu ubicación",
            null
        ),
        Lugar(
            "Centro Histórico de Lima",
            "Patrimonio UNESCO con arquitectura colonial",
            "Patrimonio de la Humanidad por la UNESCO, con impresionante arquitectura colonial y balcones.",
            "5.8 km de tu ubicación",
            null
        ),
        Lugar(
            "Museo de Arte de Lima",
            "3000 años de arte peruano",
            "Explora 3000 años de arte peruano, desde la época precolombina hasta la actualidad.",
            "3.5 km de tu ubicación",
            null
        ),
        Lugar(
            "Parque de las Aguas",
            "Circuito de fuentes interactivas",
            "Famoso por su Circuito Mágico del Agua, un espectáculo nocturno de luces y sonido.",
            "4.2 km de tu ubicación",
            null
        )
    )
}
