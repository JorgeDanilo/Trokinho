package sitemas.jd.silva.trokinho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sitemas.jd.silva.trokinho.presentation.screens.home.HomeScreen
import sitemas.jd.silva.trokinho.ui.theme.TrokinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrokinhoTheme {
                HomeScreen()
            }
        }
    }
}