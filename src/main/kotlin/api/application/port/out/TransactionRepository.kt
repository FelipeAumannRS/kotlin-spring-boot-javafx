package api.application.port.out

import api.adapter.out.persistance.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : JpaRepository<TransactionEntity, Long> {

    fun findAllBySenderId(senderId: Long): List<TransactionEntity>
    fun findAllByReceiverId(receiverId: Long): List<TransactionEntity>
}
