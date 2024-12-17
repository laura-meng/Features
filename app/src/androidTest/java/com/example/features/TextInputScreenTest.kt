package com.example.features

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.features.ui.screens.TextInputScreen
import com.example.features.ui.theme.FeaturesTheme
import org.junit.Rule
import org.junit.Test

class TextInputScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTextInputDisplayed() {
        composeTestRule.setContent {
            FeaturesTheme {
                TextInputScreen()
            }
        }

        val textField = composeTestRule.onNodeWithTag("textInputField")
        textField.performTextInput("Hello friends!")

        textField.assert(hasText("Hello friends!"))

        val submitButton = composeTestRule.onNodeWithText("Submit")
        submitButton.performClick()

        // 4. Verify the submitted text appears and the text field is cleared
        composeTestRule.onNodeWithText("Hello friends!").assertIsDisplayed()
        textField.assert(hasText("")) // Verify TextField is cleared after submit
    }


}