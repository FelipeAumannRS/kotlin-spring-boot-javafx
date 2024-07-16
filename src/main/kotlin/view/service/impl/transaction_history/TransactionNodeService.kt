package view.service.impl.transaction_history

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import view.component.SessionManager
import view.model.Transaction
import view.model.User
import view.service.use_case.transaction_history.TransactionNodeUseCase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class TransactionNodeService : TransactionNodeUseCase {

    private val client = OkHttpClient()
    private val objectMapper = jacksonObjectMapper()

    override fun setTransactionData(
        transaction: Transaction,
        label_amount: Label,
        label_timeStamp: Label,
        label_receiverUserName: Label,
        imageView_sentOrReceived: ImageView
    ) {
        label_amount.text = transaction.amount.toString()

        val dateTime = LocalDateTime.parse(transaction.timestamp)
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        label_timeStamp.text = dateTime.format(formatter)

        if (transaction.senderId == SessionManager.getLoggedInUser()?.id) {
            imageView_sentOrReceived.image = Image("user-interface/icons/red-arrow.png", 21.0, 21.0, true, true)
            imageView_sentOrReceived.rotate = 180.0
            println("User sent money: ${transaction.amount}")
        } else {
            imageView_sentOrReceived.image = Image("user-interface/icons/up-arrow.png", 21.0, 21.0, true, true)
            println("User received money: ${transaction.amount}")
        }

        val request = Request.Builder()
            .url("http://localhost:8080/api/users/${transaction.receiverId}")
            .get()
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val user: User = objectMapper.readValue(response.body?.string() ?: "")
                label_receiverUserName.text = user.name
            } else {
                label_receiverUserName.text = "Unknown User"
            }
        }
    }
}
