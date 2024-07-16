package api.adapter.`in`.web.controller

import api.adapter.`in`.web.dto.TransferRequest
import api.application.port.`in`.TransactionUseCase
import api.domain.model.Transaction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val transactionUseCase: TransactionUseCase) {

    @PostMapping("/transfer")
    fun transferMoney(@RequestBody transferRequest: TransferRequest): ResponseEntity<String> {
        return try {
            transactionUseCase.transfer(transferRequest.senderId, transferRequest.receiverName, transferRequest.amount)
            ResponseEntity.ok("Transfer successful")
        } catch (e: Exception) {
            ResponseEntity.badRequest().body("Transfer failed: ${e.message}")
        }
    }

    @GetMapping("/history/{userId}")
    fun getTransactionHistory(@PathVariable userId: Long): ResponseEntity<List<Transaction>> {
        val transactions = transactionUseCase.getTransactionHistory(userId)
        return ResponseEntity.ok(transactions)
    }
}
