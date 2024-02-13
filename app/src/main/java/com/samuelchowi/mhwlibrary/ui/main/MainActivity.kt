package com.samuelchowi.mhwlibrary.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samuelchowi.mhwlibrary.ui.settings.SettingsScreen
import com.samuelchowi.mhwlibrary.ui.theme.MHWLibraryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MHWLibraryTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "/") {
                        composable("/") { MainScreen({ navController.navigate(it) }) }
                        composable("/settings") { SettingsScreen() }
                        composable("/about") { SettingsScreen() }
                    }
                }
            }
        }
    }
}