package com.samuelchowi.mhwlibrary.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuelchowi.domain.model.UITheme
import com.samuelchowi.domain.repository.UIThemeRepository
import com.samuelchowi.mhwlibrary.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    uiThemeRepository: UIThemeRepository
) : ViewModel() {

    private val _navState = MutableStateFlow<NavHomeState>(NavHomeState.Initial)
    val navState = _navState.asStateFlow()

    val themeDataState =
        uiThemeRepository.themeDataStream.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), UITheme())

    fun updateHomeNav(entry: NavHomeState) {
        viewModelScope.launch {
            _navState.emit(entry)
        }
    }
}

sealed class NavHomeState(val label: Int, val icon: Int) {
    data object Initial : NavHomeState(R.string.main_drawer_home, R.drawable.ic_home_icon)
    data object Monster : NavHomeState(R.string.main_drawer_monsters, R.drawable.ic_items_monster_jaw_base)
    data object Weapon : NavHomeState(R.string.main_drawer_weapons, R.drawable.ic_equipment_insect_glaive_base)
    data object Armor : NavHomeState(R.string.main_drawer_armors, R.drawable.ic_equipment_armor_set_base)
    data object ArmorBonus : NavHomeState(R.string.main_drawer_armors_bonus, R.drawable.ic_ui_set_bonus_base)
    data object Decorations : NavHomeState(R.string.main_drawer_decorations, R.drawable.ic_ui_decoration_4_base)
    data object Charms : NavHomeState(R.string.main_drawer_charms, R.drawable.ic_equipment_charm_base)
    data object Ailments : NavHomeState(R.string.main_drawer_ailments, R.drawable.ic_ailment_icon)
    data object Items : NavHomeState(R.string.main_drawer_items, R.drawable.ic_ui_item_box_white)
    data object Skill : NavHomeState(R.string.main_drawer_skills, R.drawable.ic_ui_armor_skill_base)
    data object Locations : NavHomeState(R.string.main_drawer_locations, R.drawable.ic_ui_map)
    data object About : NavHomeState(R.string.main_drawer_about, R.drawable.ic_monster_icon)
    data object Settings : NavHomeState(R.string.main_drawer_settings, R.drawable.ic_ui_settings_white)
}