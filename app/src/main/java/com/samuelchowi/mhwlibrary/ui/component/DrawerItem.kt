package com.samuelchowi.mhwlibrary.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun DrawerItem(
    label: @Composable () -> Unit,
    selected: () -> Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val colors = NavigationDrawerItemDefaults.colors()
    Surface(
        selected = selected(),
        onClick = onClick,
        modifier = modifier
            .semantics { role = Role.Tab }
            .height(40.dp)
            .fillMaxWidth(),
        color = colors.containerColor(selected()).value,
        shape = RoundedCornerShape(10.dp),
        interactionSource = interactionSource,
    ) {
        Row(
            Modifier.padding(start = 6.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                val iconColor = colors.iconColor(selected()).value
                CompositionLocalProvider(LocalContentColor provides iconColor, content = icon)
                Spacer(Modifier.width(12.dp))
            }
            val labelColor = colors.textColor(selected()).value
            CompositionLocalProvider(LocalContentColor provides labelColor, content = label)
        }
    }
}