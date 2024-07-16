package view.model

data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val cpf: String,
    val cnpj: String?
)
