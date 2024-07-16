package view.controller

import com.jfoenix.controls.JFXSnackbar
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.service.use_case.LoginUseCase
import view.service.use_case.SignUpUseCase

@Controller
@FxmlView("/user-interface/view/login/login-view.fxml")
class LoginController(private val loginUseCase: LoginUseCase,
                      private val signUpUseCase: SignUpUseCase) {

    @FXML
    lateinit var vbox: VBox
    @FXML
    lateinit var textField_phoneNumber: TextField
    @FXML
    lateinit var textField_cnpj: TextField
    @FXML
    lateinit var textField_cpf: TextField
    @FXML
    lateinit var textField_signInPassword: TextField
    @FXML
    lateinit var textField_email: TextField
    @FXML
    lateinit var textField_name: TextField
    @FXML
    lateinit var textField_login: TextField
    @FXML
    lateinit var textField_password: TextField

    private lateinit var snackBar: JFXSnackbar

    @FXML
    private fun initialize() {
        snackBar = JFXSnackbar(vbox)
    }

    @FXML
    fun validateLoginOnMouseClicked() {
        loginUseCase.validateLogin(textField_login.text, textField_password.text, snackBar)
    }

    @FXML
    fun createAccountOnMouseClicked() {
        signUpUseCase.createAccount(
            textField_name.text,
            textField_email.text,
            textField_signInPassword.text,
            textField_phoneNumber.text,
            textField_cpf.text,
            textField_cnpj.text.takeIf { it.isNotBlank() },
            snackBar
        )
    }
}