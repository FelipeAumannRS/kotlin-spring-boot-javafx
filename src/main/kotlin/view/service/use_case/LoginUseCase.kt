package view.service.use_case

import com.jfoenix.controls.JFXSnackbar

interface LoginUseCase {

    fun validateLogin(email: String, password: String, snackBar: JFXSnackbar)
}