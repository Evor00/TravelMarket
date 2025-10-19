package com.miempresa.travelmarket.data

import com.miempresa.travelmarket.R

data class Restaurante(
    val nombre: String,
    val tipo: String,
    val descripcionCorta: String,
    val descripcionLarga: String,
    val distancia: String,
    val imageRes: Int?
)

fun getGastronomia(): List<Restaurante> {
    return listOf(
        Restaurante(
            "Mercado de Surquillo",
            "Mercado tradicional",
            "Ceviche fresco y comida...",
            "Mercado tradicional donde podrás probar ceviche fresco, anticuchos y otros platos típicos peruanos.",
            "1.8 km",
            null
        ),
        Restaurante(
            "La Mar Cebichería",
            "Restaurante peruano",
            "Alta cocina marina peruana",
            "Reconocida cebichería que ofrece una innovadora carta con los mejores productos del mar peruano.",
            "2.1 km",
            null
        ),
        Restaurante(
            "Taquería Los Compadres",
            "Restaurante mexicano",
            "Tacos y comida mexicana...",
            "Auténtica taquería con una gran variedad de tacos al pastor, suadero y más, en un ambiente relajado.",
            "3.4 km",
            null
        ),
        Restaurante(
            "Osaka Fusión Nikkei",
            "Restaurante fusión",
            "Fusión japonesa-peruana",
            "Experiencia culinaria de alto nivel que combina la precisión de la técnica japonesa con los sabores peruanos.",
            "4.7 km",
            null
        )
    )
}
