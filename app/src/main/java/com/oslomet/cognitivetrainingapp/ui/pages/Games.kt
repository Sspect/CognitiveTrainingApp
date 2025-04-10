package com.oslomet.cognitivetrainingapp.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GamesPage(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp), // optional padding for sides
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 80.dp // adjust based on height of bottom bar
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { GameCategoryBox(title = "Math") }
        item { GameCategoryBox(title = "Attention") }
        item { GameCategoryBox(title = "Language") }
        item { GameCategoryBox(title = "Language") }
        item { GameCategoryBox(title = "Language") }
        item { GameCategoryBox(title = "Language") }
    }
}






@Composable
fun GameCategoryBox(title: String) {
    val games = listOf("Game 1", "Game 2", "Game 3", "Game 4", "Game 5", "Game 6") // Replace with real data later

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {
                items(games) { gameName ->
                    GameSquare(name = gameName)
                }
            }
        }
    }
}

@Composable
fun GameSquare(name: String) {
    Surface(
        modifier = Modifier
            .size(80.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.small,
        shadowElevation = 2.dp
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(text = name, fontSize = 12.sp)
        }
    }
}