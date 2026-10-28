package com.example.moodtracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moodtracker.core.*

@Composable
fun MoodTrackerScreen() {
    var selectedMood by remember { mutableStateOf<Mood?>(null) }
    var displayedScore by remember { mutableStateOf<String?>(null) }
    var displayedMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Mood Tracker",
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Mood Selection Row
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Mood:", fontSize = 18.sp)

            Mood.entries.forEach { mood ->
                FilterChip(
                    selected = selectedMood == mood,
                    onClick = { selectedMood = mood },
                    label = { Text(getMoodEmoji(mood), fontSize = 20.sp) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Save / Show Button
        Button(
            onClick = {
                selectedMood?.let { mood ->
                    displayedScore = formatScore(score(mood))
                    displayedMessage = message(mood)
                }
            },
            enabled = selectedMood != null
        ) {
            Text("Save/Show")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Result Output Area
        displayedScore?.let { scoreText ->
            Text(
                text = scoreText,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        displayedMessage?.let { msgText ->
            Text(
                text = "Message: $msgText",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}