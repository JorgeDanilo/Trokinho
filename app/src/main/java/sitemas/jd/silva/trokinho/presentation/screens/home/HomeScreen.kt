package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sitemas.jd.silva.trokinho.presentation.components.FinanceResumeHeader
import sitemas.jd.silva.trokinho.presentation.components.TransactionList
import sitemas.jd.silva.trokinho.ui.theme.SecondaryColor
import sitemas.jd.silva.trokinho.util.transactions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val scrollBehavior = TopAppBarDefaults
        .enterAlwaysScrollBehavior(rememberTopAppBarState())

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
            Box {
                BottomBar(modifier = Modifier.align(Alignment.BottomCenter))
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

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    var navNum by remember {
        mutableIntStateOf(0)
    }

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
            if (navNum == 0) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Menu",
                        tint = SecondaryColor,
                        modifier = Modifier
                            .size(55.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 0}) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            if (navNum == 1) {
                IconButton(onClick = { navNum = 1}) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = SecondaryColor,
                        modifier = Modifier
                            .size(55.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 1}) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.White,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (navNum == 2) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Call",
                        tint = SecondaryColor,
                        modifier = Modifier
                            .size(55.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 2}) {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Call",
                        tint = Color.White,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))
            if (navNum == 3) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Call",
                        tint = SecondaryColor,
                        modifier = Modifier
                            .size(55.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 3}) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Call",
                        tint = Color.White,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BottomNavPreview() {
    Box(modifier = Modifier.padding(vertical = 50.dp, horizontal = 10.dp)) {
        BottomBar(modifier = Modifier.align(Alignment.BottomCenter))
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
}