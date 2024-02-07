package com.samuelchowi.data.local.preferences.impl

import android.content.Context
import androidx.core.content.edit
import com.samuelchowi.data.local.model.ThemeData
import com.samuelchowi.data.local.preferences.ThemePreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ThemePreferencesImpl @Inject constructor(
    @ApplicationContext val context: Context
): ThemePreferences {

    override val themeDataStream: MutableStateFlow<ThemeData>
    override val themeData by ThemeDataPreferenceDelegate()

    private val preferences = context.getSharedPreferences("MHWLibrary_pref", Context.MODE_PRIVATE)

    init {
        themeDataStream = MutableStateFlow(themeData)
    }

    inner class ThemeDataPreferenceDelegate() : ReadWriteProperty<ThemePreferencesImpl, ThemeData> {
        override fun getValue(thisRef: ThemePreferencesImpl, property: KProperty<*>): ThemeData =
            ThemeData(
                preferences.getBoolean("isDarkThemeEnabled", false),
                preferences.getBoolean("isSystemPreferred", true)
            )

        override fun setValue(thisRef: ThemePreferencesImpl, property: KProperty<*>, value: ThemeData) {
            preferences.edit {
                putBoolean("isDarkThemeEnabled", value.isDarkThemeEnabled)
                putBoolean("isSystemPreferred", value.isSystemThemePreferred)
            }
        }
    }
}