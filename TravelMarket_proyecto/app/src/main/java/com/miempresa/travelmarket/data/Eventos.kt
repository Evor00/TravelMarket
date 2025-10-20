package com.miempresa.travelmarket.data

data class Evento(
    val nombre: String,
    val descripcion: String,val fecha: String,
    val hora: String,
    val distancia: String,
    val imageRes: Int?
)

fun getEventos(): List<Evento> {
    return listOf(
        Evento(
            "Ceremonia de Apertura",
            "Gran ceremonia inaugural de los Juegos Panamericanos con espectáculo de luces, música y cultura latinoamericana.",
            "26 de Julio, 2025",
            "19:00 hrs",
            "6.1 km",
            null
        ),
        Evento(
            "Natación - Competencias",
            "Competencias de natación olímpica en diversas categorías.",
            "2 de Agosto, 2025",
            "09:00 hrs",
            "5.3 km",
            null
        ),
        Evento(
            "Voleibol de Playa",
            "Torneo de voleibol playa en la Costa Verde.",
            "5 de Agosto, 2025",
            "15:00 hrs",
            "8.9 km",
            null
        ),
        Evento(
            "Final Baloncesto Masculino",
            "Emocionante final del torneo de baloncesto masculino por la medalla de oro.",
            "10 de Agosto, 2025",
            "20:00 hrs",
            "3.2 km",
            null
        )
    )
}
