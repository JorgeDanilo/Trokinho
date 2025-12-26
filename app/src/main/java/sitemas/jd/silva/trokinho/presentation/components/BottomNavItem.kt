package sitemas.jd.silva.trokinho.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItem(
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME(Icons.Default.Home, "Home"),
    CALL(Icons.Default.Call, "Call"),
    MESSAGE(Icons.Default.MailOutline, "Messages"),
    PROFILE(Icons.Default.AccountCircle, "Profile")
}