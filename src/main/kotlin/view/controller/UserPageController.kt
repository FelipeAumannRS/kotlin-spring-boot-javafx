package view.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.component.SessionManager
import view.service.use_case.UserPageUseCase

@Controller
@FxmlView("/user-interface/view/user-page/user-page-view.fxml")
class UserPageController(private var userPageUseCase: UserPageUseCase) {

    @FXML
    lateinit var label_loggedInUser: Label

    @FXML
    private fun initialize() {
        label_loggedInUser.text = "Welcome, ".plus(SessionManager.getLoggedInUserName())
    }

    @FXML
    fun logOutOnMouseClicked() {
        userPageUseCase.logOut()
    }

    @FXML
    fun openProfileViewOnMouseClicked() {
        userPageUseCase.loadProfileView()
    }

    @FXML
    fun openTransactionHistoryViewOnMouseClicked() {
        userPageUseCase.loadTransactionHistoryView()
    }

    @FXML
    fun openTransactionViewOnMouseClicked() {
        userPageUseCase.loadTransferView()
    }
}