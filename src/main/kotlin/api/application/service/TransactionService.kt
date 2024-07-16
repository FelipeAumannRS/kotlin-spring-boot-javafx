package api.application.service

import api.adapter.out.persistance.entity.TransactionEntity
import api.adapter.out.persistance.mapper.toDomain
import api.application.port.`in`.TransactionUseCase
import api.application.port.out.TransactionRepository
import api.application.port.out.UserRepository
import api.domain.model.Transaction
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class TransactionService(private val userRepository: UserRepository,
                              private val transactionRepository: TransactionRepository) : TransactionUseCase {

    @Transactional
    override fun transfer(senderId: Long, receiverName: String, amount: Double) {
        val sender = userRepository.findById(senderId).orElseThrow { Exception("Sender not found") }
        val receiver = userRepository.findByName(receiverName) ?: throw Exception("Receiver not found")

        if (sender.balance < amount) {
            throw Exception("Insufficient funds")
        }

        sender.balance -= amount
        receiver.balance += amount

        val transaction = TransactionEntity(
            sender = sender,
            receiver = receiver,
            amount = amount
        )

        transactionRepository.save(transaction)
        userRepository.save(sender)
        userRepository.save(receiver)
    }

    override fun getTransactionHistory(userId: Long): List<Transaction> {
        val user = userRepository.findById(userId).orElseThrow { Exception("User not found") }
        val sentTransactions = transactionRepository.findAllBySenderId(user.id).map { toDomain(it) }
        val receivedTransactions = transactionRepository.findAllByReceiverId(user.id).map { toDomain(it) }
        return (sentTransactions + receivedTransactions).sortedByDescending { it.timestamp }
    }
}
