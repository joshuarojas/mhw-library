package com.samuelchowi.mhwlibrary.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.samuelchowi.mhwlibrary.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(toggleDrawer: suspend () -> Unit) {
    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        val scope = rememberCoroutineScope()
        val keyboardController = LocalSoftwareKeyboardController.current

        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            IconButton(
                onClick = {
                    scope.launch { toggleDrawer() }
                    keyboardController?.hide()
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = stringResource(id = (R.string.home_menu_icon_cn))
                )
            }
        }

        HomeHeader()
        InitialBody(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(toggleDrawer = {})
}