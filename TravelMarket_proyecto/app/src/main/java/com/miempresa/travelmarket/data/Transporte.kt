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
            nombre = "Sistema Integrado de Transporte (SIT)",
            tipo = "Bus",
            descripcionCorta = "Buses modernos que cubren toda la ciudad.",
            descripcionLarga = "El SIT es el sistema de transporte masivo de Arequipa, con rutas troncales y alimentadoras que conectan los principales puntos de la ciudad.",
            ubicacion = "Varias estaciones en la ciudad",
            ruta = "Rutas troncales y alimentadoras",
            distancia = "Varía",
            imageRes = R.drawable.bus
        ),
        Transporte(
            nombre = "Taxis de la Ciudad",
            tipo = "Taxi",
            descripcionCorta = "Servicio de taxi disponible 24/7.",
            descripcionLarga = "Taxis seguros y confiables que se pueden tomar en la calle o solicitar por aplicativo. Ideal para trayectos cortos y directos.",
            ubicacion = "Toda la ciudad",
            ruta = "A solicitud del pasajero",
            distancia = "Varía",
            imageRes = R.drawable.taxis
        ),
        Transporte(
            nombre = "Combies y Colectivos",
            tipo = "Minibus",
            descripcionCorta = "Transporte económico pero informal.",
            descripcionLarga = "Vehículos más pequeños que cubren rutas específicas no siempre atendidas por el SIT. Son una opción económica pero pueden ser concurridos.",
            ubicacion = "Rutas específicas por toda la ciudad",
            ruta = "Rutas fijas",
            distancia = "Varía",
            imageRes = R.drawable.combi
        )
    )
}
