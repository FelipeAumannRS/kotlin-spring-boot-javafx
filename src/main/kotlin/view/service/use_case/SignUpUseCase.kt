package view.service.use_case

import com.jfoenix.controls.JFXSnackbar

interface SignUpUseCase {

    fun createAccount(name: String, email: String, password: String, phoneNumber: String, cpf: String, cnpj: String?, snackBar: JFXSnackbar)
}
