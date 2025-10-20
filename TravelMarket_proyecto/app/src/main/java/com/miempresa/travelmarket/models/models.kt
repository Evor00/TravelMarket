package com.miempresa.travelmarket.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

interface Searchable {
    fun doesMatchSearchQuery(query: String): Boolean
}

open class Destino(
    open val id: String,
    open val nombre: String,
    open val descripcion: String,
    @DrawableRes open val imageRes: Int,
    open val type: String
) : Searchable {
    override fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            nombre,
            descripcion
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

data class Lugar(
    override val id: String,
    override val nombre: String,
    override val descripcion: String,
    @DrawableRes override val imageRes: Int,
) : Destino(id, nombre, descripcion, imageRes, "Lugar")

data class Evento(
    override val id: String,
    override val nombre: String,
    override val descripcion: String,
    @DrawableRes override val imageRes: Int,
    val fecha: String
) : Destino(id, nombre, descripcion, imageRes, "Evento")

data class Servicio(
    override val id: String,
    override val nombre: String,
    override val descripcion: String,
    @DrawableRes override val imageRes: Int,
) : Destino(id, nombre, descripcion, imageRes, "Servicio")

data class Gastronomia(
    override val id: String,
    override val nombre: String,
    override val descripcion: String,
    @DrawableRes override val imageRes: Int,
    val tipo: String
) : Destino(id, nombre, descripcion, imageRes, "Gastronomia")

data class Transporte(
    override val id: String,
    override val nombre: String,
    override val descripcion: String,
    @DrawableRes override val imageRes: Int,
    val tipo: String,
) : Destino(id, nombre, descripcion, imageRes, "Transporte")

data class DestinoNav(
    val nombre: String,
    @DrawableRes val imageRes: Int,
    val color: Color,
    val route: String
)
