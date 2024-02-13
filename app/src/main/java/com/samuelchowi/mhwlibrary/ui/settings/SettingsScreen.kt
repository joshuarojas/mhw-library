package com.samuelchowi.mhwlibrary.ui.settings

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.samuelchowi.mhwlibrary.R
import com.samuelchowi.mhwlibrary.ui.component.Header


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val uiThemeState by viewModel.themeDataState.collectAsStateWithLifecycle()
    val languageState by viewModel.languageDataState.collectAsStateWithLifecycle()
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
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(start = 10.dp, end = 10.dp, top = 10.dp),
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
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
                    onClick = { viewModel.updateAppLanguage("es") },
                    modifier = Modifier.fillMaxWidth(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(horizontal = 10.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.settings_language, languageState.toString()),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = modifier.weight(1f)
                        )
                        Text(
                            text = "Change",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Thin,
                                fontStyle = FontStyle.Italic
                            ),
                        )
                    }
                }
            }

            item {
                Card(
                    onClick = { viewModel.updateThemeData(isDarkThemeEnabled = !uiThemeState.isDarkThemeEnabled) },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(horizontal = 10.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.settings_theme),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Switch(
                            checked = uiThemeState.isDarkThemeEnabled,
                            onCheckedChange = null,
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }

            item {
                Card(
                    onClick = { viewModel.updateThemeData(isSystemPreferredEnabled = !uiThemeState.isSystemThemePreferred) },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(horizontal = 10.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = stringResource(
                                id = R.string.settings_theme_system,
                                if (isSystemInDarkTheme()) stringResource(R.string.settings_theme_dark)
                                else stringResource(R.string.settings_theme_light)
                            ),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Switch(
                            checked = uiThemeState.isSystemThemePreferred,
                            onCheckedChange = null,
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}