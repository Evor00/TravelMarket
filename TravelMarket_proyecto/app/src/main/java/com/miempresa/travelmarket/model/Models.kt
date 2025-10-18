package com.miempresa.travelmarket.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Lugar(
    val id: String,
    val nombre: String,
    val descripcion: String,
    @DrawableRes val imageRes: Int
)

data class Evento(
    val id: String,
    val nombre: String,
    val descripcion: String,
    @DrawableRes val imageRes: Int,
    val fecha: String
)

data class Servicio(
    val id: String,
    val nombre: String,
    val descripcion: String,
    @DrawableRes val imageRes: Int
)

data class Destino(
    val nombre: String,
    val imageRes: Int,
    val color: Color,
    val route: String
)
