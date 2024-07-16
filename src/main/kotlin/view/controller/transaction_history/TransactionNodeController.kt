package view.controller.transaction_history

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.model.Transaction
import view.service.use_case.transaction_history.TransactionNodeUseCase

@Controller
@FxmlView("/user-interface/view/transaction-history/transaction-node-view.fxml")
class TransactionNodeController(private val transactionNodeUseCase: TransactionNodeUseCase) {

    @FXML
    lateinit var label_amount: Label
    @FXML
    lateinit var label_timeStamp: Label
    @FXML
    lateinit var label_receiverUserName: Label
    @FXML
    lateinit var imageView_sentOrReceived: ImageView

    fun setTransactionData(transaction: Transaction) {
        transactionNodeUseCase.setTransactionData(
            transaction,
            label_amount,
            label_timeStamp,
            label_receiverUserName,
            imageView_sentOrReceived
        )
    }
}
