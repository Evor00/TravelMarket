package com.miempresa.travelmarket.ui.detalle

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miempresa.travelmarket.model.Evento
import com.miempresa.travelmarket.model.Lugar
import com.miempresa.travelmarket.model.Servicio

@Composable
fun DetalleScreen(id: String?, detailViewModel: DetalleViewModel = viewModel()) {
    val item = detailViewModel.getItem(id)

    if (item != null) {
        val (nombre, descripcion, imageRes) = when (item) {
            is Lugar -> Triple(item.nombre, item.descripcion, item.imageRes)
            is Evento -> Triple(item.nombre, item.descripcion, item.imageRes)
            is Servicio -> Triple(item.nombre, item.descripcion, item.imageRes)
            else -> throw IllegalArgumentException("Unknown item type")
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = nombre,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = nombre, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = descripcion, style = MaterialTheme.typography.bodyMedium)
        }
    } else {
        Text("Elemento no encontrado")
    }
}
