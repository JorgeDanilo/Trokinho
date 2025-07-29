package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.DateFormatSymbols
import java.util.Calendar
import java.util.Locale

class HomeViewModel: ViewModel() {

    private val calendar = Calendar.getInstance()
    private val _uiState = MutableStateFlow(
        FinancesUiState(month = formatMonth(calendar))
    )

    val uiState:StateFlow<FinancesUiState> = _uiState.asStateFlow()


    fun onIntent(intent: FinancesIntent) {
        when(intent) {
            is FinancesIntent.PreviousMonth -> {
                calendar.add(Calendar.MONTH, - 1)
                _uiState.update { it.copy(month = formatMonth(calendar)) }
            }
            is FinancesIntent.NextMonth -> {
                calendar.add(Calendar.MONTH, 1)
                _uiState.update { it.copy(month = formatMonth(calendar)) }
            }
            is FinancesIntent.AddTransaction -> {

            }
        }
    }
    private fun formatMonth(calendar: Calendar): String {
        val monthIndex = calendar.get(Calendar.MONTH)
        val months = DateFormatSymbols(Locale("pt", "BR")).months
        val month = months[monthIndex]
        return month.replaceFirstChar { it.uppercase() }
    }

}