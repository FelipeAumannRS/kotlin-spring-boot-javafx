package view.service.use_case

import com.jfoenix.controls.JFXSnackbar

interface TransactionViewUseCase {
    fun transfer(senderId: Long, receiverName: String, amount: Double, snackBar: JFXSnackbar)
    fun returnToUsePage()
}
