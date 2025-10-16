package com.miempresa.travelmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.miempresa.travelmarket.navigation.AppNavigation
import com.miempresa.travelmarket.ui.theme.TravelMarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelMarketTheme {
                AppNavigation()
            }
        }
    }
}
