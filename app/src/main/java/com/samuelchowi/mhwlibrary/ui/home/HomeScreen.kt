package com.samuelchowi.mhwlibrary.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(toggleDrawer: suspend () -> Unit) {
    Scaffold(
        topBar = {
            HomeHeader(toggleDrawer = toggleDrawer)
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        InitialBody(modifier = Modifier.padding(it))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(toggleDrawer = {})
}