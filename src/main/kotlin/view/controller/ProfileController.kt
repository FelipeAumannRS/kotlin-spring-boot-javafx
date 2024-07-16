package view.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.service.use_case.ProfileUseCase

@Controller
@FxmlView("/user-interface/view/profile/profile-view.fxml")
class ProfileController(private val profileUseCase: ProfileUseCase) {

    @FXML
    lateinit var label_balance: Label
    @FXML
    lateinit var textField_cpf: TextField
    @FXML
    lateinit var textField_name: TextField
    @FXML
    lateinit var textField_cnpj: TextField
    @FXML
    lateinit var textField_email: TextField
    @FXML
    lateinit var textField_phoneNumber: TextField

    @FXML
    private fun initialize() {
        profileUseCase.populateFields(label_balance,
            textField_cpf,
            textField_name,
            textField_cnpj,
            textField_email,
            textField_phoneNumber)
    }

    @FXML
    fun returnToUserPageOnMouseClicked() {
        profileUseCase.returnToUsePage()
    }
}