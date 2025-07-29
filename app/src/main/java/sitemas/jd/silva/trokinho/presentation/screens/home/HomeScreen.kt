package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import sitemas.jd.silva.trokinho.presentation.components.BottomBar
import sitemas.jd.silva.trokinho.presentation.components.BottomNavItem
import sitemas.jd.silva.trokinho.presentation.components.FinanceResumeHeader
import sitemas.jd.silva.trokinho.presentation.components.TransactionList
import sitemas.jd.silva.trokinho.ui.theme.SecondaryColor
import sitemas.jd.silva.trokinho.util.transactions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val scrollBehavior = TopAppBarDefaults
        .enterAlwaysScrollBehavior(rememberTopAppBarState())

    val systemUiController = rememberSystemUiController()
    val systemBarColor = Color(0xFF3F51B5)

    SideEffect {
        systemUiController.setNavigationBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        modifier =
            Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeTopBar(
                scrollBehavior,
                month = "Julho", // todo get month actually.
                onPreviousClick = {  },
                onNextClick = {  }
            )
        },
        bottomBar = {
            var selected by remember { mutableStateOf(BottomNavItem.HOME) }

            Box {
                BottomBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    selectedItem = selected,
                    onItemSelected = { selected = it }
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 35.dp)
                        .clip(CircleShape)
                        .background(SecondaryColor)
                        .align(Alignment.BottomCenter)
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add",
                        tint = Color.Black,
                        modifier = Modifier.size((40.dp))
                    )
                }
            }
        },

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            FinanceResumeHeader(value = 5000.0)
            TransactionList(transactions)
        }
    }
}