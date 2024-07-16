package view.service.impl

import org.springframework.stereotype.Service
import view.component.SessionManager
import view.controller.ProfileController
import view.controller.TransactionViewController
import view.controller.transaction_history.TransactionHistoryController
import view.service.use_case.LoadViewUseCase
import view.service.use_case.UserPageUseCase

@Service
class UserPageService(private val loadViewUseCase: LoadViewUseCase) : UserPageUseCase {

    override fun logOut() {
        loadViewUseCase.returnToHomePage()
        SessionManager.clear()
    }

    override fun loadProfileView() {
        loadViewUseCase.loadView(ProfileController::class.java)
    }

    override fun loadTransactionHistoryView() {
        loadViewUseCase.loadView(TransactionHistoryController::class.java)
    }

    override fun loadTransferView() {
        loadViewUseCase.loadView(TransactionViewController::class.java)
    }
}