package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import sitemas.jd.silva.trokinho.presentation.components.FinanceResumeHeader
import sitemas.jd.silva.trokinho.presentation.components.FloatActionButton
import sitemas.jd.silva.trokinho.presentation.components.TransactionList
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
        floatingActionButton = {
            FloatActionButton()
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