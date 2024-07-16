package view.service.use_case

import javafx.scene.control.Label
import javafx.scene.control.TextField

interface ProfileUseCase {

    fun returnToUsePage()
    fun populateFields(label_balance: Label,
                       textField_cpf: TextField,
                       textField_name: TextField,
                       textField_cnpj: TextField,
                       textField_email: TextField,
                       textField_phoneNumber: TextField)
}