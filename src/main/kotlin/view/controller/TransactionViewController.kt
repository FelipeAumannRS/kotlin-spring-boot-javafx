package view.controller

import com.jfoenix.controls.JFXSnackbar
import javafx.fxml.FXML
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.component.SessionManager
import view.service.use_case.TransactionViewUseCase

@Controller
@FxmlView("/user-interface/view/transaction/transaction-view.fxml")
class TransactionViewController(private val transactionViewUseCase: TransactionViewUseCase) {

    @FXML
    lateinit var textField_amount: TextField
    @FXML
    lateinit var textField_destinatary: TextField
    @FXML
    lateinit var vbox: VBox

    private lateinit var snackBar: JFXSnackbar

    @FXML
    private fun initialize() {
        snackBar = JFXSnackbar(vbox)
    }

    @FXML
    fun returnToUserPageOnMouseClicked() {
        transactionViewUseCase.returnToUsePage()
    }

    @FXML
    fun transferOnMouseClicked() {
        val amount = textField_amount.text.toDouble()
        val receiverName = textField_destinatary.text
        val senderId = SessionManager.getLoggedInUser()?.id?.toLong() ?: throw Exception("Sender not logged in")

        transactionViewUseCase.transfer(senderId, receiverName, amount, snackBar)
    }
}