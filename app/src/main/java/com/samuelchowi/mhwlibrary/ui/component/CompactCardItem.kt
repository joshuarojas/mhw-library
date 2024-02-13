package com.samuelchowi.mhwlibrary.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuelchowi.mhwlibrary.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompactCardItem(
    item: () -> String,
    isLast: () -> Boolean,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier.padding(end = if (isLast()) 0.dp else 10.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = { onClick(item()) }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_mhw_logo),
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Text(
            text = stringResource(id = R.string.home_recent_items),
            style = MaterialTheme.typography.titleMedium
        )
    }
}