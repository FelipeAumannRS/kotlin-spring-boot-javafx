package view.service.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.jfoenix.controls.JFXSnackbar
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service
import view.model.SignUpRequest
import view.model.User
import view.service.use_case.SignUpUseCase

@Service
class SignUpService : SignUpUseCase {

    private val client = OkHttpClient()
    private val objectMapper = jacksonObjectMapper()

    override fun createAccount(name: String, email: String, password: String, phoneNumber: String, cpf: String, cnpj: String?, snackBar: JFXSnackbar) {
        val signUpRequest = SignUpRequest(name, email, password, phoneNumber, cpf, cnpj)
        val requestBody = objectMapper.writeValueAsString(signUpRequest).toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url("http://localhost:8080/api/users/signup")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val successLabel = Label("Account created successfully")
                snackBar.style = "-fx-background-color: green;"
                snackBar.enqueue(JFXSnackbar.SnackbarEvent(successLabel))
            } else {
                val errorLabel = Label("Account creation failed")
                snackBar.style = "-fx-background-color: red;"
                snackBar.enqueue(JFXSnackbar.SnackbarEvent(errorLabel))
            }
        }
    }
}
