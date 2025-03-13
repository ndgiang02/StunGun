package com.example.electricstungun.ui

import android.graphics.BlendMode
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.electricstungun.R
import com.example.electricstungun.components.IconElectric
import com.example.electricstungun.utils.rememberFlashControl
import com.example.electricstungun.utils.rememberSoundManager
import kotlinx.coroutines.delay

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val soundManager = rememberSoundManager(context)
    val flashControl = rememberFlashControl(context)
    var isActivated by remember { mutableStateOf(false) }
    var showIcons by remember { mutableStateOf(false) }
    var showImage by remember { mutableStateOf(true) }

    LaunchedEffect(isActivated) {
        if (!isActivated) {
            flashControl.stopFlashing()
            showImage = true
            showIcons = false
            return@LaunchedEffect
        }

        flashControl.startFlashing()

        while (isActivated) {
            showImage = !showImage
            showIcons = !showIcons
            delay(40)
        }

        flashControl.stopFlashing()
        showImage = true
        showIcons = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    isActivated = !isActivated
                    if (isActivated) {
                        soundManager.startSound()
                        flashControl.startFlashing()
                    } else {
                        soundManager.stopSound()
                        flashControl.stopFlashing()
                    }
                }
            }
    ) {
        if (showImage) {
            Image(
                painter = painterResource(id = R.drawable.backgound),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize() ,
                contentScale = ContentScale.Crop
            )
        } else {
            Box(modifier = Modifier.fillMaxSize().background(Color.White))
        }

        if (showIcons) {
            IconElectric()
            Image(
                painter = painterResource(id = R.drawable.electric_wave),
                contentDescription = "Electric wave",
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = (+10).dp, y = (-160).dp)
                    .scale(0.4F, 0.5F)
                    .align(Alignment.Center)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.stungun),
            contentDescription = "Stun Gun ",
            modifier = Modifier
                .fillMaxWidth()
                .scale(2.03F, 2.03F)
                .offset(x = (-20).dp, y = (+20).dp)
                .align(Alignment.Center)
                .alpha(0.3f)
                .blur(8.dp),
            colorFilter = ColorFilter.tint(Color.Black)

        )

        Image(
            painter = painterResource(id = R.drawable.stungun),
            contentDescription = "Stun Gun ",
            modifier = Modifier
                .fillMaxWidth()
                .scale(2F, 2F)
                .offset(x = (-20).dp, y = (+20).dp)
                .align(Alignment.Center)
        )
    }

}