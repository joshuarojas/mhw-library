package com.samuelchowi.mhwlibrary.ui.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samuelchowi.mhwlibrary.ui.home.sections.RecentSection

@Composable
fun InitialBody(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {
    val recentItemsState by homeViewModel.recentItems.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        item {
            RecentSection(
                items = { recentItemsState },
                onClick = { homeViewModel.userAction(HomeEvent.GoToDetail(it)) }
            )
        }

        item {

        }
    }
}