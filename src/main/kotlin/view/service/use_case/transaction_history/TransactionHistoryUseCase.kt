package view.service.use_case.transaction_history

import javafx.scene.layout.VBox

interface TransactionHistoryUseCase {
    fun returnToUsePage()
    fun populateTransactionHistory(vbox: VBox)
}
