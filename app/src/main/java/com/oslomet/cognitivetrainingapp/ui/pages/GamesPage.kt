package com.oslomet.cognitivetrainingapp.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.oslomet.cognitivetrainingapp.R

@Composable
fun GamesPage(modifier: Modifier = Modifier) {
    val categoriesWithGames = mapOf(
        "Math" to listOf(
            Game("Order the numbers", R.drawable.game_card_math_game1_light, R.drawable.game_card_math_game1_dark),
            Game("TEMP"),
            Game("TEMP"),
            Game("TEMP"),
        ),
        "Attention" to listOf(
            Game("Focus Match"),
            Game("TEMP"),
            Game("TEMP"),
            Game("TEMP"),
        ),
        "Language" to listOf(
            Game("Word Builder"),
            Game("TEMP"),
            Game("TEMP"),
            Game("TEMP"),
        ),
        "Problem Solving" to listOf(
            Game("TEMP"),
            Game("TEMP"),
            Game("TEMP"),

        ),
        "Reaction" to listOf(
            Game("TEMP"),
            Game("TEMP"),
            Game("TEMP"),
        )
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 16.dp, bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        categoriesWithGames.forEach { (title, games) ->
            item {
                GameCategoryBox(title = title, games = games)
            }
        }
    }
}




data class Game(
    val name: String,
    val imageResLight: Int? = null,
    val imageResDark: Int? = null
)



@Composable
fun GameCategoryBox(title: String, games: List<Game>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
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
                items(games) { game ->
                    GameSquare(game = game)
                }
            }
        }
    }
}

@Composable
fun GameSquare(game: Game) {
    val isDark = isSystemInDarkTheme()

    val imageId = if (isDark) game.imageResDark else game.imageResLight

    Surface(
        modifier = Modifier
            .size(200.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.small,
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = game.name, fontSize = 12.sp)

            imageId?.let {
                Spacer(modifier = Modifier.height(4.dp))
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "${game.name} image",
                    modifier = Modifier.size(150.dp)
                )
            }
        }
    }
}
