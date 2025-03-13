package com.example.electricstungun.utils

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.*
import com.example.electricstungun.R


class SoundManager(context: Context) {
    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.electricity_sound)

    fun startSound() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.isLooping = true
            mediaPlayer.start()
        }
    }

    fun stopSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPlayer.seekTo(0)
        }
    }

    fun release() {
        mediaPlayer.release()
    }
}

@Composable
fun rememberSoundManager(context: Context): SoundManager {
    return remember { SoundManager(context) }
}
