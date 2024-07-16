package api.adapter.`in`.web.dto

data class TransferRequest(val senderId: Long, val receiverName: String, val amount: Double)