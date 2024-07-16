package view.service.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.jfoenix.controls.JFXSnackbar
import javafx.scene.control.Label
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service
import view.component.SessionManager
import view.controller.UserPageController
import view.model.LoginRequest
import view.model.User
import view.service.use_case.LoadViewUseCase
import view.service.use_case.LoginUseCase

@Service
class LoginService(private val loadViewUseCase: LoadViewUseCase) : LoginUseCase {

    private val client = OkHttpClient()
    private val objectMapper = jacksonObjectMapper()

    override fun validateLogin(email: String, password: String, snackBar: JFXSnackbar) {
        val loginRequest = LoginRequest(email, password)
        val requestBody = objectMapper.writeValueAsString(loginRequest).toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url("http://localhost:8080/api/users/login")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val user: User = objectMapper.readValue(response.body!!.string())
                SessionManager.setLoggedInUser(user)
                loadViewUseCase.loadView(UserPageController::class.java)
            } else {
                snackBar.enqueue(JFXSnackbar.SnackbarEvent(Label("Invalid login")))
            }
        }
    }
}
