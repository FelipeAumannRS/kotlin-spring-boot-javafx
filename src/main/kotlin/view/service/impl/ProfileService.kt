package view.service.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import javafx.scene.control.Label
import javafx.scene.control.TextField
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import view.component.SessionManager
import view.controller.UserPageController
import view.model.User
import view.service.use_case.LoadViewUseCase
import view.service.use_case.ProfileUseCase

@Service
class ProfileService(private val loadViewUseCase: LoadViewUseCase) : ProfileUseCase {

    private val client = OkHttpClient()
    private val objectMapper = jacksonObjectMapper()

    override fun returnToUsePage() {
        loadViewUseCase.loadView(UserPageController::class.java)
    }

    override fun populateFields(
        label_balance: Label,
        textField_cpf: TextField,
        textField_name: TextField,
        textField_cnpj: TextField,
        textField_email: TextField,
        textField_phoneNumber: TextField
    ) {
        refreshUserData()
        val loggedInUser = SessionManager.getLoggedInUser()
        label_balance.text = loggedInUser?.balance.toString()
        textField_cpf.text = loggedInUser?.cpf
        textField_name.text = loggedInUser?.name
        textField_cnpj.text = loggedInUser?.cnpj
        textField_email.text = loggedInUser?.email
        textField_phoneNumber.text = loggedInUser?.celNumber
    }

    private fun refreshUserData() {
        val loggedInUser = SessionManager.getLoggedInUser() ?: return
        val request = Request.Builder()
            .url("http://localhost:8080/api/users/${loggedInUser.id}")
            .get()
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val updatedUser = objectMapper.readValue(response.body?.string(), User::class.java)
                SessionManager.setLoggedInUser(updatedUser)
            } else {
                throw Exception("Failed to refresh user data")
            }
        }
    }
}
