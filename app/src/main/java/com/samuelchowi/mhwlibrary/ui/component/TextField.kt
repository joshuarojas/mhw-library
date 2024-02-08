package com.samuelchowi.mhwlibrary.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuelchowi.mhwlibrary.R

@Composable
fun EditText(
    text: () -> String,
    icon: @Composable () -> Unit,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = text(),
        onValueChange = onTextChange,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {}),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onSecondaryContainer),
        decorationBox = @Composable { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(vertical = 6.dp)
                    .padding(start = 4.dp, end = 6.dp)
            ) {
                icon()
                Box {
                    if (text().isEmpty())
                        Text(
                            text = stringResource(id = R.string.home_search_hint),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    innerTextField()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EditTextPreview() {
    EditText(
        text = { "Demo" },
        icon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "",
                modifier = Modifier.padding(end = 4.dp)
            )
        },
        onTextChange = { }
    )
}