package com.campground.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    HomeScreen(padding = padding)
}

@Composable
fun HomeScreen(
    padding: PaddingValues
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Hello Android Compose")
    }
}