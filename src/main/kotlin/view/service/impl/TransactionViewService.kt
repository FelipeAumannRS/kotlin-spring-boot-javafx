package view.service.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jfoenix.controls.JFXSnackbar
import javafx.scene.control.Label
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service
import view.controller.UserPageController
import view.service.use_case.LoadViewUseCase
import view.service.use_case.TransactionViewUseCase

@Service
class TransactionViewService(private val loadViewUseCase: LoadViewUseCase) : TransactionViewUseCase {

    private val client = OkHttpClient()
    private val objectMapper = jacksonObjectMapper()

    override fun transfer(senderId: Long, receiverName: String, amount: Double, snackBar: JFXSnackbar) {
        val transferRequest = mapOf(
            "senderId" to senderId,
            "receiverName" to receiverName,
            "amount" to amount
        )
        val requestBody = objectMapper.writeValueAsString(transferRequest).toRequestBody("application/json".toMediaTypeOrNull())

        val request = Request.Builder()
            .url("http://localhost:8080/api/transactions/transfer")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val successLabel = Label("Transfer successful")
                snackBar.enqueue(JFXSnackbar.SnackbarEvent(successLabel))
            } else {
                val failLabel = Label("Transfer failed")
                snackBar.enqueue(JFXSnackbar.SnackbarEvent(failLabel))
                throw Exception("Transfer failed: ${response.message}")
            }
        }
    }

    override fun returnToUsePage() {
        loadViewUseCase.loadView(UserPageController::class.java)
    }
}