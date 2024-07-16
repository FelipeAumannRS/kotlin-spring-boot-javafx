package api.adapter.out.persistance.mapper

import api.adapter.out.persistance.entity.TransactionEntity
import api.adapter.out.persistance.entity.UserEntity
import api.domain.model.Transaction
import java.time.LocalDateTime

fun toDomain(transactionEntity: TransactionEntity): Transaction {
    return Transaction(
        id = transactionEntity.id,
        amount = transactionEntity.amount,
        timestamp = transactionEntity.timestamp.toString(),
        senderId = transactionEntity.sender.id.toString(),
        receiverId = transactionEntity.receiver.id.toString()
    )
}

