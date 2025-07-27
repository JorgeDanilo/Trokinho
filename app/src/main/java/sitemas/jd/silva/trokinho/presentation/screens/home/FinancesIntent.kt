package sitemas.jd.silva.trokinho.presentation.screens.home

import sitemas.jd.silva.domain.model.Transaction

sealed class FinancesIntent {
    object PreviousMonth: FinancesIntent()
    object NextMonth: FinancesIntent()
    data class AddTransaction(val transaction: Transaction): FinancesIntent()
}
