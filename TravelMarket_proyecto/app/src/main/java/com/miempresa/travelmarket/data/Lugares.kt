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
            "Plaza de Armas de Arequipa",
            "El corazón de la ciudad blanca",
            "La Plaza de Armas es el corazón de Arequipa, rodeada de portales de granito y la imponente Catedral. Un lugar perfecto para empezar a explorar la ciudad.",
            "1.2 km de tu ubicación",
            R.drawable.lugares
        ),
        Lugar(
            "Monasterio de Santa Catalina",
            "Una ciudad dentro de una ciudad",
            "Este convento es una joya arquitectónica con calles de colores vibrantes, patios y claustros. Un viaje en el tiempo a la época colonial.",
            "1.5 km de tu ubicación",
            R.drawable.lugares
        ),
        Lugar(
            "Mirador de Yanahuara",
            "Vistas panorámicas del Misti",
            "Ofrece vistas espectaculares de la ciudad y los volcanes Misti, Chachani y Pichu Pichu. Sus arcos de sillar son icónicos.",
            "2.8 km de tu ubicación",
            R.drawable.lugares
        ),
        Lugar(
            "Cañón del Colca",
            "Uno de los cañones más profundos",
            "A unas horas de Arequipa, es ideal para el trekking y el avistamiento del cóndor andino. Un paisaje natural impresionante.",
            "160 km de tu ubicación",
            R.drawable.lugares
        )
    )
}
