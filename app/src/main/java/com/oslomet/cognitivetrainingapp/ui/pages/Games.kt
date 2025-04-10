package com.oslomet.cognitivetrainingapp.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GamesPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(0.dp)
    ) {
        /* Attention games */
        Column(modifier = modifier.padding(10.dp)) {
            Text(text = "Attention games")
        }
        Spacer(modifier.padding(10.dp))

        /* Language games */
        /* Math games */
        /* Memory games */


    }
}