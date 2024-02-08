package com.samuelchowi.mhwlibrary.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuelchowi.data.local.model.ThemeData
import com.samuelchowi.mhwlibrary.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _navState = MutableStateFlow<NavHomeState>(NavHomeState.Initial)
    val navState = _navState.asStateFlow()

    private val _themeDataState = MutableStateFlow(ThemeData())
    val themeDataState = _themeDataState.asStateFlow()

    fun updateHomeNav(entry: NavHomeState) {
        viewModelScope.launch {
                _navState.emit(entry)
        }
    }
}

sealed class NavHomeState(val label: Int, val icon: Int) {
    data object Initial : NavHomeState(R.string.main_drawer_home, R.drawable.ic_home_icon)
    data object Monster : NavHomeState(R.string.main_drawer_monsters, R.drawable.ic_monster_icon)
    data object Weapon : NavHomeState(R.string.main_drawer_weapons, R.drawable.ic_weapon_icon)
    data object Armor : NavHomeState(R.string.main_drawer_armors, R.drawable.ic_armor_icon)
    data object ArmorBonus : NavHomeState(R.string.main_drawer_armors_bonus, R.drawable.ic_armor_bonus_icon)
    data object Decorations : NavHomeState(R.string.main_drawer_decorations, R.drawable.ic_decoration_icon)
    data object Charms : NavHomeState(R.string.main_drawer_charms, R.drawable.ic_charm_icon)
    data object Ailments : NavHomeState(R.string.main_drawer_ailments, R.drawable.ic_ailment_icon)
    data object Items : NavHomeState(R.string.main_drawer_items, R.drawable.ic_item_icon)
    data object Skill : NavHomeState(R.string.main_drawer_skills, R.drawable.ic_skill_icon)
    data object Locations : NavHomeState(R.string.main_drawer_locations, R.drawable.ic_location_icon)
    data object Settings : NavHomeState(R.string.main_drawer_settings, R.drawable.ic_settings_icon)
}