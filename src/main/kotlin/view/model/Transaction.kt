package view.model

data class Transaction(
    val id: Long,
    val amount: Double,
    val timestamp: String,
    val senderId: String,
    val receiverId: String
)
