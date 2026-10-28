package com.example.moodtracker.core

enum class Mood { HAPPY, NEUTRAL, SAD }

// 1. Calculates numerical score based on selected mood
fun score(mood: Mood): Int = when (mood) {
    Mood.HAPPY -> 2
    Mood.NEUTRAL -> 1
    Mood.SAD -> 0
}

// 2. Returns motivational message based on mood
fun message(mood: Mood): String = when (mood) {
    Mood.HAPPY -> "Great! Keep your energy up."
    Mood.NEUTRAL -> "Keep your spirits up! A short break might help."
    Mood.SAD -> "Take care of yourself. Breathe deeply and rest."
}

// 3. Formats score output for UI display
fun formatScore(score: Int, maxScore: Int = 2): String {
    return "Score: $score/$maxScore"
}

// 4. Returns representative emoji icon for each mood enum
fun getMoodEmoji(mood: Mood): String = when (mood) {
    Mood.HAPPY -> "🙂"
    Mood.NEUTRAL -> "😐"
    Mood.SAD -> "🙁"
}