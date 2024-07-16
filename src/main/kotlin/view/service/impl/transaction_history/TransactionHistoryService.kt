package view.service.impl.transaction_history

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import javafx.scene.Parent
import javafx.scene.layout.VBox
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import view.component.SessionManager
import view.controller.UserPageController
import view.controller.transaction_history.TransactionNodeController
import view.model.Transaction
import view.service.use_case.LoadViewUseCase
import view.service.use_case.transaction_history.TransactionHistoryUseCase
import net.rgielen.fxweaver.core.FxControllerAndView
import net.rgielen.fxweaver.core.FxWeaver

@Service
class TransactionHistoryService(private val loadViewUseCase: LoadViewUseCase,
                                private val fxWeaver: FxWeaver) : TransactionHistoryUseCase {

    private val client = OkHttpClient()
    private val objectMapper = jacksonObjectMapper()

    override fun returnToUsePage() {
        loadViewUseCase.loadView(UserPageController::class.java)
    }

    override fun populateTransactionHistory(vbox: VBox) {
        val loggedInUser = SessionManager.getLoggedInUser() ?: return
        val request = Request.Builder()
            .url("http://localhost:8080/api/transactions/history/${loggedInUser.id}")
            .get()
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val transactions: List<Transaction> = objectMapper.readValue(response.body?.string() ?: "[]")
                transactions.forEach { transaction ->
                    val nodeController: FxControllerAndView<TransactionNodeController, Parent>? = fxWeaver.load(TransactionNodeController::class.java)
                    nodeController?.controller?.setTransactionData(transaction)
                    vbox.children.add(nodeController?.view?.get())
                }
            } else {
                throw Exception("Failed to load transaction history")
            }
        }
    }
}
