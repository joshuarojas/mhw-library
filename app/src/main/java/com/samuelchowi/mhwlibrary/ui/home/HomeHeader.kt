package com.samuelchowi.mhwlibrary.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samuelchowi.mhwlibrary.R
import com.samuelchowi.mhwlibrary.ui.component.EditText

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
            )
            .padding(horizontal = 10.dp)
            .padding(bottom = 10.dp)
    ) {
        val queryState by viewModel.searchQuery.collectAsStateWithLifecycle()

        Text(
            text = stringResource(id = R.string.home_title),
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.fillMaxWidth()
        )
        EditText(
            text = { queryState },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 4.dp)
                )
            },
            onTextChange = { viewModel.userAction(HomeEvent.SearchQuery(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(20.dp)
                )
        )
    }
}

@Preview
@Composable
fun HomeHeaderPreview() {
    HomeHeader()
}