package view.controller.transaction_history

import javafx.fxml.FXML
import javafx.scene.layout.VBox
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.service.use_case.transaction_history.TransactionHistoryUseCase

@Controller
@FxmlView("/user-interface/view/transaction-history/transaction-history-view.fxml")
class TransactionHistoryController(private val transactionHistoryUseCase: TransactionHistoryUseCase) {

    @FXML
    lateinit var vbox_transactions: VBox

    @FXML
    private fun initialize() {
        transactionHistoryUseCase.populateTransactionHistory(vbox_transactions)
    }

    @FXML
    fun returnToUserPageOnMouseClicked() {
        transactionHistoryUseCase.returnToUsePage()
    }
}
