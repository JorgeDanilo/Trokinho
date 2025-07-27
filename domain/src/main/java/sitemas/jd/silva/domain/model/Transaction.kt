package sitemas.jd.silva.domain.model

data class Transaction(
    val description: String = "",
    val value: Double = 0.0,
    val date: String = "",
    val type: TransactionType
)

enum class TransactionType {
    ENTRY,
    EXPENSE
}
