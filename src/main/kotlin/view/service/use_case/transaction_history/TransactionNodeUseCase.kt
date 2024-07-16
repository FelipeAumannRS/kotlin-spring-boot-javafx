package view.service.use_case.transaction_history

import javafx.scene.control.Label
import javafx.scene.image.ImageView
import view.model.Transaction

interface TransactionNodeUseCase {

    fun setTransactionData(transaction: Transaction,
                           label_amount: Label,
                           label_timeStamp: Label,
                           label_receiverUserName: Label,
                           imageView_sentOrReceived: ImageView)
}
