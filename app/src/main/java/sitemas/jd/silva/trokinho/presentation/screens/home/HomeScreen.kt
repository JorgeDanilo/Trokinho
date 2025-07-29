package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import sitemas.jd.silva.trokinho.presentation.components.FinanceResumeHeader
import sitemas.jd.silva.trokinho.presentation.components.FloatActionButton
import sitemas.jd.silva.trokinho.presentation.components.TransactionList
import sitemas.jd.silva.trokinho.util.transactions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory())
    val uiState by viewModel.uiState.collectAsState()

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
                month = uiState.month.toString(),
                onPreviousClick = { viewModel.onIntent(FinancesIntent.PreviousMonth) },
                onNextClick = { viewModel.onIntent(FinancesIntent.NextMonth) }
            )
        },

        floatingActionButton = {
            FloatActionButton(onClick = {})
        }

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