package sitemas.jd.silva.trokinho.util

import sitemas.jd.silva.domain.model.Transaction
import sitemas.jd.silva.domain.model.TransactionType

val transactions = listOf(
    Transaction("Salário", 5000.0, "01/07/2025", TransactionType.ENTRY),
    Transaction("Mercado", 230.0, "02/07/2025", TransactionType.EXPENSE),
    Transaction("Aluguel", 1200.0, "03/07/2025", TransactionType.EXPENSE),
    Transaction("Freelance", 800.0, "04/07/2025", TransactionType.ENTRY),
)