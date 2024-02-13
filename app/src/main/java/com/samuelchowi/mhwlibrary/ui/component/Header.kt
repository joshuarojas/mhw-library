package com.samuelchowi.mhwlibrary.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuelchowi.mhwlibrary.R

@Composable
fun Header(
    navIcon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 4.dp,
        color = Color.Transparent,
        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = modifier
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                )
        ) {
            navIcon()

            Text(
                text = stringResource(id = R.string.settings_title),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0B3141)
@Composable
fun HeaderPreview() {
    Header(
        navIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = stringResource(id = (R.string.home_menu_icon_cn))
                )
            }
        }
    )
}