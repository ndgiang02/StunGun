package com.example.electricstungun.components

import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.electricstungun.R

@Composable
fun IconElectric () {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.flash),
                contentDescription = "Electric Icon",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(id = R.drawable.flash),
                contentDescription = "Electric Icon",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
                    .align(Alignment.TopEnd)

            )
            Image(
                painter = painterResource(id = R.drawable.flash),
                contentDescription = "Electric Icon",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
                    .align(Alignment.BottomStart)

            )
            Image(
                painter = painterResource(id = R.drawable.flash),
                contentDescription = "Electric Icon",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            )
        }

}


