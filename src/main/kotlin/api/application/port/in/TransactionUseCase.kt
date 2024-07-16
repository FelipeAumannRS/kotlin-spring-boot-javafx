package api.application.port.`in`

import api.domain.model.Transaction

interface TransactionUseCase {

    fun transfer(senderId: Long, receiverName: String, amount: Double)
    fun getTransactionHistory(userId: Long): List<Transaction>
}
