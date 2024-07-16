package view.service.use_case

interface UserPageUseCase {

    fun logOut()
    fun loadProfileView()
    fun loadTransactionHistoryView()
    fun loadTransferView()
}