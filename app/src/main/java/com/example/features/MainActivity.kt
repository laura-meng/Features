package com.example.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.features.ui.components.NavigationRailWithNavHost
import com.example.features.ui.theme.FeaturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatureApp()
        }
    }
}

@Composable
fun FeatureApp(modifier: Modifier = Modifier) {
    FeaturesTheme {
        Surface(modifier = modifier.fillMaxHeight(), color = MaterialTheme.colorScheme.background) {
            NavigationRailWithNavHost()
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun PreviewNavigationRail() {
    FeaturesTheme {
        NavigationRailWithNavHost()
    }
}