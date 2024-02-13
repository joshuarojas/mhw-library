package com.samuelchowi.mhwlibrary.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuelchowi.mhwlibrary.R
import com.samuelchowi.mhwlibrary.ui.component.DrawerItem
import kotlinx.coroutines.launch

private val drawerItems = listOf(
    NavHomeState.Initial,
    NavHomeState.Monster,
    NavHomeState.Weapon,
    NavHomeState.Armor,
    NavHomeState.ArmorBonus,
    NavHomeState.Decorations,
    NavHomeState.Charms,
    NavHomeState.Ailments,
    NavHomeState.Items,
    NavHomeState.Skill,
    NavHomeState.Locations,
    NavHomeState.About,
    NavHomeState.Settings
)

@Composable
fun MainDrawer(
    drawerNavigateTo: (NavHomeState) -> Unit,
    mainNavigateTo: (String) -> Unit,
    toggleDrawer: suspend () -> Unit,
    initialEntry: () -> NavHomeState,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()

    ModalDrawerSheet(
        drawerContainerColor = MaterialTheme.colorScheme.background,
        modifier = modifier.wrapContentWidth()
    ) {
        Column(
            modifier = modifier
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 14.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_mhw_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = stringResource(id = R.string.main_drawer_title),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Divider(
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                modifier = Modifier.padding(top = 10.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(
                    count = drawerItems.count(),
                    key = { drawerItems[it].run { "$this+${initialEntry() == this}" } },
                    itemContent = {
                        val item = drawerItems[it]
                        val isSelected = initialEntry() == item
                        DrawerItem(
                            label = {
                                Text(
                                    text = stringResource(item.label),
                                    style = MaterialTheme.typography.headlineLarge,
                                )
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(item.icon),
                                    tint = Color.Unspecified,
                                    contentDescription = null
                                )
                            },
                            selected = { isSelected },
                            onClick = {
                                scope.launch { toggleDrawer() }
                                if (!isSelected) {
                                    when (item) {
                                        NavHomeState.Settings -> mainNavigateTo("/settings")
                                        NavHomeState.About -> mainNavigateTo("/about")
                                        else -> drawerNavigateTo(item)
                                    }
                                }
                            },
                            modifier = Modifier.padding(top = if (it == 0) 10.dp else 0.dp),
                        )
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeDrawerPreview() {
    MainDrawer(
        drawerNavigateTo = {},
        mainNavigateTo = {},
        toggleDrawer = {},
        initialEntry = { NavHomeState.Initial }
    )
}