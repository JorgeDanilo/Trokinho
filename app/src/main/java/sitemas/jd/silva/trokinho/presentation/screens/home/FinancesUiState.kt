package sitemas.jd.silva.trokinho.presentation.screens.home

import sitemas.jd.silva.domain.model.Transaction

data class FinancesUiState(
    val month: String? = "",
    val balance: Double? = 0.0,
    val transactions: List<Transaction> = emptyList()
)
