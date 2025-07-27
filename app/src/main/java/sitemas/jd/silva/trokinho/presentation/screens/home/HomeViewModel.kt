package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(FinancesUiState())
    val uiState:StateFlow<FinancesUiState> = _uiState.asStateFlow()

    fun onIntent(intent: FinancesIntent) {
        when(intent) {
            is FinancesIntent.PreviousMonth -> {

            }
            is FinancesIntent.NextMonth -> {

            }
            is FinancesIntent.AddTransaction -> {

            }
        }
    }

}