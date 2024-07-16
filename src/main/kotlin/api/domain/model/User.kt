package api.domain.model

data class User (
    val id: String,
    val password: String,
    val email: String,
    val cpf: String,
    val cnpj: String?,
    val celNumber: String,
    val name: String,
    val balance: Double,
    val transactions: List<Transaction>
)