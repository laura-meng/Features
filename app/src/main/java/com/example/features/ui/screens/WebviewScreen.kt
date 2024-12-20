package com.example.features.ui.screens

import androidx.compose.runtime.Composable
import com.kevinnzou.web.WebView
import com.kevinnzou.web.rememberWebViewState

@Composable
fun WebviewScreen() {
    val state = rememberWebViewState("https://saucelabs.com")

    WebView(
        state = state
    )
}
