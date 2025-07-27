package sitemas.jd.silva.trokinho.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatActionButton () {
    FloatingActionButton(
        containerColor = Color(0xFF3F51B5),
        onClick = {}
    ) {
        Icon(
            tint = Color.White,
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
        )
    }
}

@Preview
@Composable
fun FloatingActionButtonPreview() {
    FloatActionButton()
}