package com.example.features.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.features.ui.theme.FeaturesTheme

@Composable
fun TextInputScreen() {
    var text = remember { mutableStateOf("") }
    var submittedText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column {
            TextField(
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text("Enter your text here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("textInputField")  // testing
            )
            Button(
                onClick = {
                    submittedText.value = text.value
                    text.value = ""
                },
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text("Submit")
            }
            if (submittedText.value.isNotEmpty()) {
                Text(submittedText.value)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextInputScreenPreview() {
    FeaturesTheme {
        TextInputScreen()
    }
}