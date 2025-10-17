package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.R

data class Transporte(
    val nombre: String,
    val tipo: String,
    val descripcionCorta: String,
    val descripcionLarga: String,
    val ubicacion: String,
    val ruta: String,
    val distancia: String,
    val imageRes: Int?
)

fun getTransporte(): List<Transporte> {
    return listOf(
        Transporte(
            nombre = "Paradero Av. Arequipa",
            tipo = "Paradero",
            descripcionCorta = "Múltiples líneas disponibles",
            descripcionLarga = "Paradero principal con conexiones a múltiples distritos a través de una de las avenidas más importantes de Lima.",
            ubicacion = "Av. Arequipa con Av. Angamos",
            ruta = "Múltiples líneas disponibles",
            distancia = "300 m",
            imageRes = null
        ),
        Transporte(
            nombre = "Metro de Lima - Línea 1",
            tipo = "Metro",
            descripcionCorta = "Tren rápido sur-este",
            descripcionLarga = "Sistema de transporte rápido que conecta el sur con el este de Lima. Económico y eficiente para llegar a las sedes.",
            ubicacion = "Red Metro de Lima",
            ruta = "Villa El Salvador - San Juan de Lurigancho",
            distancia = "800 m",
            imageRes = null
        ),
        Transporte(
            nombre = "Metropolitano",
            tipo = "Bus rápido",
            descripcionCorta = "Bus rápido norte-sur",
            descripcionLarga = "Corredor de buses de alta capacidad que recorre la ciudad de norte a sur, con estaciones exclusivas.",
            ubicacion = "Vía Expresa de Paseo de la República",
            ruta = "Naranjal - Matellini",
            distancia = "450 m",
            imageRes = null
        ),
        Transporte(
            nombre = "Estación Central",
            tipo = "Estación",
            descripcionCorta = "Estación principal de trenes",
            descripcionLarga = "Punto neurálgico del sistema de transporte, conecta el Metropolitano con otras líneas de buses y servicios.",
            ubicacion = "Paseo de los Héroes Navales",
            ruta = "Conexión Metropolitano",
            distancia = "1.2 km",
            imageRes = null
        )
    )
}
