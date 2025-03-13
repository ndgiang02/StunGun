package com.example.electricstungun.utils

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.*

class FlashControl(private val context: Context) {
    private val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    private val cameraId = cameraManager.cameraIdList.firstOrNull()
    private var flashJob: Job? = null

    fun startFlashing() {
        flashJob?.cancel()
        flashJob = CoroutineScope(Dispatchers.IO).launch {
            try {
                while (isActive) {
                    toggleFlash(true)
                    delay(50)
                    toggleFlash(false)
                    delay(50)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun stopFlashing() {
        flashJob?.cancel()
        toggleFlash(false)
    }

    private fun toggleFlash(state: Boolean) {
        try {
            cameraId?.let { cameraManager.setTorchMode(it, state) }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}

@Composable
fun rememberFlashControl(context: Context): FlashControl {
    return remember { FlashControl(context) }
}
