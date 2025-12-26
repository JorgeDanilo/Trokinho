package sitemas.jd.silva.trokinho.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sitemas.jd.silva.trokinho.ui.theme.SecondaryColor


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedItem: BottomNavItem = BottomNavItem.HOME,
    onItemSelected: (BottomNavItem) -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color(0xFF3F51B5))
            .padding(vertical = 15.dp, horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BottomBarItem(
                item = BottomNavItem.HOME,
                isSelected = selectedItem == BottomNavItem.HOME,
                onClick = { onItemSelected(BottomNavItem.HOME) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            BottomBarItem(
                item = BottomNavItem.CALL,
                isSelected = selectedItem == BottomNavItem.CALL,
                onClick = { onItemSelected(BottomNavItem.CALL) }
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            BottomBarItem(
                item = BottomNavItem.MESSAGE,
                isSelected = selectedItem == BottomNavItem.MESSAGE,
                onClick = { onItemSelected(BottomNavItem.MESSAGE) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            BottomBarItem(
                item = BottomNavItem.PROFILE,
                isSelected = selectedItem == BottomNavItem.PROFILE,
                onClick = { onItemSelected(BottomNavItem.PROFILE) }
            )
        }

    }
}

@Composable
private fun BottomBarItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val iconSize = if (isSelected) 55.dp else 25.dp
    val tint = if (isSelected) SecondaryColor else Color.White

    IconButton(onClick = onClick) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.contentDescription,
            tint = tint,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Preview
@Composable
fun BottomNavPreview() {

    var selected by remember { mutableStateOf(BottomNavItem.HOME) }

    Box(modifier = Modifier.padding(vertical = 40.dp, horizontal = 10.dp)) {
        BottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItem = selected,
            onItemSelected = { selected = it }
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(bottom = 25.dp)
                .clip(CircleShape)
                .background(SecondaryColor)
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add",
                tint = Color.Black,
                modifier = Modifier.size((35.dp))
            )
        }
    }
}