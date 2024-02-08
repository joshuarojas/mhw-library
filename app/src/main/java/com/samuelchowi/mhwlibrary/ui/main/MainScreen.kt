package com.samuelchowi.mhwlibrary.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samuelchowi.mhwlibrary.ui.ailments.AilmentScreen
import com.samuelchowi.mhwlibrary.ui.armor.ArmorScreen
import com.samuelchowi.mhwlibrary.ui.armorbonus.ArmorBonusScreen
import com.samuelchowi.mhwlibrary.ui.charms.CharmsScreen
import com.samuelchowi.mhwlibrary.ui.decorations.DecorationsScreen
import com.samuelchowi.mhwlibrary.ui.home.HomeScreen
import com.samuelchowi.mhwlibrary.ui.items.ItemsScreen
import com.samuelchowi.mhwlibrary.ui.locations.LocationsScreen
import com.samuelchowi.mhwlibrary.ui.monster.MonsterScreen
import com.samuelchowi.mhwlibrary.ui.skills.SkillsScreen
import com.samuelchowi.mhwlibrary.ui.weapon.WeaponScreen

@Composable
fun MainScreen(
    navigateTo: (String) -> Unit,
    mainViewModel: MainViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val toggleDrawer = suspend { drawerState.run { if (isClosed) open() else close() } }

    val navState by mainViewModel.navState.collectAsStateWithLifecycle()
//    val mainNavRouteState by mainViewModel.mainNavRouteState.collectAsStateWithLifecycle()

//    LaunchedEffect(key1 = mainNavRouteState) {
//        if (mainNavRouteState.isNotEmpty()) {
//            navigateTo(mainNavRouteState)
//            mainViewModel.clearMainNavRouteState()
//        }
//    }

    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        drawerContent = {
            MainDrawer(
                drawerNavigateTo = mainViewModel::updateHomeNav,
                mainNavigateTo = navigateTo,
                toggleDrawer = toggleDrawer,
                initialEntry = { navState }
            )
        }
    ) {

        when (navState) {
            NavHomeState.Monster -> MonsterScreen()
            NavHomeState.Weapon -> WeaponScreen()
            NavHomeState.Armor -> ArmorScreen()
            NavHomeState.ArmorBonus -> ArmorBonusScreen()
            NavHomeState.Decorations -> DecorationsScreen()
            NavHomeState.Charms -> CharmsScreen()
            NavHomeState.Ailments -> AilmentScreen()
            NavHomeState.Items -> ItemsScreen()
            NavHomeState.Skill -> SkillsScreen()
            NavHomeState.Locations -> LocationsScreen()
            else -> HomeScreen(toggleDrawer)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MainScreen({ })
}
