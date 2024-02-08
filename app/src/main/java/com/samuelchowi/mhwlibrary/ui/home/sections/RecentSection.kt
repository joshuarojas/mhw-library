package com.samuelchowi.mhwlibrary.ui.home.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.samuelchowi.mhwlibrary.R
import com.samuelchowi.mhwlibrary.ui.component.CompactCardItem

@Composable
fun RecentSection(items: () -> List<String>, onClick: (String) -> Unit) {
    Column {
        Text(
            text = stringResource(id = R.string.home_recent_items),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        if (items().isEmpty()) {
            Text(
                text = stringResource(id = R.string.home_recent_items_empty),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(14.dp)
                    .alpha(0.6f)
            )
        } else {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                items(count = items().size) {
                    CompactCardItem(
                        item = { items()[it] },
                        isLast = { items().size - 1 == it },
                        onClick = onClick
                    )
                }
            }
        }
    }
}