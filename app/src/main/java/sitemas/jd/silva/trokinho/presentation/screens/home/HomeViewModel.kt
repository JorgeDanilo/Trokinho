package sitemas.jd.silva.trokinho.presentation.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import sitemas.jd.silva.domain.model.Transaction
import sitemas.jd.silva.domain.model.TransactionType
import sitemas.jd.silva.trokinho.util.transactions
import java.text.DateFormatSymbols
import java.util.Calendar
import java.util.Locale

class HomeViewModel: ViewModel() {

    private val calendar = Calendar.getInstance()
    private val _uiState = MutableStateFlow(
        FinancesUiState(
            month = formatMonth(calendar),
            transactions = getTransactionsForMonth(calendar.get(Calendar.MONTH))
        )
    )

    val uiState:StateFlow<FinancesUiState> = _uiState.asStateFlow()


    fun onIntent(intent: FinancesIntent) {
        when(intent) {
            is FinancesIntent.PreviousMonth -> {
                calendar.add(Calendar.MONTH, - 1)
                updateUiState()
            }
            is FinancesIntent.NextMonth -> {
                calendar.add(Calendar.MONTH, 1)
                updateUiState()
            }
            is FinancesIntent.AddTransaction -> {

            }
        }
    }

    private fun updateUiState() {
        val monthIndex = calendar.get(Calendar.MONTH)
        _uiState.update {
            it.copy(
                month = formatMonth(calendar),
                transactions = getTransactionsForMonth(monthIndex)
            )
        }
    }

    private fun getTransactionsForMonth(index: Int): List<Transaction> {
        val monthNames = DateFormatSymbols(Locale("pt", "BR")).months
        val month = monthNames[index].replaceFirstChar { it.uppercase() }

        return listOf(
            Transaction("Salário", 5000.0, "$month 01", TransactionType.EXPENSE),
            Transaction("Salário", 5000.0, "$month 10", TransactionType.ENTRY)
        )
    }

    private fun formatMonth(calendar: Calendar): String {
        val monthIndex = calendar.get(Calendar.MONTH)
        val months = DateFormatSymbols(Locale("pt", "BR")).months
        val month = months[monthIndex]
        return month.replaceFirstChar { it.uppercase() }
    }

}