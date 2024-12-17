package com.example.features.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*

import com.example.features.ui.screens.AlertsScreen
import com.example.features.ui.screens.ApiScreen
import com.example.features.ui.screens.MapScreen
import com.example.features.ui.screens.PayScreen
import com.example.features.ui.screens.TextInputScreen
import com.example.features.ui.screens.WebviewScreen

@Composable
fun NavigationRailWithNavHost() {
    val navController = rememberNavController()

    // Track selected item index in the navigation rail
    var selectedItem by remember { mutableStateOf(0) }

    // Define items, icons, and selected/unselected states
    val items = listOf("Text Input", "Alerts", "Pay", "Webview", "Map", "API")
    val selectedIcons = listOf(
        Icons.Filled.Edit,
        Icons.Filled.Notifications,
        Icons.Filled.ShoppingCart,
        Icons.Filled.ExitToApp,
        Icons.Filled.LocationOn,
        Icons.Filled.Share
    )
    val unselectedIcons = listOf(
        Icons.Outlined.Edit,
        Icons.Outlined.Notifications,
        Icons.Outlined.ShoppingCart,
        Icons.Outlined.ExitToApp,
        Icons.Outlined.LocationOn,
        Icons.Outlined.Share
    )

    Row(modifier = Modifier.fillMaxHeight()) {
        NavigationRail(
            modifier = Modifier.fillMaxHeight(),
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ) {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    icon = {
                        Icon(
                            if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                            contentDescription = item
                        )
                    },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        // Navigate to the appropriate screen
                        val route = when (index) {
                            0 -> "text input"
                            1 -> "alerts"
                            2 -> "pay"
                            3 -> "webview"
                            4 -> "map"
                            else -> "api"
                        }
                        navController.navigate(route)
                    }
                )
            }
        }

        // Main content area that changes based on selected route
        NavHost(navController, startDestination = "text input") {
            composable("text input") {
                TextInputScreen()
            }
            composable("alerts") {
                AlertsScreen()
            }
            composable("pay") {
                PayScreen()
            }
            composable("webview") {
                WebviewScreen()
            }
            composable("map") {
                MapScreen()
            }
            composable("api") {
                ApiScreen()
            }
        }
    }
}

