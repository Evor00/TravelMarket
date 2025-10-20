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
            "La Nueva Palomino",
            "Picantería",
            "Tradición y sabor arequipeño.",
            "Una de las picanterías más emblemáticas de Arequipa, famosa por su adobo, rocoto relleno y chicha de jora.",
            "1.5 km",
            R.drawable.lanuevapalomino
        ),
        Restaurante(
            "Sol de Mayo",
            "Restaurante tradicional",
            "Comida arequipeña con música en vivo.",
            "Ofrece una experiencia completa con platos típicos, un amplio patio colonial y espectáculos de música arequipeña.",
            "2.0 km",
            R.drawable.soldemayo
        ),
        Restaurante(
            "Zig Zag",
            "Restaurante fusión",
            "Carnes a la piedra volcánica.",
            "Cocina alpaca y trucha en piedras volcánicas calientes. Una fusión de sabores andinos y técnica europea.",
            "1.2 km",
            R.drawable.zigzag
        ),
        Restaurante(
            "Chicha por Gastón Acurio",
            "Restaurante gourmet",
            "Alta cocina regional.",
            "La propuesta de Gastón Acurio que reinterpreta los platos clásicos de la cocina arequipeña con un toque moderno y sofisticado.",
            "1.0 km",
            R.drawable.chica
        )
    )
}
