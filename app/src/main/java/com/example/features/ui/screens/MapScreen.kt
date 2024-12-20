package com.example.features.ui.screens

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen() {
    // Request location permission
    val locationPermissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    // If the permission is granted, show the GoogleMap composable
    if (locationPermissionState.status.isGranted) {
        // Camera position state for the map
        val cameraPositionState = rememberCameraPositionState()

        // Render the GoogleMap composable with the camera state
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(isMyLocationEnabled = true)
        )
    } else {
        // If permission is not granted, show a message or request button
        Column(modifier = Modifier.fillMaxSize()) {
            Text("This app requires location permission to show your current location on the map.")
            Button(onClick = { locationPermissionState.launchPermissionRequest() }) {
                Text("Grant Location Permission")
            }
        }
    }
}