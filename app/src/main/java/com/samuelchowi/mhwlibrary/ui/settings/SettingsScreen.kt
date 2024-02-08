package com.samuelchowi.mhwlibrary.ui.settings

import android.content.res.Configuration
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuelchowi.mhwlibrary.R
import com.samuelchowi.mhwlibrary.ui.component.Header
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = viewModel()
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        topBar = {
            Header(
                navIcon = {
                    IconButton(
                        onClick = { onBackPressedDispatcher?.onBackPressed() },
                        content = {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = null
                            )
                        }
                    )
                }
            )
        }
    ) {

        LazyColumn(
            contentPadding = PaddingValues(start = 10.dp, end = 10.dp, top = 10.dp),
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.settings_appearance),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            item {
                Card(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(1f)
                ) {
                    Text(
                        text = stringResource(id = R.string.settings_language),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = modifier.padding(10.dp)
                    )
                }
            }

            item {
                Card(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(10.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.settings_theme),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Switch(
                            checked = false,
                            onCheckedChange = {},
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }

            item {
                Card(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(1f)
                ) {
                    Row(modifier = modifier.padding(10.dp)) {
                        Text(
                            text = stringResource(
                                id = R.string.settings_theme_system,
                                if (isSystemInDarkTheme()) stringResource(R.string.settings_theme_light)
                                else stringResource(R.string.settings_theme_dark)
                            ),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Switch(
                            checked = false,
                            onCheckedChange = {},
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "settings_dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "settings_light", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}